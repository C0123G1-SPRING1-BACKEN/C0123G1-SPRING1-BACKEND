package com.example.back_end.controller;

import com.example.back_end.dto.RegisterDTO;
import com.example.back_end.model.ProductType;
import com.example.back_end.service.IProductTypeService;
import com.example.back_end.service.IRegisterPawnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: ThangND
 * Date created: 13/07/2023
 * Function: register pawn
 *
 * @param: registerDTO
 * @return
 */

@RestController
@RequestMapping("/api/register")
@CrossOrigin("*")
public class RegisterPawnController {
    @Autowired
    private IRegisterPawnService iRegisterPawnService;

    @Autowired
    private IProductTypeService productTypeService;


    @PostMapping("/create")
    public ResponseEntity<?> createRegisterPawn(@Validated @RequestBody RegisterDTO registerDTO) {
        iRegisterPawnService.createRegisterPawn(registerDTO);
        return ResponseEntity.ok("register pawn is create ");
    }


    @GetMapping("/product-type")
    public ResponseEntity<List<ProductType>> getList() {
        return new ResponseEntity<>(productTypeService.getAll(), HttpStatus.OK);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
