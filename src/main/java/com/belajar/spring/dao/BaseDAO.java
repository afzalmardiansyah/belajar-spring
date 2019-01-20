package com.belajar.spring.dao;

import java.util.List;

/**
 * Created by sukenda on 29/07/18.
 * Edited by afzalmardiansyah 0n 20/01/19.
 * Project belajar-spring
 */
public interface BaseDAO<T> {

    T save(T param);

    T update(T param);

    int delete(T param);

    List<T> find();

    T findById(int id);

}
