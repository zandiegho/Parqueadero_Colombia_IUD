package com.example.parqueaderocolombia;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Entradas extends AppCompatActivity {

    ImageButton imgBtn_carro, imgBtn_moto;
    EditText edt_vehiculoSeleccionado, edt_placaEntrada;
    Button btn_entrada;
    long hora;
    String vehiculoSelected ="";
    String placaIngresada = "";
    Time time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entradas);

        imgBtn_carro = findViewById(R.id.imgBtn_car);
        imgBtn_moto = findViewById(R.id.imgBtn_moto);
        edt_vehiculoSeleccionado = findViewById(R.id.edt_VehiculoSeleccionado);
        edt_placaEntrada = findViewById(R.id.edt_placa_entrada);
        btn_entrada = findViewById(R.id.btn_registrarEntrada);

        CapturaDatos();

        btn_entrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    RegistrarEntrada();
            }
        });
    }

    private void CapturaDatos() {
        imgBtn_carro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_vehiculoSeleccionado.setText("Automovil");
                vehiculoSelected = "Automovil";
                //CapturaHora();
            }
        });

        imgBtn_moto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_vehiculoSeleccionado.setText("Motocicleta");
                vehiculoSelected = "Motocicleta";
                //CapturaHora();
            }
        });
    }

    private void CapturaHora(){
        //int i = (int) (new Date().getTime()/1000);
        hora = System.currentTimeMillis();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat ("HH:mm:ss");
        time = new Time(hora);
        //Toast.makeText(getApplicationContext(), "la hora es: "+formatter.format(time), Toast.LENGTH_LONG).show();
    }

    public void RegistrarEntrada(){
        AdminDatabase adminDatabase = new AdminDatabase(getApplicationContext(), "Parqueadero", null, 1);
        SQLiteDatabase db = adminDatabase.getWritableDatabase();

        placaIngresada = edt_placaEntrada.getText().toString();
        CapturaHora();

        //enviar datos a BD
        if (placaIngresada.length() >= 6 ){

            ContentValues values = new ContentValues();
            values.put("placa", placaIngresada);
            values.put("vehiculo", vehiculoSelected);
            values.put("hora", String.valueOf(time));
            values.put("registro", "ok");

            long newRowId = db.insert("registros", null, values);

            //se valida ingreso de datos a db
            if (newRowId == -1) {
                Toast.makeText(getApplicationContext(), "ERROR EN REGISTRO", Toast.LENGTH_LONG).show();
                edt_placaEntrada.setText("");

            } else {
                NuevoRegistro registro = new NuevoRegistro(placaIngresada, vehiculoSelected, time, "ok" );
                registro.save();
                Toast.makeText(getApplicationContext(), "Entrada de Vehiculo Registrada\n"+
                        "Vehículo: "+vehiculoSelected+
                        "\nPlaca: "+placaIngresada+
                        "\nHora: "+time, Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
        }else {
            Toast.makeText(getApplicationContext(), "Debe Ingresar una placa valida", Toast.LENGTH_LONG).show();
        }
    }


}