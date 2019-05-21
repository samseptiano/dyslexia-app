package com.calc.dislexia.dislexiaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    TextView tvHasil;
    TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvHasil = (TextView) findViewById(R.id.textView2);
        tvEmail = (TextView) findViewById(R.id.textView3);

        Bundle extras = getIntent().getExtras();
        if(extras !=null) {
            String email = extras.getString("EMAIL");
            String skor = extras.getString("SKOR");
            tvHasil.setText(skor);
            tvEmail.setText(email);
        }
    }
}
