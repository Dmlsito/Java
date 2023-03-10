package org.example;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Planets")
public class Planet implements Serializable {
    private String idApi;
    private int id;
    private String neoReferenceId;
    private String name;
    private int designation;
    private double absoluteMagnitudeH;
    private Set<OrbitalPlanetData> orbitalPlanetData;
    private List<ApproachDataDTO> listApproachData;

    public Planet(){}

    public Planet(String idApi, String neoReferenceId, String name, int designation, double absoluteMagnitudeH, Set<OrbitalPlanetData> orbitalPlanetData, List<ApproachDataDTO> listApproachData) {
        this.idApi = idApi;
        this.neoReferenceId = neoReferenceId;
        this.name = name;
        this.designation = designation;
        this.absoluteMagnitudeH = absoluteMagnitudeH;
        this.orbitalPlanetData = orbitalPlanetData;
        this.listApproachData = listApproachData;
    }

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
    public  String getIdApi(){
        return this.idApi;
    }
    public void setIdApi(String id){
        this.idApi = idApi;
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
/*
    @OneToMany(mappedBy = "planet")
    public List<ApproachDataDTO> getListApproachData() {
        return listApproachData;
    }

 */
    public void setListApproachData(List<ApproachDataDTO> listApproachData) {
        this.listApproachData = listApproachData;
    }
    @Override
    public String toString() {
        return "Planet{" +
                "idApi='" + idApi + '\'' +
                ", id=" + id +
                ", neoReferenceId='" + neoReferenceId + '\'' +
                ", name='" + name + '\'' +
                ", designation=" + designation +
                ", absoluteMagnitudeH=" + absoluteMagnitudeH +
                ", orbitalPlanetData=" + orbitalPlanetData +
                ", listApproachData=" + listApproachData +
                '}';
    }
}
