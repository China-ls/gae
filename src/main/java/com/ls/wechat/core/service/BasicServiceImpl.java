package com.ls.wechat.core.service;

import com.ls.wechat.core.repositories.BasicRepository;
import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public abstract class BasicServiceImpl<T, ID extends Serializable> implements BasicService<T, ID> {

    private static Logger log = LoggerFactory.getLogger(BasicService.class);

    public abstract BasicRepository<T, ID> getRepository();

    @Override
    public T save(T t) {
        return getRepository().save(t);
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> iterable) {
        return getRepository().save(iterable);
    }

    @Override
    public T findById(ID id) {
        try {
            return getRepository().findOne(id);
        } catch (SQLGrammarException e) {
            if (log.isDebugEnabled()) {
                log.debug("error find by id : {}", id, e);
            }
        }
        return null;
    }

    @Override
    public void deleteById(ID id) {
        try {
            getRepository().delete(id);
        } catch (SQLGrammarException e) {
            if (log.isDebugEnabled()) {
                log.debug("error find by id : {}", id, e);
            }
        }
    }

}
