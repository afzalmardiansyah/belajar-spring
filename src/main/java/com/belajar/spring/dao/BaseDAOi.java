package com.belajar.spring.dao;
import java.util.List;

/**
 * Created by afzalmardiansyah on 20/01/19
 * @param <U>
 */
public interface BaseDAOi<U> {
    U save(U param);

    U update(U param);

    int delete(U param);

    List<U> find();

    U findById(int id);
}
