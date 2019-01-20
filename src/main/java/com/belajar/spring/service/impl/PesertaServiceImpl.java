package com.belajar.spring.service.impl;

import com.belajar.spring.dao.PesertaDAO;
import com.belajar.spring.entity.Peserta;
import com.belajar.spring.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sukenda on 29/07/18.
 * Project belajar-spring
 */

@Service
public class PesertaServiceImpl implements PesertaService {

    @Autowired
    private PesertaDAO pesertaDAO;

    @Override
    public Peserta save(Peserta param) {
        return pesertaDAO.save(param);
    }

    @Override
    public Peserta update(Peserta param) {
        return pesertaDAO.update(param);
    }

    @Override
    public int delete(Peserta param) {
        return pesertaDAO.delete(param);
    }

    @Override
    public List<Peserta> find() {
        return pesertaDAO.find();
    }

    @Override
    public Peserta findById(int id) {
        return pesertaDAO.findById(id);
    }
}
