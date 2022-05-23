package com.example.parqueaderocolombia;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Salidas extends AppCompatActivity {

    EditText edt_placaSalida;
    Button btn_RegistrarSalida;
    String placaSalida = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salidas);

        edt_placaSalida = findViewById(R.id.edt_placa_salida);
        btn_RegistrarSalida = findViewById(R.id.btn_registrarSalida);

        btn_RegistrarSalida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrarSalida();
            }
        });
    }

    private void RegistrarSalida() {

        placaSalida = edt_placaSalida.getText().toString();

        if (placaSalida.length() >= 6 ) {
            NuevoRegistro nuevoRegistro = NuevoRegistro.findById(NuevoRegistro.class, 1l);
            if (nuevoRegistro != null) {
                nuevoRegistro.delete();
                Toast.makeText(getApplicationContext(), "Salida Registrada Correctamente.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Placa no ha ingresado a parqueadero..." +
                        "\nFavor Verificar", Toast.LENGTH_SHORT).show();
            }
        }


    }
}