package com.calc.dislexia.dislexiaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.calc.dislexia.dislexiaapp.Model.Biodata;
import com.calc.dislexia.dislexiaapp.Model.GetSoal;
import com.calc.dislexia.dislexiaapp.Model.PostPutDelBiodata;
import com.calc.dislexia.dislexiaapp.Rest.ApiClient;
import com.calc.dislexia.dislexiaapp.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button buttonDetail;
    Button buttonSubmit;
    EditText EdtNamaAnak;
    EditText EdtNamaOrangTua;
    EditText EdtEmail;
    EditText EdtTanggalLahir;
    EditText EdtIq;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDetail = (Button)findViewById(R.id.buttonDetail);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        EdtEmail = (EditText) findViewById(R.id.EdtEmail);
        EdtNamaAnak = (EditText) findViewById(R.id.EdtNamaAnak);
        EdtTanggalLahir = (EditText) findViewById(R.id.EdtTanggalLahir);
        EdtNamaOrangTua = (EditText) findViewById(R.id.EdtNamaOrangTua);
        EdtIq = (EditText) findViewById(R.id.EdtIq);



        buttonDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,DyslexiaDetail.class);
                startActivity(intent);

            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Integer.parseInt(EdtIq.getText().toString()) < 90) {
                    Toast.makeText(getApplicationContext(),
                       "Anak anda mengalami Down Syndrome, Mohon hubungi dokter Psikologi untuk masalah lebih lanjut", Toast.LENGTH_LONG).show();
                }
                else if (Integer.parseInt(EdtIq.getText().toString()) > 120) {
                    Toast.makeText(getApplicationContext(),
                            "Anda anda tidak mengalami Dyslexia.  Untuk mengetahui lebih lanjut, silahkan Menghubungi Dokter Psikologi", Toast.LENGTH_LONG).show();

                } else {

                    mApiInterface = ApiClient.getClient().create(ApiInterface.class);

                    Call<PostPutDelBiodata> biodataCall = mApiInterface.postBiodata(EdtNamaAnak.getText().toString(), EdtEmail.getText().toString(), EdtTanggalLahir.getText().toString(), EdtNamaOrangTua.getText().toString(), EdtIq.getText().toString());
                    biodataCall.enqueue(new Callback<PostPutDelBiodata>() {
                        @Override
                        public void onResponse(Call<PostPutDelBiodata> call, Response<PostPutDelBiodata> response) {
                            Intent intent = new Intent(MainActivity.this, TestActivity.class);
                            intent.putExtra("EMAIL", EdtEmail.getText().toString());
                            startActivity(intent);

                        }

                        @Override
                        public void onFailure(Call<PostPutDelBiodata> call, Throwable t) {

                        }
                    });


                }
            }
        });



    }
}