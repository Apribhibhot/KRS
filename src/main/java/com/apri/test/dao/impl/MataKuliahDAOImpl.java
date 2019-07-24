/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apri.test.dao.impl;

import com.apri.test.dao.MataKuliahDAO;
import com.apri.test.entity.MataKuliah;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MataKuliahDAOImpl implements MataKuliahDAO {

@Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<MataKuliah> findByMataKuliah(MataKuliah param) {
        String sql = "select * from table_matakuliah where mata_kuliah like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getMataKuliah() + "%"}, new BeanPropertyRowMapper<>(MataKuliah.class));
    }

    @Override
    public MataKuliah save(MataKuliah param) {
        String sql = "insert into table_matakuliah (mata_kuliah, sks) values (?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getMataKuliah());
            ps.setInt(2, param.getSks());
            return ps;
        }, keyHolder);
        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public MataKuliah update(MataKuliah param) {
        String sql = "update table_matakuliah set mata_kuliah=?,sks=? where id=?";

        int mk = jdbcTemplate.update(connection ->{
           PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, param.getMataKuliah());
           ps.setInt(2, param.getSks());
           ps.setInt(3, param.getId());
           return ps;
        });
        param.setId(mk);
        return param;
    }

    @Override
    public int delete(MataKuliah param) {
        String sql = "delete from table_matakuliah where id=?";
        int mk = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId());
            return ps;
        });
        return mk;
    }

    @Override
    public MataKuliah findById(int id) {
        String sql = "select * from table_matakuliah where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(MataKuliah.class));
    }

    @Override
    public List<MataKuliah> findAll() {

        String sql = "select * from table_matakuliah";
         return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MataKuliah.class));
    }
}
