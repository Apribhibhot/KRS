/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apri.test.service;

import com.apri.test.dao.BaseDAO;
import com.apri.test.entity.Krs;

import java.util.List;

public interface KrsService extends BaseDAO<Krs> {

    List<Krs> findByNim(int nim);

    List<Krs> findByNim2(int nim);

    Krs createKrs(Krs param);

    void deleteById(int id);

    List<Krs> findAllKrs(int nim);

    List<Krs> findByNimSks(int nim);

    Krs findMaksByNim(int nim);
}
