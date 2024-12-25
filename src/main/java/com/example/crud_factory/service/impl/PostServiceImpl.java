package com.example.crud_factory.service.impl;

import com.example.crud_factory.dto.Model;
import com.example.crud_factory.dto.PostModel;
import com.example.crud_factory.entity.Post;
import com.example.crud_factory.repository.PostRepository;
import com.example.crud_factory.service.CrudService;
import com.example.crud_factory.service.PostService;
import com.example.crud_factory.service.factory.Module;
import com.example.crud_factory.util.EntityToModelMapper;
import com.example.crud_factory.util.ModelToEntityMapper;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PostServiceImpl extends CrudService implements PostService {

    private final PostRepository postRepository;
    private final Validator validator;

    private ModelToEntityMapper<PostModel, Post> modelToEntityMapper = new ModelToEntityMapper<>(Post.class);
    private EntityToModelMapper<Post, PostModel> entityToModelMapper = new EntityToModelMapper<>(PostModel.class);

    @Override
    protected <T extends Model> Model save(T model) {
        Post post = modelToEntityMapper.map((PostModel) model);
        post.setTimestamp(LocalDateTime.now());
        Post savedPost = postRepository.save(post);
        return entityToModelMapper.map(savedPost);
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
    protected List<PostModel> getAll() {
        return postRepository.findAll()
                .stream()
                .map((post) -> entityToModelMapper.map(post))
                .toList();
    }

    @Override
    protected PostModel getOne(String id) {
        Optional<Post> optionalPost = this.getPostById(id);
        return optionalPost.map(post -> entityToModelMapper.map(post))
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

    @Override
    protected Validator validator() {
        return validator;
    }

    @Override
    public Optional<Post> getPostById(String id) {
        return postRepository.findById(Long.parseLong(id));
    }
}