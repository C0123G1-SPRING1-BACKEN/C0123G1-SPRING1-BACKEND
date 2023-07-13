package com.example.back_end.service;

import com.example.back_end.model.Contracts;

import java.util.List;

public interface IContractService {
    List<Contracts> findAll();

    //   void saveContracts(Long customerId,String contractCode,String productName,
//                      Long productTypeId,String image,Long loans,String startDate,
//                      String endDate, Long profit,Long contractStatusId,Long contractTypeId,Long employeesId);
    void createContract(Contracts contracts);
}
