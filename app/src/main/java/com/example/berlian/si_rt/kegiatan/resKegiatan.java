package com.example.berlian.si_rt.kegiatan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by berlian on 6/19/2017.
 */

public class resKegiatan {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("kategori")
    @Expose
    private String kategori;
    @SerializedName("subkategori")
    @Expose
    private String subkategori;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("teks")
    @Expose
    private String teks;
    @SerializedName("nama")
    @Expose
    private String nama;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getSubkategori() {
        return subkategori;
    }

    public void setSubkategori(String subkategori) {
        this.subkategori = subkategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getTeks() {
        return teks;
    }

    public void setTeks(String teks) {
        this.teks = teks;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
