package com.example.back_end.controller;

import com.example.back_end.model.ProductType;
import com.example.back_end.model.RegisterPawn;
import com.example.back_end.service.IProductTypeService;
import com.example.back_end.service.IRegisterPawnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/register")
@CrossOrigin("*")
public class RegisterPawnController {
    @Autowired
    private IRegisterPawnService iRegisterPawnService ;

    @Autowired
    private IProductTypeService productTypeService;



    @PostMapping("/create")
    public void createRegisterPawn(@RequestBody RegisterPawn registerPawn){
            iRegisterPawnService.createRegisterPawn(registerPawn);
    }

    @GetMapping("/product-type")
    public ResponseEntity<List<ProductType>> getList() {
        return new ResponseEntity<>(productTypeService.getAll(), HttpStatus.OK);
    }







}
