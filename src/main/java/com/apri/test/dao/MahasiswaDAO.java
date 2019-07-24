package com.apri.test.dao;

import com.apri.test.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaDAO extends BaseDAO<Mahasiswa>{

    List<Mahasiswa> findByMahasiswa(Mahasiswa param);

    Mahasiswa findByNim(int nim);

}