package org.example;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name ="Players")
public class Player implements Serializable {

    // Atributos que devuelve la API en forma de JSON

    // idPlayer es la clave que relaciona team y player//
    //private int idEquipo;

    // id es la clave que yo duplico para autoincrementarla
    private int id;
    private int autoincrementalPlayer;
    private String firstName;

    private String lastName;

    private String position;

    private Integer heightFeet;

    private Integer heightInches;

    private Integer weightPounds;

    private Team team;



    // Constructor vacio necesario
    public Player() {
    }

    public Player(int id, String firstName, String lastName, String position, Integer heightFeet, Integer heightInches, Integer weightPounds, Team team) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.weightPounds = weightPounds;
        this.team = team;
    }

    // GETTER Y SETTER
    // LAS ANOTACIONES VAN EN EL GET //


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAutoincrementalPlayer() {
        return autoincrementalPlayer;
    }

    public void setAutoincrementalPlayer(int autoincrementalPlayer) {
        this.autoincrementalPlayer = autoincrementalPlayer;
    }

    @Column( name = "IdPlayer")
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getHeightFeet() {
        return heightFeet;
    }

    public Integer getHeightInches() {
        return heightInches;
    }

    public Integer getWeightPounds() {
        return weightPounds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHeightFeet(Integer heightFeet) {
        this.heightFeet = heightFeet;
    }

    public void setHeightInches(Integer heightInches) {
        this.heightInches = heightInches;
    }

    public void setWeightPounds(Integer weightPounds) {
        this.weightPounds = weightPounds;
    }

    // Id del equipo que relaciona ambas tablas //
    @Column(name = "first_name")
    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    @Column(name = "last_name")
    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "height_feet")
    public Integer getHeight_feet() {
        return heightFeet;
    }

    public void setHeight_feet(Integer height_feet) {
        this.heightFeet = height_feet;
    }

    @Column(name = "height_inches")
    public Integer getHeight_inches() {
        return heightInches;
    }

    public void setHeight_inches(Integer height_inches) {
        this.heightInches = height_inches;
    }

    @Column(name = "weight_pounds")
    public Integer getWeight_pounds() {
        return weightPounds;
    }

    public void setWeight_pounds(Integer weight_pounds) {
        this.weightPounds = weight_pounds;
    }


    @ManyToOne
    @JoinColumn(name = "IdTeam", insertable = false,updatable = false)
      public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", heightFeet=" + heightFeet +
                ", heightInches=" + heightInches +
                ", weightPounds=" + weightPounds +
                '}';
    }
}
