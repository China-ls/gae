package com.ls.wechat.core.service;

import java.io.Serializable;

public interface BasicService<T, ID extends Serializable> {

    T save(T t);

    <S extends T> Iterable<S> save(Iterable<S> iterable);

    T findById(ID id);

    void deleteById(ID id);
}
