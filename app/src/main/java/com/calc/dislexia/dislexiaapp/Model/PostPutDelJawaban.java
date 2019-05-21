package com.calc.dislexia.dislexiaapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ester on 4/15/18.
 */

public class PostPutDelJawaban {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Jawaban mjawaban;
    @SerializedName("message")
    String message;
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
    public Jawaban getMjawaban() {
        return mjawaban;
    }
    public void setMjawaban(Jawaban mjawaban) {
        this.mjawaban = mjawaban;
    }


}
