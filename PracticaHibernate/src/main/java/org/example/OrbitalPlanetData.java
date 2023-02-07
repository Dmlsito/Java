package org.example;


import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "OrbitalPlanetData")
public class OrbitalPlanetData {
    private int orbitId;
    private int planetId;
    private String orbitDeterminationDate;
    private String firstObservationDate;
    private String lastObservationDate;
    private int dataArcInDays;
    private int observationUsed;
    private String orbitUncertainty;
    private String minimunOrbitIntersection;
    private String jupiterTisserandInvariant;
    private String epochOsculation;
    private String eccentricity;
    private String semiMajorAxis;
    private String inclination;
    private String ascendingNodeLongitude;
    private String orbitalPeriod;
    private String perihelionDistanced;
    private String perihelionArgument;
    private Planet planet;

    public OrbitalPlanetData(){}


    public OrbitalPlanetData(int planetId, String orbitDeterminationDate, String firstObservationDate, String lastObservationDate, int dataArcInDays, int observationUsed, String orbitUncertainty, String minimunOrbitIntersection, String jupiterTisserandInvariant, String epochOsculation, String eccentricity, String semiMajorAxis, String inclination, String ascendingNodeLongitude, String orbitalPeriod, String perihelionDistanced, String perihelionArgument, Planet planet) {
        this.planetId = planetId;
        this.orbitDeterminationDate = orbitDeterminationDate;
        this.firstObservationDate = firstObservationDate;
        this.lastObservationDate = lastObservationDate;
        this.dataArcInDays = dataArcInDays;
        this.observationUsed = observationUsed;
        this.orbitUncertainty = orbitUncertainty;
        this.minimunOrbitIntersection = minimunOrbitIntersection;
        this.jupiterTisserandInvariant = jupiterTisserandInvariant;
        this.epochOsculation = epochOsculation;
        this.eccentricity = eccentricity;
        this.semiMajorAxis = semiMajorAxis;
        this.inclination = inclination;
        this.ascendingNodeLongitude = ascendingNodeLongitude;
        this.orbitalPeriod = orbitalPeriod;
        this.perihelionDistanced = perihelionDistanced;
        this.perihelionArgument = perihelionArgument;
        this.planet = planet;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getOrbitId(){
        return this.orbitId;
    }
    public void setOrbitId(int orbitId){
        this.orbitId = orbitId;
    }
    @Column(name = "OrbitDeterminationDate")
    public String getOrbitDeterminationDate(){
        return this.orbitDeterminationDate;
    }
    public void setOrbitDeterminationDate(String orbitDeterminationDate){
        this.orbitDeterminationDate = orbitDeterminationDate;
    }
    @Column(name = "FirstObservationDate")
    public String getFirstObservationDate(){
        return this.firstObservationDate;
    }
    public void setFirstObservationDate(String firstObservationDate){
        this.firstObservationDate = firstObservationDate;
    }
    @Column(name = "LastObservationDate")
    public String getLastObservationDate(){
        return this.lastObservationDate;
    }
    public void setLastObservationDate(String lastObservationDate){
        this.lastObservationDate = lastObservationDate;
    }
    @Column(name = "DataArcInDays")
    public int getDataArcInDays(){
        return this.dataArcInDays;
    }
    public void setDataArcInDays(int dataArcInDays){
        this.dataArcInDays = dataArcInDays;
    }
    @Column(name = "ObservationUsed")
    public int getObservationUsed(){
        return this.observationUsed;
    }
    public void setObservationUsed(int observationUsed){
        this.observationUsed = observationUsed;
    }
    @Column(name = "OrbitaUncertainty")
    public String getOrbitUncertainty(){
        return this.orbitUncertainty;
    }
    public void setOrbitUncertainty(String orbitalUncertainty){
        this.orbitUncertainty = orbitalUncertainty;
    }
    @Column(name = "MinimunOrbitIntersection")
    public String getMinimunOrbitIntersection(){
        return this.minimunOrbitIntersection;
    }
    public void setMinimunOrbitIntersection(String minimunOrbitIntersection){
        this.minimunOrbitIntersection = minimunOrbitIntersection;
    }
    @Column(name = "JupiterTisserandInvariant")
    public String getJupiterTisserandInvariant(){
        return this.jupiterTisserandInvariant;
    }
    public void setJupiterTisserandInvariant(String jupiterTisserandInvariant){
        this.jupiterTisserandInvariant = jupiterTisserandInvariant;
    }
    @Column(name = "EpochOsculation")
    public String getEpochOsculation(){
        return this.epochOsculation;
    }
    public void setEpochOsculation(String epochOsculation){
        this.epochOsculation = epochOsculation;
    }
    @Column(name = "Eccentricity")
    public String getEccentricity(){
        return this.eccentricity;
    }
    public void setEccentricity(String eccentricity){
        this.eccentricity = eccentricity;
    }
    @Column(name = "SemiMajorAxis")
    public String getSemiMajorAxis(){
        return this.semiMajorAxis;
    }
    public void setSemiMajorAxis(String semiMajorAxis){
        this.semiMajorAxis = semiMajorAxis;
    }
    @Column(name = "Inclination")
    public String getInclination(){
        return this.inclination;
    }
    public void setInclination(String inclination){
        this.inclination = inclination;
    }
    @Column(name = "AscendingNodeLongitude")
    public String getAscendingNodeLongitude(){
        return this.ascendingNodeLongitude;
    }
    public void setAscendingNodeLongitude(String ascendingNodeLongitude){
        this.ascendingNodeLongitude = ascendingNodeLongitude;
    }
    @Column(name = "OrbitalPeriod")
    public String getOrbitalPeriod(){
        return this.orbitalPeriod;
    }
    public void setOrbitalPeriod(String orbitalPeriod){
        this.orbitalPeriod = orbitalPeriod;
    }
    @Column(name = "PerihelionDistanced")
    public String getPerihelionDistanced(){
        return this.perihelionDistanced;
    }
    public void setPerihelionDistanced(String perihelionDistanced){
        this.perihelionDistanced = perihelionDistanced;
    }
    @Column(name = "PerihelionArgument")
    public String getPerihelionArgument(){
        return this.perihelionArgument;
    }
    public void setPerihelionArgument(String perihelionArgument){
        this.perihelionArgument = perihelionArgument;
    }

    @ManyToOne
    @JoinColumn(name = "planetId", insertable = false, updatable = false )
    public Planet getPlanet(){
        return this.planet;
    }
    public void setPlanet(Planet planet){
        this.planet = planet;
    }

    @Override
    public String toString() {
        return "OrbitalPlanetData{" +
                "orbitId=" + orbitId +
                ", planetId=" + planetId +
                ", orbitDeterminationDate=" + orbitDeterminationDate +
                ", firstObservationDate=" + firstObservationDate +
                ", lastObservationDate=" + lastObservationDate +
                ", dataArcInDays=" + dataArcInDays +
                ", observationUsed=" + observationUsed +
                ", orbitUncertainty='" + orbitUncertainty + '\'' +
                ", minimunOrbitIntersection='" + minimunOrbitIntersection + '\'' +
                ", jupiterTisserandInvariant='" + jupiterTisserandInvariant + '\'' +
                ", epochOsculation='" + epochOsculation + '\'' +
                ", eccentricity='" + eccentricity + '\'' +
                ", semiMajorAxis='" + semiMajorAxis + '\'' +
                ", inclination='" + inclination + '\'' +
                ", ascendingNodeLongitude='" + ascendingNodeLongitude + '\'' +
                ", orbitalPeriod='" + orbitalPeriod + '\'' +
                ", perihelionDistanced='" + perihelionDistanced + '\'' +
                ", perihelionArgument='" + perihelionArgument + '\'' +
                 //", planet=" + planet +
                '}';
    }
}
