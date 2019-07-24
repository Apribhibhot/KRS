package com.apri.test.service.impl;

import com.apri.test.dao.KrsDAO;
import com.apri.test.entity.Krs;
import com.apri.test.service.KrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KrsServiceImpl implements KrsService {

    @Autowired
    private KrsDAO krsDAO;

    @Override
    public Krs save(Krs param) {
        return krsDAO.save(param);
    }

    @Override
    public Krs update(Krs param) {
        return krsDAO.update(param);
    }

    @Override
    public int delete(Krs param) {
        return krsDAO.delete(param);
    }

    @Override
    public Krs findById(int id) {
        return krsDAO.findById(id);
    }

    @Override
    public List<Krs> findAll() {
        return krsDAO.findAll();
    }

    @Override
    public List<Krs> findByNim(int nim) {
        return krsDAO.findByNim(nim);
    }

    @Override
    public List<Krs> findByNim2(int nim) {
        return krsDAO.findByNim2(nim);
    }

    @Override
    public Krs createKrs(Krs param) {
        return krsDAO.createKrs(param);
    }

    @Override
    public void deleteById(int id) {
        krsDAO.deleteById(id);
    }

    @Override
    public List<Krs> findAllKrs(int nim) {
        return krsDAO.findAllKrs(nim);
    }

    @Override
    public List<Krs> findByNimSks(int nim) {
        return krsDAO.findByNimSks(nim);
    }

    @Override
    public Krs findMaksByNim(int nim) {
        return krsDAO.findMaksByNim(nim);
    }

}
