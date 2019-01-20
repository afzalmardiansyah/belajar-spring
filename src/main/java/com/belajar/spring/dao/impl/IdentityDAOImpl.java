package com.belajar.spring.dao.impl;

import com.belajar.spring.common.Table;
import com.belajar.spring.dao.IdentityDAO;
import com.belajar.spring.entity.Identity;
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
 * Created by afzalmardiyansyah on 20/01/19
*/
@Repository
public class IdentityDAOImpl implements IdentityDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Identity save (Identity param){
        String sql = "INSERT INTO " + Table.TABLE_IDENTITY + " (tinggibadan, beratbadan) VALUES (?, ?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getTinggibadan());
            ps.setInt(2, param.getBeratbadan());
            return ps;
        }, keyHolder);

        param.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }
    @Override
    public Identity update(Identity param) {
        String sql = "UPDATE " + Table.TABLE_IDENTITY + " SET " +
                "tinggibadan = ?, " +
                "beratbadan = ? " +
                "WHERE id =  ? ";

        jdbcTemplate.update(sql,
                param.getTinggibadan(),
                param.getBeratbadan(),
                param.getId());

        return param;
    }

    @Override
    public int delete(Identity param) {
        String sql = "DELETE FROM " + Table.TABLE_IDENTITY + " WHERE id = ? ";

        return jdbcTemplate.update(sql, param.getId());
    }

    @Override
    public List<Identity> find() {
        String sql = "SELECT * FROM " + Table.TABLE_IDENTITY;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Identity.class));
    }

    @Override
    public Identity findById(int id) {
        String sql = "SELECT * FROM " + Table.TABLE_IDENTITY + " WHERE id = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Identity.class), id);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }

}
