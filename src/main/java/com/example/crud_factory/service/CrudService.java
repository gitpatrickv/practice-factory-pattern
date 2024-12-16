package com.example.crud_factory.service;

import com.example.crud_factory.dto.Model;
import com.example.crud_factory.dto.constants.ResponseCode;
import com.example.crud_factory.dto.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CrudService {
    private static final Logger log = LoggerFactory.getLogger(CrudService.class);
    protected abstract <T extends Model> T save(T model);
    protected abstract String update();
    protected abstract String delete();
    protected abstract <T extends Model> T getOne(String id);
    protected abstract String moduleName();
    protected abstract Class modelClass();

    public final Response create(String jsonRequest){
        Model object = Model.parse(jsonRequest, this.modelClass());
        Model saved = this.save(object);
        log.info("Saving {}: {}", this.moduleName(), saved);
        return new Response(ResponseCode.RESP_SUCCESS, String.format("Saved %s record to DB", this.moduleName()), saved);
    }

    public final Response retrieve(String id){
        log.info("ID provided, retrieving {} record for id: {}", this.moduleName(), id);
        Model obj = this.getOne(id);
        log.info("Object of type '{}' found", this.moduleName());
        return new Response(ResponseCode.RESP_SUCCESS, String.format("Found record for ID = %s", id), obj);
    }

    public final String updateOne(){
        log.info("Updated {} ", this.moduleName());
        return this.update();
    }

    public final String deleteOne(){
        log.info("Deleted {} ", this.moduleName());
        return this.delete();
    }
}
