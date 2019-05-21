package com.calc.dislexia.dislexiaapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ester on 4/15/18.
 */

public class Biodata {
    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;

    public String getIq() {
        return iq;
    }

    public void setIq(String iq) {
        this.iq = iq;
    }

    @SerializedName("iq")
    private String iq;

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    @SerializedName("tgl_lahir")
    private String tgl_lahir;
    @SerializedName("nama_ortu")
    private String nama_ortu;


    public Biodata(){}

    public Biodata(String nama, String email) {
        this.nama = nama;
        this.email = email;
            }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}