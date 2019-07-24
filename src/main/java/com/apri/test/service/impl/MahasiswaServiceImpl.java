package com.apri.test.service.impl;

import com.apri.test.dao.MahasiswaDAO;
import com.apri.test.entity.Mahasiswa;
import com.apri.test.service.MahasiswaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MahasiswaServiceImpl implements MahasiswaService {

    @Autowired
    private MahasiswaDAO mahasiswaDAO;

    @Override
    public List<Mahasiswa> findByMahasiswa(Mahasiswa param) {
        return mahasiswaDAO.findByMahasiswa(param);
    }

    @Override
    public Mahasiswa findByNim(int nim) {
        return mahasiswaDAO.findByNim(nim);
    }

    @Override
    public Mahasiswa save(Mahasiswa param) {
        return mahasiswaDAO.save(param);
    }

    @Override
    public Mahasiswa update(Mahasiswa param) {
        return mahasiswaDAO.update(param);
    }

    @Override
    public int delete(Mahasiswa param) {
        return mahasiswaDAO.delete(param);
    }

    @Override
    public Mahasiswa findById(int id) {
        return mahasiswaDAO.findById(id);
    }

    @Override
    public List<Mahasiswa> findAll() {
        return mahasiswaDAO.findAll();
    }
}
