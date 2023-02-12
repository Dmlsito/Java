package org.example;

public class Pico {

    private String nombre;
    private String provincia;
    private int prominencia;

    public Pico(){}

    public Pico(String nombre, String provincia, int prominencia) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.prominencia = prominencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getProminencia() {
        return prominencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setProminencia(int prominencia) {
        this.prominencia = prominencia;
    }

    @Override
    public String toString() {
        return "Pico{" +
                "nombre='" + nombre + '\'' +
                ", provincia='" + provincia + '\'' +
                ", prominencia=" + prominencia +
                '}';
    }
}
