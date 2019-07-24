package com.apri.test.service;

import com.apri.test.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaService extends BaseService<Mahasiswa> {

    List<Mahasiswa> findByMahasiswa(Mahasiswa param);

    Mahasiswa findByNim(int nim);
}
