package com.example.parqueaderocolombia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_Entrada, btn_Salida, btn_Usuarios, btn_celdas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Entrada = findViewById(R.id.btn_entradas);
        btn_Salida = findViewById(R.id.btn_salidas);
        btn_Usuarios = findViewById(R.id.btn_Usuarios);
        btn_celdas = findViewById(R.id.btn_Celdas);



        btn_Entrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_Entradas = new Intent(MainActivity.this, Entradas.class);
                startActivity(i_Entradas);
            }
        });

        btn_Salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_Salidas = new Intent(MainActivity.this, Salidas.class);
                startActivity(i_Salidas);
            }
        });

        btn_Usuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_Usuarios = new Intent(MainActivity.this, Usuarios.class);
                startActivity(i_Usuarios);
            }
        });

        btn_celdas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_Celdas = new Intent(MainActivity.this, Celdas.class);
                startActivity(i_Celdas);
            }
        });
    }
}