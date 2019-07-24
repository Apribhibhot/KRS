package com.apri.test.entity;

public class Mahasiswa {

    private int nim;
    private String mahasiswa;
    private int maks;

    public Mahasiswa() {

    }

    public Mahasiswa(int nim, String mahasiswa, int maks) {
        this.nim = nim;
        this.mahasiswa = mahasiswa;
        this.maks = maks;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(String mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public int getMaks() {
        return maks;
    }

    public void setMaks(int maks) {
        this.maks = maks;
    }
}
