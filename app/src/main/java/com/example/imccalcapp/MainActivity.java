package com.example.imccalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView nuImc, reImc;
    private EditText editPeso, editAltura;
    private Button btCalcular, btLimpar;
    private RadioGroup radioGroup;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referenciar os componentes na view
        editPeso = findViewById(R.id.edit_peso);
        editAltura = findViewById(R.id.edit_altura);
        btCalcular = findViewById(R.id.bt_calcular);
        btLimpar = findViewById(R.id.bt_limpar);
        nuImc = findViewById(R.id.nu_imc);
        reImc = findViewById(R.id.re_imc);
        spinner = findViewById(R.id.spinner);
        radioGroup = findViewById(R.id.radio_group);

        btLimpar.setOnClickListener(v -> {
            editPeso.setText("");
            editAltura.setText("");
            nuImc.setText("");
            nuImc.setBackgroundColor(getResources().getColor(R.color.cinza));
            reImc.setText("");


        });

        btCalcular.setOnClickListener(v -> {
            if(editPeso.getText().toString().isEmpty()){
             editPeso.setError(getString(R.string.valida_peso));
                Toast.makeText(getBaseContext(), R.string.valida_peso, Toast.LENGTH_SHORT).show();
            } else if (editAltura.getText().toString().isEmpty()) {
                editAltura.setError(getString(R.string.valida_altura));
                Snackbar.make(btCalcular, R.string.valida_altura, Snackbar.LENGTH_SHORT).show();
            }else{

                double peso = Double.parseDouble(editPeso.getText().toString());
                float  vaImc = Float.parseFloat(editPeso.getText().toString());
                double altura = Double.parseDouble(editAltura.getText().toString());
                double imc = peso / (altura * altura);


            if (imc < 18){
                nuImc.setText(R.string.clas1);
                nuImc.setBackgroundColor(getResources().getColor(R.color.azul));
            }else if (imc < 24){
                nuImc.setText(R.string.clas2);
                nuImc.setBackgroundColor(getResources().getColor(R.color.embacado));
            }else if (imc < 29){
                nuImc.setText(R.string.clas3);
                nuImc.setBackgroundColor(getResources().getColor(R.color.amarelo));
            }else if (imc < 34){
                nuImc.setText(R.string.clas4);
                nuImc.setBackgroundColor(getResources().getColor(R.color.rosa));
            }else if (imc < 39){
                nuImc.setText(R.string.clas5);
                nuImc.setBackgroundColor(getResources().getColor(R.color.magenta));
            }else{
                nuImc.setText(R.string.clas6);
                nuImc.setBackgroundColor(getResources().getColor(R.color.vermelho));

            }
            String genero = "masculino";
                // pegar o valor selecionado no spinner
                if (spinner.getSelectedItemPosition() == 0){
                    genero = "feminino";
                }

                // pegar o valor selecionado no radiogroup
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radio_feminino:
                        genero = "feminino";
                        break;
                    case R.id.radio_masculino:
                        genero = "masculino";
                        break;
                }


            reImc.setText(getString(R.string.imc, imc));
                Intent intent = new Intent(this, ResultadoActivity.class);
                intent.putExtra("imc", imc);
                intent.putExtra("genero", genero);
                startActivity(intent);
                //finish();
            }

        });
    }
}