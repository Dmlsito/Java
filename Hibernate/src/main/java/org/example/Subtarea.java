package org.example;

import java.io.Serializable;

public class Subtarea implements Serializable {

    private int id;
    private int idTarea;
    private String nombre;
    private Tarea tarea;

    public Subtarea(){}

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getIdTarea(){
        return this.idTarea;
    }
    public void setIdTarea(int idTarea){
        this.idTarea = idTarea;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public Tarea getTarea(){
        return this.tarea;
    }
    public void setTarea(Tarea tarea){
        this.tarea = tarea;
    }

    @Override
    public String toString() {
        return "Subtarea{" +
                "id=" + id +
                ", idTarea=" + idTarea +
                ", nombre='" + nombre + '\'' +
                //", tarea=" + tarea + -> El comentario en esta linea evita que se embucle
                '}';
    }
}
