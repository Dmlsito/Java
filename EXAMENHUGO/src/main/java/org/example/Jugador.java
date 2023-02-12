package org.example;

public class Jugador {

    private String nombre;
    private int dorsal;
    private double puntuacion;

    public Jugador(){}

    public Jugador(String nombre, int dorsal, double puntuacion) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", dorsal=" + dorsal +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
