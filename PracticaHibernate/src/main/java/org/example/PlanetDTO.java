package org.example;

import sun.text.bidi.BidiLine;

import java.util.List;
import java.util.Set;

public class PlanetDTO {

    private String id;

    private String neo_reference_id;
    private String name;
    private int designation;
    private double absolute_magnitude_h;
    private Set<OrbitalPlanetData> orbitalPlanetData;



    public PlanetDTO(){}

    public PlanetDTO(String id, String neo_reference_id, String name, int designation, double absolute_magnitude_h, Set<OrbitalPlanetData> orbitalPlanetData ) {
        this.id = id;
        this.neo_reference_id = neo_reference_id;
        this.name = name;
        this.designation = designation;
        this.absolute_magnitude_h = absolute_magnitude_h;
        this.orbitalPlanetData = orbitalPlanetData;

    }

    public String getId(){
        return this.id;
    }
    public String getNeo_reference_id(){
        return this.neo_reference_id;
    }
    public String getName(){
        return this.name;
    }
    public int getDesignation(){
        return this.designation;
    }
    public double getAbsolute_magnitude_h(){
        return this.absolute_magnitude_h;
    }

    public Set<OrbitalPlanetData> getOrbitalPlanetData() {
        return orbitalPlanetData;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNeo_reference_id(String neo_reference_id) {
        this.neo_reference_id = neo_reference_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }

    public void setAbsolute_magnitude_h(double absolute_magnitude_h) {
        this.absolute_magnitude_h = absolute_magnitude_h;
    }

    public void setOrbitalPlanetData(Set<OrbitalPlanetData> orbitalPlanetData) {
        this.orbitalPlanetData = orbitalPlanetData;
    }



    @Override
    public String toString() {
        return
                ", neo_reference_id='" + neo_reference_id + '\'' +
                ", name='" + name + '\'' +
                ", designation=" + designation +
                ", absolute_magnitude_h=" + absolute_magnitude_h +
                ", orbitalPlanetData=" + orbitalPlanetData

                ;
    }
}
