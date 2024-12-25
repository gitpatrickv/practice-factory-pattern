package com.example.crud_factory.util;

import com.example.crud_factory.dto.Model;
import com.example.crud_factory.entity.CommonEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
public class EntityToModelMapper <E extends CommonEntity, M extends Model> {

    private Class<M> destModelClass;

    public M map(E entity){
        ModelMapper mapper = new ModelMapper();
        return (M) mapper.map(entity, this.destModelClass);
    }
}
