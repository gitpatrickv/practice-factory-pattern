package com.example.crud_factory.service;

public abstract class CrudService {
    protected abstract String save();
    protected abstract String update();
    protected abstract String delete();
    protected abstract String getOne();

    public final String create(){
        return this.save();
    }
    public final String retrieve(){
        return this.getOne();
    }

    public final String updateOne(){
        return this.update();
    }

    public final String deleteOne(){
        return this.delete();
    }
}
