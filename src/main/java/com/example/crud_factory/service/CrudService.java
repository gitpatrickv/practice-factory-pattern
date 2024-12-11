package com.example.crud_factory.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CrudService {
    private static final Logger log = LoggerFactory.getLogger(CrudService.class);
    protected abstract String save();
    protected abstract String update();
    protected abstract String delete();
    protected abstract String getOne();
    protected abstract String moduleName();

    public final String create(){
        log.info("Saving {} ", this.moduleName());
        return this.save();
    }
    public final String retrieve(){
        log.info("retrieved {} ", this.moduleName());
        return this.getOne();
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
