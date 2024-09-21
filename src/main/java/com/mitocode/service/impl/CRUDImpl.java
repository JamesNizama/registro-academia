package com.mitocode.service.impl;

import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.repository.IGenericoRepo;
import com.mitocode.service.ICRUD;

import java.lang.reflect.Method;
import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericoRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        //Reflexion
        Class<?> clase = t.getClass();
        String claseNombre = clase.getSimpleName();
        String nombreMetodo = "setId" + claseNombre;
        Method setIdMetodo = clase.getMethod(nombreMetodo, id.getClass());
        setIdMetodo.invoke(t, id);

        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("No encontrado Id: " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("No encontrado Id: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("No encontrado Id: " + id));
        getRepo().deleteById(id);
    }
}
