package com.example.back_end.controller;

import com.example.back_end.dto.CustomerSaveDto;
import com.example.back_end.service.customer.ICustomerServiceCreateUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("customer/api")
@CrossOrigin("*")
public class CustomerControllerSave {
    @Autowired
    private ICustomerServiceCreateUpdate customerServiceCreateUpdate;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CustomerSaveDto findId(@PathVariable Long id) {
        return customerServiceCreateUpdate.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Validated @RequestBody CustomerSaveDto customerSaveDto, BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            customerServiceCreateUpdate.create(customerSaveDto);
        } else {
            getResponseEntity(bindingResult);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void update(@Validated @PathVariable Long id, @RequestBody CustomerSaveDto customerSaveDto, BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            customerServiceCreateUpdate.update(id,customerSaveDto);
        } else {
            getResponseEntity(bindingResult);
        }
    }

    private void getResponseEntity(BindingResult bindingResult) {
        Map<String, String> map = new LinkedHashMap<>();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            if (!map.containsKey(error.getField())) {
                map.put(error.getField(), error.getDefaultMessage());
            }
        }
    }
}
