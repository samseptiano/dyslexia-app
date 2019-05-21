package com.calc.dislexia.dislexiaapp.Rest;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ester on 4/15/18.
 */

public class ApiClient {
    public static final String BASE_URL = "http://10.107.208.245/rest_server/index.php/"; //deklarasikan link API website
    //====== imanin saja ============
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
        //============================
    }
}
