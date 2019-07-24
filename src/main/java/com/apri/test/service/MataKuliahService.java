package com.apri.test.service;

import com.apri.test.entity.MataKuliah;

import java.util.List;

public interface MataKuliahService extends BaseService<MataKuliah>{
    List<MataKuliah> findByMataKuliah(MataKuliah param);
}