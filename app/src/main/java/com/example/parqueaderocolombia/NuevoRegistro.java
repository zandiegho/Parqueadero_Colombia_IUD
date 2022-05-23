package com.example.parqueaderocolombia;

import com.orm.SugarRecord;

import java.sql.Time;

public class NuevoRegistro extends SugarRecord <NuevoRegistro> {
    String placa, vehiculo;
    Time hora;
    String registro;

    public NuevoRegistro() {
    }

    public NuevoRegistro(String placa, String vehiculo, Time hora, String registro) {
        this.placa = placa;
        this.vehiculo = vehiculo;
        this.hora = hora;
        this.registro = registro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVehiculo() {

        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}
