package org.example;

import java.util.Set;

public class TeamDTO {

    private int id;

    private String abbreviation;

    private String city;

    private String conference;

    private String division;

    private String full_name;

    private String name;

    private Set<Player> player;

    public TeamDTO() {

    }

    public TeamDTO(int id, String abbreviation, String city, String conference, String division, String full_name, String name) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.city = city;
        this.conference = conference;
        this.division = division;
        this.full_name = full_name;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getCity() {
        return city;
    }

    public String getConference() {
        return conference;
    }

    public String getDivision() {
        return division;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getName() {
        return name;
    }

    public Set<Player> getPlayer() {
        return player;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayer(Set<Player> player) {
        this.player = player;
    }


}
