package com.apri.test.dao.impl;

import com.apri.test.dao.KrsDAO;
import com.apri.test.entity.Krs;
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
public class KrsDAOImpl implements KrsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Krs save(Krs param) {
        return param;
    }

    @Override
    public Krs update(Krs param) {
        return param;
    }

    @Override
    public int delete(Krs param) {
        String sql = "delete from table_krs where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId());
            return ps;
        });
        return rtn;
    }

    @Override
    public Krs findById(int id) {
        String sql = "select * from table_krs where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Krs.class));
    }

    @Override
    public List<Krs> findByNim(int nim) {
        String sql = "select id, mata_kuliah as matakuliah, sks from table_matakuliah where id in (select id_matakuliah from table_krs where nim =?)";
        return jdbcTemplate.query(sql, new Object[]{nim}, new BeanPropertyRowMapper<>(Krs.class));
    }

    @Override
    public List<Krs> findByNim2(int nim) {
        String sql = "select id, mata_kuliah as matakuliah, sks from table_matakuliah where id not in (select id_matakuliah from table_krs where nim =?)";
        return jdbcTemplate.query(sql, new Object[]{nim}, new BeanPropertyRowMapper<>(Krs.class));
    }


    @Override
    public Krs createKrs(Krs param) {
        String sql = "insert into table_krs (nim, id_matakuliah) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getNim());
            ps.setInt(2, param.getId());
            return ps;
        }, keyHolder);
        param.setNim(keyHolder.getKey().intValue());
        return param;
    }



    @Override
    public void deleteById(int id) {
        String sql = "delete from table_krs where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id);
            return ps;
        });

    }

    @Override
    public List<Krs> findAllKrs(int nim) {
        String sql = "select a.id as idkrs, a.nim, p.mahasiswa, q.id, q.mata_kuliah as matakuliah, q.sks from table_krs a join table_mahasiswa p ON a.nim=p.nim join table_matakuliah q ON a.id_matakuliah=q.id where p.nim=?;";

        return jdbcTemplate.query(sql, new Object[]{nim}, new BeanPropertyRowMapper<>(Krs.class));
    }

    @Override
    public List<Krs> findByNimSks(int nim) {
        String sql = "select a.id, a.nim, p.mahasiswa, q.mata_kuliah, sum(q.sks) as sks from table_krs a join table_mahasiswa p ON a.nim=p.nim join table_matakuliah q ON a.id_matakuliah=q.id where a.nim=?;";

        return jdbcTemplate.query(sql, new Object[]{nim}, new BeanPropertyRowMapper<>(Krs.class));
    }

    @Override
    public Krs findMaksByNim(int nim) {
        String sql = "select * from table_mahasiswa where nim=?;";
        return jdbcTemplate.queryForObject(sql, new Object[]{nim}, new BeanPropertyRowMapper<>(Krs.class));
    }


    @Override
    public List<Krs> findAll() {
            String sql = "select a.id, p.mahasiswa, p.nim, q.mata_kuliah as matakuliah from table_krs a join table_mahasiswa p ON a.nim=p.nim join table_matakuliah q ON a.id_matakuliah=q.id;";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Krs.class));
    }


}