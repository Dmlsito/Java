package org.example;

public class Jugador {
    private int id;
    private String nombre;
    private int dorsal;

    public Jugador(){}

    public Jugador(int id, String nombre, int dorsal){
        this.id = id;
        this.nombre = nombre;
        this.dorsal = dorsal;
    }

    public String getNombre(){
        return this.nombre;
    }
    public int getId(){
        return this.id;
    }
    public int getDorsal(){
        return this.dorsal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return    "id = " + id + ", " +
                "nombre='" + nombre + '\'' +
                ", dorsal=" + dorsal
                ;
    }
}
