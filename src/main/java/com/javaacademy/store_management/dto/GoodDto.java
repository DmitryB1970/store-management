package com.javaacademy.store_management.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodDto {
    private String name;
    private BigDecimal price;
}
