package com.example.crud_factory.service;

import com.example.crud_factory.entity.Post;

import java.util.Optional;

public interface PostService {
    Optional<Post> getPostById(String id);
}
