package com.example.crud_factory.dto;

import com.example.crud_factory.validator.market.CreateInfo;
import com.example.crud_factory.validator.market.UpdateInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("product")
public class ProductModel extends Model{
    @Null(groups = CreateInfo.class)
    @NotNull(groups = UpdateInfo.class)
    private Integer productId;
    @NotNull
    private String productName;
    @NotNull
    private Double price;
    @NotNull
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
}
