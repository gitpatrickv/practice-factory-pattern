package com.example.crud_factory.service.impl;

import com.example.crud_factory.dto.Model;
import com.example.crud_factory.dto.PostModel;
import com.example.crud_factory.entity.Post;
import com.example.crud_factory.repository.PostRepository;
import com.example.crud_factory.service.CrudService;
import com.example.crud_factory.service.factory.Module;
import com.example.crud_factory.util.Mapper;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class PostServiceImpl extends CrudService {

    private final PostRepository postRepository;
    private final Mapper mapper;

    @Override
    protected String save() {
        return "Saving post";
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
        return mapper.mapEntityToModel(post.get(), PostModel.class);
    }

    @Override
    protected String moduleName() {
        return Module.post.getModuleName();
    }
}
