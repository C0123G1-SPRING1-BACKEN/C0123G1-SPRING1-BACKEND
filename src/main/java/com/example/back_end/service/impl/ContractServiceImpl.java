package com.example.back_end.service.impl;

import com.example.back_end.projections.ContractDTO;
import com.example.back_end.repository.IContractRepository;
import com.example.back_end.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: get page transaction history from Database
     * <p>
     * @param page
     *
     * @return contractsPage
     */

    @Override
    public Page<ContractDTO> findAllContract(Integer page) {
        Page<ContractDTO> contractsPage = iContractRepository.findAllByDeleteIsFalse(PageRequest.of(page, 5));
        return contractsPage;
    }
    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: delete transaction history
     * <p>
     * @param id
     *
     * @return boolean
     */

    @Override
    public Boolean deleteContractById(Integer id) {
        return null;
    }
    /**
     * Created by: ThienNT
     * Date created: 13/07/2023
     * Function: find transaction history from Database
     * <p>
     * @param id
     *
     * @return ContractDTO
     */
    @Override
    public ContractDTO findContractById(Integer id) {
        return null;
    }

}
