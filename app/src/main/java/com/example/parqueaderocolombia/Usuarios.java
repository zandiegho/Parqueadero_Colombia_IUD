package com.example.parqueaderocolombia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Usuarios extends AppCompatActivity {

    Button btn_UsuariosRegistrados, btn_RegistrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        btn_RegistrarUsuario = findViewById(R.id.btn_nuevoUsuario);
        btn_UsuariosRegistrados = findViewById(R.id.btn_UsuariosRegistrados);

        btn_RegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_NuevoUsuario = new Intent(Usuarios.this, RegistroUsuarios.class);
                startActivity(i_NuevoUsuario);
            }
        });

    }
}