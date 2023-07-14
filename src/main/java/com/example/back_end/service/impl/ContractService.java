package com.example.back_end.service.impl;

import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.*;
import com.example.back_end.repository.ContractRepository;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    /**
     * Create by : TriPD
     * Date created : 13/07/2023
     * Function : findContractById(),updateContract()
     * @param : id
     * return: new Contract
     */
    @Autowired
   private ContractRepository contractRepository;


    @Override
    public Optional<Contracts> findContractById(Long id) {
        return contractRepository.findContractById(id);
    }

    @Override
    public void saveContract(Long id, ContractDto contractDto) {
        Optional<Contracts> contract = contractRepository.findById(id);


        // Đổ dữ liệu từ DTO sang Entity
        contract.get().setProductName(contractDto.getProductName());
        contract.get().setContractCode(contractDto.getContractCode());
        contract.get().setLoans(contractDto.getLoans());
        contract.get().setProfit(contractDto.getProfit());
        contract.get().setImage(contractDto.getImage());
        contract.get().setStartDate(contractDto.getStartDate());
        contract.get().setEndDate(contractDto.getEndDate());
        contract.get().setCreateTime(contractDto.getCreateDate());
        contract.get().setUpdateDate(contractDto.getUpdateDate());
        contract.get().setDelete(contractDto.isDelete());
        contract.get().setProductType(new ProductType(contractDto.getProductType()));
        contract.get().setCustomers(new Customers(contractDto.getCustomers()));
        contract.get().setContractStatus(new ContractStatus(contractDto.getContractStatus()));
        contract.get().setEmployees(new Employees(contractDto.getEmployees()));
        contract.get().setContractType(new ContractType(contractDto.getContractType()));

        contractRepository.saveContract(
                contract.get().getProductName(),
                contract.get().getContractCode(),
                contract.get().getLoans(),
                contract.get().getProfit(),
                contract.get().getImage(),
                contract.get().getStartDate(),
                contract.get().getEndDate(),
                contract.get().getCreateTime(),
                contract.get().getUpdateDate(),
                contract.get().isDelete(),
                contract.get().getProductType().getId(),
                contract.get().getCustomers().getId(),
                contract.get().getContractStatus().getId(),
                contract.get().getEmployees().getId(),
                contract.get().getContractType().getId(),
                id
        );


    }


    @Override
    public List<Contracts> showTop10NewContract() {
        return contractRepository.showTop10NewContract();
    }
}
