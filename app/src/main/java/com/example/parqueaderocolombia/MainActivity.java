package com.example.parqueaderocolombia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_Entrada, btn_Salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Entrada = findViewById(R.id.btn_entradas);
        btn_Salida = findViewById(R.id.btn_salidas);

        btn_Entrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Entradas.class);
                startActivity(intent);
            }
        });

        btn_Salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Salidas.class);
                startActivity(intent);
            }
        });
    }
}