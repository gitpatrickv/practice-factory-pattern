package com.example.crud_factory.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel extends Model{
    private Integer productId;
    private String productName;
    private Double price;
    private String description;
}
