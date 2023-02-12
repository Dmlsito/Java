package org.example;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "Futbolistas")
public class Futbolista {

    private int id;
    private String nombre;
    private String club;
    private float media;
    private Timestamp ultimoPartido;

    public Futbolista(){}

    public Futbolista(int id, String nombre, String club, float media, Timestamp ultimoPartido) {
        this.id = id;
        this.nombre = nombre;
        this.club = club;
        this.media = media;
        this.ultimoPartido = ultimoPartido;
    }

    public Futbolista(String nombre, String club, float media, Timestamp ultimoPartido) {
        this.nombre = nombre;
        this.club = club;
        this.media = media;
        this.ultimoPartido = ultimoPartido;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }


    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }
    @Column(name = "Club")
    public String getClub() {
        return club;
    }
    @Column(name = "Media")
    public float getMedia() {
        return media;
    }
    @Column(name = "Ultimo_Partido")
    public Timestamp getUltimoPartido() {
        return ultimoPartido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public void setUltimoPartido(Timestamp ultimoPartido) {
        this.ultimoPartido = ultimoPartido;
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", club='" + club + '\'' +
                ", media=" + media +
                ", ultimoPartido=" + ultimoPartido +
                '}';
    }
}
