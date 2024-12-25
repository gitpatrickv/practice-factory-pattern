package com.example.crud_factory.dto;

import com.example.crud_factory.validator.marker.CreateInfo;
import com.example.crud_factory.validator.marker.UpdateInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostModel extends Model{
    @Null(groups = CreateInfo.class)
    @NotNull(groups = UpdateInfo.class)
    private Long postId;
    @NotNull
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

}
