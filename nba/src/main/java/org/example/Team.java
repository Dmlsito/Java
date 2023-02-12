package org.example;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;
@Entity
@Table( name = "Teams")
public class Team implements Serializable {

    private int idTeam;

    private int Id;

    private String abbreviation;

    private String city;

    private String conference;

    private String division;

    private String fullname;

    private String name;

    private Set<Player> player;

    public Team() {
    }

    public Team(int idTeam,  String abbreviation, String city, String conference, String division, String fullname, String name) {
        this.idTeam = idTeam;
        this.abbreviation = abbreviation;
        this.city = city;
        this.conference = conference;
        this.division = division;
        this.fullname = fullname;
        this.name = name;

    }
    @Column( name = "IdTeam")
    public int getIdTeam() {
        return idTeam;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return Id;
    }
    @Column( name = "Abreviation")
    public String getAbbreviation() {
        return abbreviation;
    }
    @Column( name = "City")
    public String getCity() {
        return city;
    }
    @Column( name = "Conference")
    public String getConference() {
        return conference;
    }
    @Column( name = "Division")
    public String getDivision() {
        return division;
    }
    @Column( name = "FullName")
    public String getFullname() {
        return fullname;
    }
    @Column( name = "Name")
    public String getName() {
        return name;
    }

    @OneToMany( mappedBy = "team")

    public Set<Player> getPlayer() {
        return player;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayer(Set<Player> player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Team{" +
                "idTeam=" + idTeam +
                ", Id=" + Id +
                ", abbreviation='" + abbreviation + '\'' +
                ", city='" + city + '\'' +
                ", conference='" + conference + '\'' +
                ", division='" + division + '\'' +
                ", fullname='" + fullname + '\'' +
                ", name='" + name + '\'' +
                ", player=" + player +
                '}';
    }
}
