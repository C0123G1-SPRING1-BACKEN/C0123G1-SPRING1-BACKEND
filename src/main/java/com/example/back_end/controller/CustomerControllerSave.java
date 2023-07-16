package com.example.back_end.controller;

import com.example.back_end.dto.CustomerSaveDto;
import com.example.back_end.service.customer.ICustomerServiceCreateUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/customer")
@CrossOrigin("*")
public class CustomerControllerSave {
    @Autowired
    private ICustomerServiceCreateUpdate customerServiceCreateUpdate;

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : find customer with corresponding id of customer
     * <p>
     * @param id
     * @return HttpStatus.NOT_FOUND if result= null else then return customerSaveDto and HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdCustomer(@PathVariable Long id) {
        CustomerSaveDto customerSaveDto = customerServiceCreateUpdate.findByIdCustomer(id);
        if (customerSaveDto == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(customerSaveDto, HttpStatus.OK);
    }

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : create new customer
     * <p>
     * @param customerSaveDto, bindingResult
     * @return status Created
     */
    @PostMapping("/")
    public ResponseEntity<?> createCustomer(@Validated @RequestBody CustomerSaveDto customerSaveDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            customerServiceCreateUpdate.createCustomer(customerSaveDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            getResponseEntity(bindingResult);
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : update customer
     *
     * @return HttpStatus.EXPECTATION_FAILED if result is error else then return customerSaveDto object HttpStatus.OK
     * @param id
     * @requestBody CustomerSaveDto includes the customer object
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@Validated @RequestBody CustomerSaveDto customerSaveDto, BindingResult bindingResult,@PathVariable Long id) {
        if (!bindingResult.hasErrors()) {
            customerServiceCreateUpdate.updateCustomer(id, customerSaveDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            getResponseEntity(bindingResult);
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Create by: DatNT,
     * Date create : 13/07/2023
     * Function : getResponseEntity
     *
     * @param bindingResult
     */
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
