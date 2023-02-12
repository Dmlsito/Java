package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Obras")
public class Obra implements Serializable {


    private int id;
    private int idApi;
    private String apiModel;
    private boolean boosted;
    private String tittle;
    private String altTittles;
    private Set<Thumbnail> thumbnails;

    public Obra() {
    }

    public Obra(int idApi, String apiModel, boolean boosted, String tittle, String altTittles, Set<Thumbnail> thumbnails) {
        this.idApi = idApi;
        this.apiModel = apiModel;
        this.boosted = boosted;
        this.tittle = tittle;
        this.altTittles = altTittles;
        this.thumbnails = thumbnails;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "idApi")
    public int getIdApi() {
        return idApi;
    }

    public void setIdApi(int idApi) {
        this.idApi = idApi;
    }
    @Column(name = "api_model")
    public String getApiModel() {
        return apiModel;
    }

    public void setApiModel(String apiModel) {
        this.apiModel = apiModel;
    }
    @Column(name = "is_boosted")
    public boolean getBoosted() {
        return boosted;
    }

    public void setBoosted(boolean boosted) {
        this.boosted = boosted;
    }
    @Column(name = "Tittle")
    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
    @Column(name = "alt_tittles")
    public String getAltTittles() {
        return altTittles;
    }

    public void setAltTittles(String altTittles) {
        this.altTittles = altTittles;
    }

    @OneToMany(mappedBy = "obra")
    public Set<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Set<Thumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }

    @Override
    public String toString() {
        return "Obra{" +
                "id=" + id +
                ", idApi=" + idApi +
                ", apiModel='" + apiModel + '\'' +
                ", boosted=" + boosted +
                ", tittle='" + tittle + '\'' +
                ", altTittles='" + altTittles + '\'' +
                ", thumbnails=" + thumbnails +
                '}';
    }
}
