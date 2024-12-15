package com.example.crud_factory.util;

import com.example.crud_factory.dto.Model;
import com.example.crud_factory.entity.CommonEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Mapper {

    private final ModelMapper mapper = new ModelMapper();

    public <M extends Model, E extends CommonEntity> M mapEntityToModel(E entity, Class<M> model){
        return mapper.map(entity, model);
    }

    public <M extends Model, E extends CommonEntity> E mapModelToEntity(M model ,Class<E> entity){
        return mapper.map(model, entity);
    }
}
