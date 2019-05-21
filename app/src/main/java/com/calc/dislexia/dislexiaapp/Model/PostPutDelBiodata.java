package com.calc.dislexia.dislexiaapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ester on 4/15/18.
 */

public class PostPutDelBiodata {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Biodata mbiodata;
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
    public Biodata getMbiodata() {
        return mbiodata;
    }
    public void setMbiodata(Biodata mbiodata) {
        this.mbiodata = mbiodata;
    }
}
