package com.example.parqueaderocolombia;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegistroUsuarios extends AppCompatActivity {

    EditText edt_NombreUsuario, edt_placaVehiculoNuevo;
    Button btn_RegistrarUsuario;
    RadioButton rdBtn_VehiculoIngresado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        edt_NombreUsuario = findViewById(R.id.edt_Nuevocliente);

        registarUsuario();
    }

    private void registarUsuario() {
        AdminDatabase adminDatabase = new AdminDatabase(getApplicationContext(), "Parqueadero", null, 1);
        SQLiteDatabase db = adminDatabase.getWritableDatabase();


    }
}