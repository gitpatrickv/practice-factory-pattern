package com.example.crud_factory.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostModel extends Model{
    private Long postId;
    private String content;
}
