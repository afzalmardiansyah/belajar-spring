package com.belajar.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by afzalmardiyansyah on 20/01/19.
*/
@Getter
@Setter
public class Identity implements Serializable {

    private int id;

    private int tinggibadan;

    private int beratbadan;

    public Identity() {
    }

    public Identity(int id) {
        this.id = id;
    }

    public Identity(int tinggibadan, int beratbadan) {
        this.tinggibadan = tinggibadan;
        this.beratbadan = beratbadan;
    }

    public Identity(int id, int tinggibadan, int beratbadan) {
        this.id = id;
        this.tinggibadan = tinggibadan;
        this.beratbadan = beratbadan;
    }
}