package com.example.crud_factory.util;

import com.example.crud_factory.dto.Model;
import com.example.crud_factory.entity.CommonEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
@AllArgsConstructor
public class ModelToEntityMapper <M extends Model, E extends CommonEntity>{

    private Class<E> destEntityClass;

    public E map(M model){
        ModelMapper mapper = new ModelMapper();
        return (E)mapper.map(model, this.destEntityClass);
    }

}

