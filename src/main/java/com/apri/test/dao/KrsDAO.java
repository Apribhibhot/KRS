package com.apri.test.dao;

import com.apri.test.entity.Krs;

import java.util.List;

public interface KrsDAO extends BaseDAO<Krs>{

    List<Krs> findByNim(int nim);

    List<Krs> findByNim2(int nim);

    Krs createKrs(Krs param);

    void deleteById(int id);

    List<Krs> findAllKrs(int nim);

    List<Krs> findByNimSks(int nim);

    Krs findMaksByNim(int nim);
}
