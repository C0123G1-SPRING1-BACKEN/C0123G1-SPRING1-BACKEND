package com.example.back_end.controller;

import com.example.back_end.model.CustomerModel;
import com.example.back_end.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api/customer")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    //    @GetMapping("")
//    public ResponseEntity<?> findByName(@RequestParam(value = "page", defaultValue = "0")Integer page) {
//        return new ResponseEntity<>(customerService.findByNameProduct(PageRequest.of(page,3)),HttpStatus.OK);
//    }
//    @GetMapping("/")
//    public ResponseEntity<?> findByName(@RequestParam(required = false , defaultValue = "")Integer page) {
//        return new ResponseEntity<>(customerService.findByNameProduct(PageRequest.of(page,3)),HttpStatus.OK);
//    }
//    public ResponseEntity<?> findByNameProduct(@RequestParam(required = false, defaultValue = "") String name,
//                                               @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 3) Pageable pageable) {
//        return new ResponseEntity<>(iProductService.findByNameProduct(name, pageable), HttpStatus.OK);
//    }
    @GetMapping("")
    public ResponseEntity<?> findByNameCustomer(@RequestParam(required = false, defaultValue = "") String name,
                                                @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 3) Pageable pageable) {
        return new ResponseEntity<>(customerService.findByNameProduct(name, pageable), HttpStatus.OK);
    }
    @DeleteMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam(required = false)Integer id){
        customerService.deleteById(id);
    }
}