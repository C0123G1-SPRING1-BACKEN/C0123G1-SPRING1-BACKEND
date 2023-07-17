package com.example.back_end.service.impl;


import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.*;
import com.example.back_end.repository.ContractRepository;
import com.example.back_end.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    /**
     * Create by : TriPD
     * Date created : 13/07/2023
     * Function : findContractById(),updateContract()
     *
     * @param : id
     * return: new Contract
     */
    @Autowired
    private IContractRepository icontractRepository;


    @Override
    public Contracts findContractById(Long id) {
        return icontractRepository.findContractById(id);
    }

    @Transactional
    @Override
    public void saveContract(ContractDto contractDto) {
        Contracts contract = new Contracts();
//        BeanUtils.copyProperties(contractDto,contract);
//        contractRepository.saveContract(contract);
        contract.setProductName(contractDto.getProductName());
        contract.setContractCode(contractDto.getContractCode());
        contract.setLoans(contractDto.getLoans());
        contract.setProfit(contractDto.getProfit());
        contract.setImage(contractDto.getImage());
        contract.setStartDate(contractDto.getStartDate());
        contract.setEndDate(contractDto.getEndDate());
//        contract.setCreateDate(contractDto.getCreateDate());
//        contract.setUpdateDate(contractDto.getUpdateDate());
//        contract.setDelete(contractDto.isDelete());
        contract.setProductType(new ProductType(contractDto.getProductType()));
        contract.setCustomers(new Customers(contractDto.getCustomers()));
        contract.setContractStatus(new ContractStatus(contractDto.getContractStatus()));
        contract.setEmployees(new Employees(contractDto.getEmployees()));
        contract.setContractType(new ContractType(contractDto.getContractType()));

        icontractRepository.saveContract(
                contract.getContractCode(),
                contract.getProductName(),
                contract.getLoans(),
                contract.getProfit(),
                contract.getImage(),
                contract.getStartDate(),
                contract.getEndDate(),
                contract.isDelete(),
                contract.getProductType().getId(),
                contract.getCustomers().getId(),
                contract.getContractStatus().getId(),
                contract.getEmployees().getId(),
                contract.getContractType().getId(),
                contract.getId()
        );

    }


    @Override
    public List<Contracts> showTop10NewContract() {

        return icontractRepository.showTop10NewContract();

    }


    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: get page transaction history from Database
     * <p>
     *
     * @param page
     * @return Page<IContractProjection>
     */

    @Override
    public Page<IContractProjection> findAllTransactionHistory(Integer page, Integer limit) {
        return icontractRepository.findAllTransactionHistoryByDeleteIsFalse(PageRequest.of(page, limit, Sort.by("startDate").descending()));
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: delete transaction history
     * <p>
     *
     * @param id
     * @return boolean
     */

    @Override
    @Transactional
    public Boolean deleteTransactionHistoryById(Long id) {
        try {
            icontractRepository.deleteContractById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: search transaction history from Database
     * <p>
     *
     * @param contractSearchDTO
     * @return ContractDTO
     */

    @Override
    public Page<IContractProjection> searchTransactionHistory(Integer page, Integer limit, ContractSearchDTO contractSearchDTO) {
        Page<IContractProjection> projectionPage = icontractRepository.searchTransactionHistory(PageRequest.of(page, limit, Sort.by("startDate").descending()),
                "%" + contractSearchDTO.getCustomerName() + "%", "%" + contractSearchDTO.getProductName() + "%",
                contractSearchDTO.getStartDate(), contractSearchDTO.getEndDate(), contractSearchDTO.getContractType(), contractSearchDTO.getContractStatus());
        return projectionPage;
    }

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: find transaction history from Database
     * <p>
     *
     * @param id
     * @return ContractDTO
     */

    @Override
    public Optional<Contracts> findTransactionHistoryById(Long id) {
        return iContractRepository.findContractsById(id);

    }

    @Override
    public List<Contracts> findAll() {
        return icontractRepository.findAllContracts();
    }

    @Transactional
    @Override
    public void createContract(Contracts contracts) {
        icontractRepository.createContract(
               contracts.getCustomers().getId(),
                contracts.getContractCode(),
                contracts.getProductName(),
                contracts.getProductType().getId(),
                contracts.getImage(),
                contracts.getLoans(),
                contracts.getStartDate(),
                contracts.getEndDate(),
                contracts.getProfit(),
                contracts.getContractStatus().getId(),
                contracts.getContractType().getId(),
                contracts.getEmployees().getId());


    }
}
