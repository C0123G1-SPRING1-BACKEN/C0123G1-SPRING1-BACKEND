package com.example.back_end.service.contracts.impl;

import com.example.back_end.dto.IContractDto;
import com.example.back_end.dto.LiquidationsDto;
import com.example.back_end.model.ContractStatus;
import com.example.back_end.model.Contracts;
import com.example.back_end.projections.IMinAndMaxProjection;
import com.example.back_end.repository.IContractStatusRepository;
import com.example.back_end.repository.IContractTypeRepository;
import com.example.back_end.repository.IContractsRepository;
import com.example.back_end.service.contracts.IContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractsServiceImpl implements IContractsService {
    @Autowired
    private IContractsRepository contractsRepository;

    @Autowired
    private IContractTypeRepository contractTypeRepository;

    @Autowired
    private IContractStatusRepository contractStatusRepository;

    @Override
    public Page<IContractDto> findAllProduct(Pageable pageable, String productName, String productType, String loans) {

        switch (loans) {
            case "1":
                return contractsRepository.finAllProduct(pageable, productName, productType, "0", "5000000");
            case "2":
                return contractsRepository.finAllProduct(pageable, productName, productType, "5000000", "10000000");
            case "3":
                return contractsRepository.finAllProduct(pageable, productName, productType, "10000000", "20000000");
            case "4":
                return contractsRepository.finAllProduct(pageable, productName, productType, "20000000", "20000000000");
            default:
                return contractsRepository.finAllProduct(pageable, productName, productType, "0", "2000000000000000000000000");
        }
    }

    @Override
    public IContractDto findContractById(Long id) {
        return contractsRepository.findContractById(id);
    }

    @Transactional(rollbackOn = Throwable.class)
    @Override
    public void createLiquidationContract(LiquidationsDto liquidationsDto) {

        List<Long> contractIds = Arrays.stream(liquidationsDto
                .getProducts().split(",")).map(Long::parseLong).collect(Collectors.toList());
        List<Contracts> expiredContracts = this.contractsRepository.findByIdIsInAndContractStatus_Id(contractIds, 4L);

        if (contractIds.size() != expiredContracts.size()) {
            throw new IllegalArgumentException("Selected contract not found");
        }
        Contracts contracts = new Contracts();
        contracts.setContractCode(String.valueOf(Math.round(Math.random() * 100000)));
        contracts.setContractType(this.contractTypeRepository.findById(2L).get());
        ContractStatus contractStatus = this.contractStatusRepository.findById(5L).get();
        contracts.setContractStatus(contractStatus);
        contracts.setCustomers(liquidationsDto.getCustomers());
        contracts.setEmployees(liquidationsDto.getEmployees());
        contracts.setProductName(expiredContracts.stream().map(Contracts::getProductName).collect(Collectors.joining(",")));
        contracts.setLoans(expiredContracts.stream().mapToLong(Contracts::getLoans).sum());
        contracts.setProfit(expiredContracts.stream().mapToLong(Contracts::getProfit).sum());
        contracts.setImage(expiredContracts.stream().map(Contracts::getImage).collect(Collectors.joining("||")));
        contracts.setStartDate(LocalDate.now().toString());
        contracts.setEndDate(LocalDate.now().toString());
        contracts.setProductType(expiredContracts.get(0).getProductType());
        contracts.setLinkContracts(liquidationsDto.getProducts());
        this.contractsRepository.save(contracts);
        expiredContracts.forEach(ec -> ec.setContractStatus(contractStatus));
        this.contractsRepository.saveAll(expiredContracts);
    }

}
