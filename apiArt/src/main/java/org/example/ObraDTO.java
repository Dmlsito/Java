package org.example;

import java.io.Serializable;
import java.util.Set;

public class ObraDTO  {

    private int id;
    private String api_model;
    private String api_link;
    private boolean is_boosted;

    private String tittle;

    private String alt_tittles;

    private Set<Thumbnail> thumbnails;

    public ObraDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApi_model() {
        return api_model;
    }

    public void setApi_model(String api_model) {
        this.api_model = api_model;
    }

    public String getApi_link() {
        return api_link;
    }

    public void setApi_link(String api_link) {
        this.api_link = api_link;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAlt_tittles() {
        return alt_tittles;
    }

    public void setAlt_tittles(String alt_tittles) {
        this.alt_tittles = alt_tittles;
    }

    public boolean isIs_boosted() {
        return is_boosted;
    }

    public Set<Thumbnail> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Set<Thumbnail> thumbnails) {
        this.thumbnails = thumbnails;
    }
}
