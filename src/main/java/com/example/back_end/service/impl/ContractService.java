package com.example.back_end.service.impl;


import com.example.back_end.dto.ContractDto;
import com.example.back_end.model.Contracts;
import com.example.back_end.projections.ContractSearchDTO;
import com.example.back_end.projections.ITransactionHistoryProjection;
import com.example.back_end.repository.IContractRepository;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        Contracts contract = icontractRepository.findContractById(contractDto.getId());
        contract.setContractCode(contractDto.getContractCode());
        contract.setProductName(contractDto.getProductName());
        contract.setLoans(contractDto.getLoans());
        contract.setProfit(contractDto.getProfit());
        contract.setImage(contractDto.getImage());
        contract.setStartDate(contractDto.getStartDate());
        contract.setEndDate(contractDto.getEndDate());
        contract.setDelete(contractDto.isDelete());
        contract.setProductType(contractDto.getProductType());
        contract.setCustomers(contractDto.getCustomers());
        contract.setContractStatus(contractDto.getContractStatus());
        contract.setEmployees(contractDto.getEmployees());
        contract.setContractType(contractDto.getContractType());

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
    public Page<ITransactionHistoryProjection> findAllTransactionHistory(Integer page, Integer limit) {
        return null;
    }


    @Override
    public Page<Contracts> showTop10NewContract(Pageable pageable) {

        return icontractRepository.showTop10NewContract(pageable);

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
    public Boolean deleteTransactionHistoryById(String id) {
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
    public Page<ITransactionHistoryProjection> showListAndSearchTransactionHistory(Integer page, Integer limit, ContractSearchDTO contractSearchDTO) {
        return icontractRepository.searchTransactionHistory(PageRequest.of(page, limit),
                contractSearchDTO.getCustomerName(), contractSearchDTO.getProductName(),
                contractSearchDTO.getStartDate(), contractSearchDTO.getEndDate(), contractSearchDTO.getContractType(), contractSearchDTO.getContractStatus());
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
    public Optional<Contracts> findTransactionHistoryById(String id) {
        return icontractRepository.findContractsById(id);
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