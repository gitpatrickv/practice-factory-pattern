package com.example.crud_factory.repository;

import com.example.crud_factory.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
