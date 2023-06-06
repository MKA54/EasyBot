package com.example.easybot.dao;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
    @Transactional
    void create(T obj);

    @Transactional
    void update(T obj);

    @Transactional
    void remove(T obj);

    @Transactional
    List<T> findAll();

    @Transactional
    T getProductById(Integer id);
}
