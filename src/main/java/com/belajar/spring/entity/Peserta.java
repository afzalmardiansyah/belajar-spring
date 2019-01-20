package com.belajar.spring.entity;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sukenda on 29/07/18.
 * Edited by afzalmardiansyah 0n 20/01/19.
 * Project belajar-spring
 */
@Getter
@Setter
public class Peserta implements Serializable {

    private int id;

    private String name;

    private String address;

    private List<Identity> identityList;

    public Peserta() {
    }

    public Peserta(int id) {
        this.id = id;
    }

    public Peserta(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Peserta(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    @Override
//    public String toString() {
//        return "Peserta{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                '}';
//    }
}

