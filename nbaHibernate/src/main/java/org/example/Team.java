package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Teams")
public class Team implements Serializable {


    private int idTeam;


    private int id;

    private String abbreviation;

    private String city;

    private String conference;

    private String division;

    private String fullname;

    private String name;

    private Set<Player> players;

    public Team(){

    }
    public Team(int idTeam, String abbreviation, String city, String conference, String division, String fullname, String name) {
        this.idTeam = idTeam;
        this.abbreviation = abbreviation;
        this.city = city;
        this.conference = conference;
        this.division = division;
        this.fullname = fullname;
        this.name = name;

    }

    @Id
    @GeneratedValue()
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
    //Id del equipo
    @Column( name = "idTeam")
    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    @Column(name="Abbreviation")
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Column(name = "Conference")
    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }
    @Column(name="Divison")
    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
    @Column(name="Full_Name")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Column(name="Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Campo que se corresponde con la clase de ManyToOne, en este caso,
    // Un equipo puede tener varios jugador //
    // Lo que relaciona aqui es el objeto team, que hay en la clase player //

    @OneToMany(mappedBy = "team")
    public Set<Player> getPlayer() {
        return players;
    }

    public void setPlayer(Set<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", idTeam=" + idTeam +
                ", abbreviation='" + abbreviation + '\'' +
                ", city='" + city + '\'' +
                ", conference='" + conference + '\'' +
                ", division='" + division + '\'' +
                ", fullname='" + fullname + '\'' +
                ", name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
