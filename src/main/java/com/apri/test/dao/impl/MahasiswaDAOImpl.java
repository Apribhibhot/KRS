package com.apri.test.dao.impl;

import com.apri.test.dao.MahasiswaDAO;
import com.apri.test.entity.Mahasiswa;
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
public class MahasiswaDAOImpl implements MahasiswaDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Mahasiswa> findByMahasiswa(Mahasiswa param) {
        String sql = "select * from table_mahasiswa where mahasiswa like ? ";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getMahasiswa() + "%" }, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }


    @Override
    public Mahasiswa save(Mahasiswa param) {
        String sql = "insert into table_mahasiswa (mahasiswa, maks) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getMahasiswa());
            ps.setInt(2, param.getMaks());
            return ps;
        }, keyHolder);
        param.setNim(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public Mahasiswa update(Mahasiswa param) {
        String sql = "update table_mahasiswa set mahasiswa=?, maks=? where nim=?";
        int mhs = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getMahasiswa());
            ps.setInt(2, param.getMaks());
            ps.setInt(3, param.getNim());
            return ps;
        });
        param.setNim(mhs);
        return param;
    }

    @Override
    public int delete(Mahasiswa param) {
        String sql = "delete from table_mahasiswa where nim=?";
        int mhs = jdbcTemplate.update(connection -> {
           PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1, param.getNim());
           return ps;
        });
        return mhs;
    }

    @Override
    public Mahasiswa findById(int id) {
        String sql = "select * from table_mahasiswa where nim=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }

    @Override
    public Mahasiswa findByNim(int nim) {
        String sql = "select * from table_mahasiswa where nim=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{nim}, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }

    @Override
    public List<Mahasiswa> findAll() {
        String sql = "select * from table_mahasiswa";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }
}
