package com.example.imccalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView image_view;
    private double imc;
    private String genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //referencia a imadeView
        image_view = findViewById(R.id.image_view);

        //pegando os valores passados via Intent
        imc = getIntent().getDoubleExtra("imc", 0);
        genero = getIntent().getStringExtra("genero");

        if (genero.equals("masculino")){
            if (imc <= 21){
                image_view.setImageResource(R.drawable.magro);
            }else if(imc <= 26){
                image_view.setImageResource(R.drawable.brad);
            }else{
                image_view.setImageResource(R.drawable.josoares);
            }
        }else {
            if (imc <= 21){
                image_view.setImageResource(R.drawable.olivia);
            }else if (imc <= 26){
                image_view.setImageResource(R.drawable.agenlina);
            }else {
                image_view.setImageResource(R.drawable.thais);
            }
        }
    }
}