package com.apri.test.dao;

import com.apri.test.entity.MataKuliah;

import java.util.List;

public interface MataKuliahDAO extends BaseDAO<MataKuliah> {
    List<MataKuliah> findByMataKuliah(MataKuliah param);

}
