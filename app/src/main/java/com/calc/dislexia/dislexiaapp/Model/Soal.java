package com.calc.dislexia.dislexiaapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ester on 4/15/18.
 */

public class Soal {
    @SerializedName("id_soal")
    private String id;
    @SerializedName("soal")
    private String soal;

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    private String jawaban;

    private boolean isSelected;

    public Soal(){}

    public Soal(String id, String soal) {
        this.id = id;
        this.soal = soal;
            }

    public Soal(String id, String soal, boolean isSelected, String jawaban) {
        this.id = id;
        this.soal = soal;
        this.isSelected = isSelected;
        this.jawaban = jawaban;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}