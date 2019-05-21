package com.calc.dislexia.dislexiaapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ester on 4/15/18.
 */

public class GetSoal { //mendapatkan semua soal
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Soal> listDataSoal;
    @SerializedName("message")
    String message;

    public Soal getMsoal() {
        return getMsoal();
    }

    public void setMsoal(Soal msoal) {
        this.msoal = msoal;
    }

    Soal msoal;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Soal> getListDataSoal() {
        return listDataSoal;
    }
    public void setListDataSoal(List<Soal> listDataSoal) {
        this.listDataSoal = listDataSoal;
    }
}
