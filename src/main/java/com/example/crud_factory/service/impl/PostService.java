package com.example.crud_factory.service.impl;

import com.example.crud_factory.entity.Post;

import java.util.Optional;

public interface PostService {
    Optional<Post> getPostById(String id);
}
