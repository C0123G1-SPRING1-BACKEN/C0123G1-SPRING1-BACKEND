package com.example.back_end.service.impl;



import com.example.back_end.model.ProductType;
import com.example.back_end.repository.IProductTypeRepository;
import com.example.back_end.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private IProductTypeRepository iProductTypeRepository;


    @Override
    public List<ProductType> getAll() {
        return iProductTypeRepository.findAll();
    }


}
