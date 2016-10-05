package com.ls.wechat.core.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface BasicRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
}
