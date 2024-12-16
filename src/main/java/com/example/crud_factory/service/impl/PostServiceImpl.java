package com.example.crud_factory.service.impl;

import com.example.crud_factory.dto.Model;
import com.example.crud_factory.dto.PostModel;
import com.example.crud_factory.entity.Post;
import com.example.crud_factory.repository.PostRepository;
import com.example.crud_factory.service.CrudService;
import com.example.crud_factory.service.factory.Module;
import com.example.crud_factory.util.Mapper;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
public class PostServiceImpl extends CrudService {

    private final PostRepository postRepository;
    private final Mapper mapper;


    @Override
    protected <T extends Model> T save(T model) {
        Post post = mapper.mapModelToEntity((PostModel) model, Post.class);
        post.setTimestamp(LocalDateTime.now());
        Post savedPost = postRepository.save(post);
        return (T) mapper.mapEntityToModel(savedPost, PostModel.class);
    }

    @Override
    protected String update() {
        return "Updating post";
    }

    @Override
    protected String delete() {
        return "Deleting post";
    }

    @Override
    protected PostModel getOne(String id) {
        Optional<Post> post = postRepository.findById(Long.parseLong(id));
        return post.map(value -> mapper.mapEntityToModel(value, PostModel.class))
                .orElse(null);
    }

    @Override
    protected String moduleName() {
        return Module.post.getModuleName();
    }

    @Override
    protected Class modelClass() {
        return PostModel.class;
    }


}