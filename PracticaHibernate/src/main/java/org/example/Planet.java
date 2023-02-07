package org.example;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Planets")
public class Planet implements Serializable {
    private String id;
    private int idApi;
    private String neoReferenceId;
    private String name;
    private int designation;
    private double absoluteMagnitudeH;
    private Set<OrbitalPlanetData> orbitalPlanetData;

    Planet(){}

    public Planet(String id, String neoReferenceId, String name, int designation, double absoluteMagnitudeH, Set<OrbitalPlanetData> orbitalPlanetData) {

        this.id = id;
        this.neoReferenceId = neoReferenceId;
        this.name = name;
        this.designation = designation;
        this.absoluteMagnitudeH = absoluteMagnitudeH;
        this.orbitalPlanetData = orbitalPlanetData;
    }

    //Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdApi(){
        return this.idApi;
    }
    public void setIdApi(int idApi){
        this.idApi = idApi;
    }
    @Column(name = "Id")
    public  String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    @Column(name = "NeoReferenceId")
    public String getNeoReferenceId(){
        return this.neoReferenceId;
    }
    public void setNeoReferenceId(String neoReferenceId){
        this.neoReferenceId = neoReferenceId;
    }
    @Column(name = "Name")
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    @Column(name = "Designation")
    public int getDesignation(){
        return this.designation;
    }
    public void setDesignation(int designation){
        this.designation = designation;
    }
    @Column(name = "AbsoluteMagnitudeH")
    public double getAbsoluteMagnitudeH(){
        return this.absoluteMagnitudeH;
    }
    public void setAbsoluteMagnitudeH(double absoluteMagnitudeH){
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }
    @OneToMany(mappedBy = "planet")
    public Set<OrbitalPlanetData> getOrbitalPlanetData(){
        return this.orbitalPlanetData;
    }
    public void setOrbitalPlanetData(Set<OrbitalPlanetData> orbitalPlanetData){
        this.orbitalPlanetData = orbitalPlanetData;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", neoReferenceId=" + neoReferenceId +
                ", name='" + name + '\'' +
                ", designation=" + designation +
                ", absoluteMagnitudeH='" + absoluteMagnitudeH + '\'' +
                '}';
    }
}
