package org.example;

import javax.persistence.*;

@Entity
@Table( name = "ApproachDataPlanets")
public class ApproachData {
    private int id;

    private String closeApproachDate;
    private String closeApproachDateFull;
    private int epochDateCloseApproach;
    private String orbitingBody;


    public ApproachData() {}

    public ApproachData(String closeApproachDate, String closeApproachDateFull, int epochDateCloseApproach, String orbitingBody) {

        this.closeApproachDate = closeApproachDate;
        this.closeApproachDateFull = closeApproachDateFull;
        this.epochDateCloseApproach = epochDateCloseApproach;
        this.orbitingBody = orbitingBody;

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }


    @Column(name = "CloseApproachDate")
    public String getCloseApproachDate() {
        return closeApproachDate;
    }
    @Column(name = "CloseApproachDateFull")
    public String getCloseApproachDateFull() {
        return closeApproachDateFull;
    }
    @Column(name = "EpochDateCloseApproach")
    public int getEpochDateCloseApproach() {
        return epochDateCloseApproach;
    }
    @Column(name = "OrbitingBody")
    public String getOrbitingBody() {
        return orbitingBody;
    }
/*
    @ManyToOne()
    @JoinColumn(name = "id", insertable = false, updatable = false)
    public Planet getPlanet() {
        return planet;
    }

 */
    public void setCloseApproachDate(String closeApproachDate) {
        this.closeApproachDate = closeApproachDate;
    }

    public void setCloseApproachDateFull(String closeApproachDateFull) {
        this.closeApproachDateFull = closeApproachDateFull;
    }

    public void setEpochDateCloseApproach(int epochDateCloseApproach) {
        this.epochDateCloseApproach = epochDateCloseApproach;
    }

    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "ApproachData{" +
                ", closeApproachDate='" + closeApproachDate + '\'' +
                ", closeApproachDateFull='" + closeApproachDateFull + '\'' +
                ", epochDateCloseApproach=" + epochDateCloseApproach +
                ", orbitingBody='" + orbitingBody + 
                ", orbitingBody='" + orbitingBody +
                '}';
    }
}
