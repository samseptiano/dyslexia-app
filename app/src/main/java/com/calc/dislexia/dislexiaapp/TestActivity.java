package com.calc.dislexia.dislexiaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.calc.dislexia.dislexiaapp.Model.GetSoal;
import com.calc.dislexia.dislexiaapp.Model.Soal;
import com.calc.dislexia.dislexiaapp.Model.kumpulanJawaban;
import com.calc.dislexia.dislexiaapp.Rest.Adapter.SoalAdapter;
import com.calc.dislexia.dislexiaapp.Rest.ApiClient;
import com.calc.dislexia.dislexiaapp.Rest.ApiInterface;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;
    Button btnresult;
    RadioGroup rg1;
    int jawaban[];
    String emailValue="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            emailValue = extras.getString("EMAIL");
            Toast.makeText(getApplicationContext(), emailValue.toString(),Toast.LENGTH_LONG).show();
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        //ma=this;
        refresh();

    }

    public void refresh() {
        //NARIK API
        Call<GetSoal> soalCall = mApiInterface.getSoal();
        soalCall.enqueue(new Callback<GetSoal>() {
            @Override
            public void onResponse(Call<GetSoal> call, Response<GetSoal>
                    response) {
                if(response.isSuccessful()){
                    //mendapatkan data kontak
                    List<Soal> SoalList = response.body().getListDataSoal();
                    //Kontak KontakNama = response.body().getMkontak();
                    Log.d("Retrofit Get", "Jumlah data Kontak: " +
                            String.valueOf(SoalList.size()));
                    mAdapter = new SoalAdapter(getApplicationContext(),SoalList);
                    mRecyclerView.setAdapter(mAdapter);

                    btnresult = (Button) findViewById(R.id.btnResult);
                    rg1 = (RadioGroup) findViewById(R.id.radiogroup1);
                    btnresult.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int jawaban = 0;
                            String data = "";
                            List<Soal> stList = ((SoalAdapter) mAdapter).getSoalist();

                            for (int i = 0; i < stList.size(); i++) {
                                Soal singleStudent = stList.get(i);
                                if (singleStudent.isSelected() == true) {
                                    if(singleStudent.getJawaban().toString().equals("Ya") ){
                                     jawaban++;
                                    }
                                    data = data + "\n" + singleStudent.getSoal().toString()+" : "+singleStudent.getJawaban().toString();

                                }

                            }

                            Intent intent = new Intent(TestActivity.this,ResultActivity.class);
                            intent.putExtra("EMAIL",emailValue);
                            intent.putExtra("SKOR",String.valueOf(jawaban));
                            startActivity(intent);


//                            Toast.makeText(getApplicationContext(),
//                                    "Soal Dijawab: \n" + data+"\nTotal Skor: "+jawaban, Toast.LENGTH_LONG)
//                                    .show();
                        }
                    });
                }

                else{
                    Toast toast = Toast.makeText(getApplicationContext(),"keluar: "+response.errorBody(),Toast.LENGTH_LONG);
                    toast.show();
                }

            }

            @Override
            public void onFailure(Call<GetSoal> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
                //error pemanggilan API
                Toast toast = Toast.makeText(getApplicationContext(),"API CALL GAGAL"+ t.toString(),Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

}
