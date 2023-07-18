package com.example.back_end.service.impl;

import com.example.back_end.dto.open_contract.AllContractDTO;
import com.example.back_end.dto.open_contract.IAllContractDTO;
import com.example.back_end.dto.open_contract.IOpenContractDTO;
import com.example.back_end.dto.open_contract.OpenContractDTO;
import com.example.back_end.model.Contracts;
import com.example.back_end.model.ProductType;
import com.example.back_end.repository.IProductTypessRepository;
import com.example.back_end.repository.IRedeemingRepository;
import com.example.back_end.service.IRedeemingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedeemingService implements IRedeemingService {
    @Autowired
    private IRedeemingRepository iRedeemingRepository;

    @Autowired
    private IProductTypessRepository iProductTypessRepository;

    @Override
    public void redeems(Long id, String redeemDate) {
        System.out.println(id);
        iRedeemingRepository.redeem(id, redeemDate);
    }

    @Override
    public Page<OpenContractDTO> findPageConTract(Pageable page) {
        Page<IOpenContractDTO> iOpenContractDTOPage = iRedeemingRepository.findPageConTract(page);

        return getOpenContractDTOS(iOpenContractDTOPage);
    }

    @Override
    public Contracts findOpenContract(Long id) {
        return iRedeemingRepository.findOpenContractById(id);
    }

    @Override
    public Page<OpenContractDTO> searchPageConTract(Pageable pageable, String contractCode, String customerName, String productName, String startDate) {
        Page<IOpenContractDTO> iOpenContractDTOPage = iRedeemingRepository.searchPageConTract(pageable, contractCode, customerName, productName, startDate);


        return getOpenContractDTOS(iOpenContractDTOPage);
    }

    @Override
    public Page<AllContractDTO> findAllContractDTOS(Pageable pageable, String productName, String productType) {
        Page<IAllContractDTO> iAllContractDTOS = iRedeemingRepository.findAllContractDTOS(pageable, productName, productType);
            return getAllContractDTOS(iAllContractDTOS);
    }

    @Override
    public List<ProductType> getProductType() {
        return iProductTypessRepository.findAllType();
    }

    private Page<OpenContractDTO> getOpenContractDTOS(Page<IOpenContractDTO> iOpenContractDTOPage) {
        return iOpenContractDTOPage.map(projection -> {
            OpenContractDTO dto = new OpenContractDTO();
            dto.setContractId(projection.getContractId());
            dto.setCustomerName(projection.getCustomerName());
            dto.setLoans(projection.getLoans());
            dto.setStartDate(projection.getStartDate());
            dto.setContractCode(projection.getContractCode());
            dto.setProductName(projection.getProductName());
            dto.setProfit(projection.getProfit());
            dto.setEndDate(projection.getEndDate());
            dto.setRedeemDate(projection.getRedeemDate());
            return dto;
        });
    }



    private Page<AllContractDTO> getAllContractDTOS(Page<IAllContractDTO> iAllContractDTOS) {
        return iAllContractDTOS.map(projection -> {
            AllContractDTO dto = new AllContractDTO();
            dto.setContractId(projection.getContractId());
            dto.setCustomerName(projection.getCustomerName());
            dto.setLoans(projection.getLoans());
            dto.setStartDate(projection.getStartDate());
            dto.setContractCode(projection.getContractCode());
            dto.setProductName(projection.getProductName());
            dto.setProfit(projection.getProfit());
            dto.setEndDate(projection.getEndDate());
            dto.setProductType(projection.getProductType());
            dto.setContractStatus(projection.getContractStatus());
            return dto;
        });
    }
}
