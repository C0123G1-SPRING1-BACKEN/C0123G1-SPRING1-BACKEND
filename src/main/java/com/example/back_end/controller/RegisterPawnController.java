package com.example.back_end.controller;

import com.example.back_end.dto.RegisterDTO;
import com.example.back_end.model.ProductType;
import com.example.back_end.model.RegisterPawn;
import com.example.back_end.service.IProductTypeService;
import com.example.back_end.service.IRegisterPawnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.BindingType;
import java.util.ArrayList;
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
    public ResponseEntity<?> createRegisterPawn(
            @Validated @RequestBody RegisterDTO registerDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> list = new HashMap();
            if (bindingResult.getFieldError("name") != null) {
                list.put("name", bindingResult.getFieldError("name").getDefaultMessage());
            }
            if (bindingResult.getFieldError("phone") != null) {
                list.put("phone", bindingResult.getFieldError("phone").getDefaultMessage());


            }
            if (bindingResult.getFieldError("address") != null) {
                list.put("address", bindingResult.getFieldError("address").getDefaultMessage());


            }
            if (bindingResult.getFieldError("email") != null) {
                list.put("email", bindingResult.getFieldError("email").getDefaultMessage());

            }
            if (bindingResult.getFieldError("contentNote") != null) {
                list.put("contendNote", bindingResult.getFieldError("contentNote").getDefaultMessage());

            }


            return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
        }
        iRegisterPawnService.createRegisterPawn(registerDTO);
        return ResponseEntity.ok("Đăng Ký Cầm Đồ Thành Công ");
    }


//    @GetMapping("/product-type")
//    public ResponseEntity<List<ProductType>> getList() {
//        if (productTypeService.getAll() == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(productTypeService.getAll(), HttpStatus.OK);
//    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> confirmRegister (@PathVariable("id") Long id) {
        iRegisterPawnService.confirmRegister(id);
         return new ResponseEntity<>(HttpStatus.OK) ;
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
