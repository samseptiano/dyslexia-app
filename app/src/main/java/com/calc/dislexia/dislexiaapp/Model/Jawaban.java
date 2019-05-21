package com.calc.dislexia.dislexiaapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ester on 4/15/18.
 */

public class Jawaban {
    @SerializedName("email")
    private String email;
    @SerializedName("skor")
    private String skor;


    public Jawaban(){}

    public Jawaban(String email, String skor) {
        this.email = email;
        this.skor = skor;
            }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkor() {
        return skor;
    }

    public void setSkor(String skor) {
        this.skor = skor;
    }
}