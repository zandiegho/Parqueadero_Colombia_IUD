package com.example.parqueaderocolombia;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

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
                RegistrarEntrada("http://192.168.58.2:80/ParqueaderoCol/insertar.php");
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

    public void CapturaHora() {
        //int i = (int) (new Date().getTime()/1000);
        hora = System.currentTimeMillis();
        time = new Time(hora);
        //Toast.makeText(getApplicationContext(), "la hora es: "+formatter.format(time), Toast.LENGTH_LONG).show();
    }

    public void RegistrarEntrada(String URL){
        //capturamos la Hora
        CapturaHora();

        //COndicionamos formato para la fecha y hora
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

        //Creacion de la petición post para el web service de PHP
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Si la conexión es Correcta
                Toast.makeText(Entradas.this, "Entrada Exitosa, hora: "+time, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Si la conexión es Incorrecta
                Toast.makeText(Entradas.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            //Enviamos los Datos al Web service para que pase a BD
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("placa",  edt_placaEntrada.getText().toString());
                parametros.put("vehiculo",  edt_vehiculoSeleccionado.getText().toString());
                parametros.put("hora", formatter.format(time));
                parametros.put("registro",  "Ingresado");

                return parametros;
            }
        };
        //Iniciamos peticion
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


        /**
         * esta instacia sugar se va a eliminar para la proxima peticion.
         */
        //Anterior BD SUGAR
        /*AdminDatabase adminDatabase = new AdminDatabase(getApplicationContext(), "Parqueadero", null, 1);
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
        }*/
    }


}