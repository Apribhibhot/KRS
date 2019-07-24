package com.apri.test.entity;

import javax.persistence.JoinColumn;

public class Krs {

    private int id;
    private int nim;
    private String mahasiswa;


    @JoinColumn(name = "id_matakuliah")
    private int idMataKuliah;

    @JoinColumn(name = "mata_kuliah")
    private String matakuliah;
    private int sks;
    private int maks;

    private int idkrs;

    public Krs() {
    }

    public Krs(int id, int nim, String mahasiswa, int idMataKuliah, String matakuliah, int sks, int maks, int idkrs) {
        this.id = id;
        this.nim = nim;
        this.mahasiswa = mahasiswa;
        this.idMataKuliah = idMataKuliah;
        this.matakuliah = matakuliah;
        this.sks = sks;
        this.maks = maks;
        this.idkrs = idkrs;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public int getIdMataKuliah() {
        return idMataKuliah;
    }

    public void setIdMataKuliah(int idMataKuliah) {
        this.idMataKuliah = idMataKuliah;
    }

    public String getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(String mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public String getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(String matakuliah) {
        this.matakuliah = matakuliah;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public int getMaks() {
        return maks;
    }

    public void setMaks(int maks) {
        this.maks = maks;
    }

    public int getIdkrs() {
        return idkrs;
    }

    public void setIdkrs(int idkrs) {
        this.idkrs = idkrs;
    }

    public void cetak(){
        System.out.println("getId(): "+getId());
        System.out.println("getNim(): "+getNim());
    }

}
