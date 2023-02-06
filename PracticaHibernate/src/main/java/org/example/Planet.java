package org.example;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Planets")
public class Planet implements Serializable {
    private int idApi;
    private int id;
    private int neoReferenceId;
    private String name;
    private int designation;
    private String absoluteMagnitudeH;
    private Set<OrbitalPlanetData> orbitalPlanetData;

    Planet(){}

    //Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    @Column(name = "IdApi")
    public int getIdApi(){
        return this.idApi;
    }
    public void setIdApi(int id){
        this.idApi = id;
    }
    @Column(name = "NeoReferenceId")
    public int getNeoReferenceId(){
        return this.neoReferenceId;
    }
    public void setNeoReferenceId(int neoReferenceId){
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
    public String getAbsoluteMagnitudeH(){
        return this.absoluteMagnitudeH;
    }
    public void setAbsoluteMagnitudeH(String absoluteMagnitudeH){
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }
    @OneToMany( mappedBy = "planet")
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
