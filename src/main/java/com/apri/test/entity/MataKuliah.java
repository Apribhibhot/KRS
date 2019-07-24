/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apri.test.entity;

import javax.persistence.Column;

public class MataKuliah {

    protected int id;

    @Column(name = "mata_kuliah")
    private String mataKuliah;
    private int sks;

    public MataKuliah() {

    }

    public MataKuliah(int id, String mataKuliah, int sks) {
        this.id = id;
        this.mataKuliah = mataKuliah;
        this.sks = sks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
}
