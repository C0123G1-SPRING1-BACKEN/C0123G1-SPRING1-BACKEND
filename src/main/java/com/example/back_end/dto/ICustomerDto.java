package com.example.back_end.dto;

import javax.validation.constraints.NotNull;

public interface ICustomerDto {
    String getId();
    String getName();
    String getCitizenCode();
    String getQuantityContract();
}
