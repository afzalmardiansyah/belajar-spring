package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.PesertaDAO;
import com.belajar.spring.entity.Peserta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

/**
 * Created by sukenda on 29/07/18.
 * Edited by afzalmardiansyah 0n 20/01/19.
 * Project belajar-spring
 */

@Repository
public class PesertaDAOImpl implements PesertaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Peserta save(Peserta param) {
        String sql = "INSERT INTO " + Table.TABLE_PESERTA + " (name, address) VALUES (?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());
            return ps;
        }, keyHolder);

        param.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }

    @Override
    public Peserta update(Peserta param) {
        String sql = "UPDATE " + Table.TABLE_PESERTA + " SET " +
                "name = ?, " +
                "address = ? " +
                "WHERE id =  ? ";

        jdbcTemplate.update(sql,
                param.getName(),
                param.getAddress(),
                param.getId());

        return param;
    }

    @Override
    public int delete(Peserta param) {
        String sql = "DELETE FROM " + Table.TABLE_PESERTA + " WHERE id = ? ";

        return jdbcTemplate.update(sql, param.getId());
    }

    @Override
    public List<Peserta> find() {
        String sql = "SELECT * FROM " + Table.TABLE_PESERTA;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Peserta.class));
    }

    @Override
    public Peserta findById(int id) {
        String sql = "SELECT * FROM " + Table.TABLE_PESERTA + " WHERE id = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Peserta.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }

}
