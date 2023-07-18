package com.example.back_end.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateOfBirthValidator.class)
public @interface YearOldValid {
    String message() default "Bạn nhập ngày tháng năm sinh chưa chính xác. Hệ thống quy định người dùng trên 18 tuổi. Vui lòng kiểm tra lại";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
