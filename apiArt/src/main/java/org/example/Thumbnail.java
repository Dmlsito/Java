package org.example;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Miniaturas")
public class Thumbnail implements Serializable {


    private int id;

    private int idObra;
    private String lqip;
    private int width;
    private int height;
    private String altText;
    private Obra obra;

    public Thumbnail() {
    }

    public Thumbnail(int idObra, String lqip, int width, int height, String altText, Obra obra) {
        this.idObra = idObra;
        this.lqip = lqip;
        this.width = width;
        this.height = height;
        this.altText = altText;
        this.obra = obra;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "idObra")
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Column(name = "lqip")
    public String getLqip() {
        return lqip;
    }

    public void setLqip(String lqip) {
        this.lqip = lqip;
    }
    @Column(name = "Width")
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    @Column(name = "height")
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    @Column(name = "alt_text")
    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }


    @ManyToOne
    @JoinColumn(name = "id",updatable = false,insertable = false)
    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    @Override
    public String toString() {
        return "Thumbnail{" +
                "id=" + id +
                ", idObra=" + idObra +
                ", lqip='" + lqip + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", altText='" + altText + '\'' +
                //", obra=" + obra +
                '}';
    }
}

