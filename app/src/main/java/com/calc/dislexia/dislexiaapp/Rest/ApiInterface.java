package com.calc.dislexia.dislexiaapp.Rest;

import com.calc.dislexia.dislexiaapp.Model.GetSoal;
import com.calc.dislexia.dislexiaapp.Model.PostPutDelBiodata;
import com.calc.dislexia.dislexiaapp.Model.PostPutDelJawaban;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by Ester on 4/15/18.
 */

public interface ApiInterface {
    @GET("soal")//read all soal
    Call<GetSoal> getSoal();


    @FormUrlEncoded
    @POST("user")//insert api biodata
    Call<PostPutDelBiodata> postBiodata(@Field("nama") String nama,
                                        @Field("email") String email,
                                        @Field("tgl_lahir") String tgl_lahir,
                                        @Field("nama_ortu") String nama_ortu,
                                        @Field("iq") String iq);
    @FormUrlEncoded
    @POST("Skor-tes")//insert API skor
    Call<PostPutDelJawaban> postJawaban(@Field("email") String email,
                                        @Field("skor") String skor);
//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
//    Call<PostPutDelKontak> deleteKontak(@Field("id") String id);
}
