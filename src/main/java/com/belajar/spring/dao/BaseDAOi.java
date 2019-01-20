package com.belajar.spring.dao;
import java.util.List;


public interface BaseDAOi<U> {
    U save(U param);

    U update(U param);

    int delete(U param);

    List<U> find();

    U findById(int id);
}
