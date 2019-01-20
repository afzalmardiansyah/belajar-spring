package com.belajar.spring.controller;

import com.belajar.spring.entity.Peserta;
import com.belajar.spring.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sukenda on 29/07/18.
 * Edited by afzalmardiansyah 0n 20/01/19.
 * Project belajar-spring
 */

@RestController
public class PesertaController {

    @Autowired
    private PesertaService service;

    @GetMapping(value = "/peserta")
    public List<Peserta> peserta() {
        return service.find();
    }

    @GetMapping(value = "/peserta/{id}")
    public Peserta findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping(value = "/peserta")
    public String save(@RequestBody Peserta peserta) {
        Peserta data = service.save(peserta);
        if (data.getId() == 0) {
            return "Gagal insert data";
        } else {
            return "Insert data berhasil";
        }
    }

    @PutMapping(value = "/peserta")
    public String update(@RequestBody Peserta peserta) {
        Peserta data = service.update(peserta);
        if (data.getId() == 0) {
            return "Gagal update data";
        } else {
            return "Update data berhasil";
        }
    }

    @DeleteMapping(value = "/peserta/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int data = service.delete(new Peserta(id));
        if (data == 0) {
            return "Gagal delete data";
        } else {
            return "Delete data berhasil";
        }
    }
}
