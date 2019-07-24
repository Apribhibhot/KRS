package com.apri.test.service.impl;

import com.apri.test.dao.MataKuliahDAO;
import com.apri.test.entity.MataKuliah;
import com.apri.test.service.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MataKuliahServiceImpl implements MataKuliahService {

    @Autowired
    private MataKuliahDAO mataKuliahDAO;

    @Override
    public List<MataKuliah> findByMataKuliah(MataKuliah param) {
        return mataKuliahDAO.findByMataKuliah(param);
    }

    @Override
    public MataKuliah save(MataKuliah param) {
        return mataKuliahDAO.save(param);
    }

    @Override
    public MataKuliah update(MataKuliah param) {
        return mataKuliahDAO.update(param);
    }

    @Override
    public int delete(MataKuliah param) {
        return mataKuliahDAO.delete(param);
    }

    @Override
    public MataKuliah findById(int id) {
        return mataKuliahDAO.findById(id);
    }

    @Override
    public List<MataKuliah> findAll() {
        return mataKuliahDAO.findAll();
    }
}
