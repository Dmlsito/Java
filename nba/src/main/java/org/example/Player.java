package org.example;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "Players")
public class Player implements Serializable {

    private int Id;
    private int idPlayer;
//Generas este atributo para que sea tu clave foranea
    private int teamId;
    private String firstName;

    private String lastName;

    private String position;

    private Integer heightFeet;

    private Integer heightInches;

    private Integer weightPounds;
    private Team team;


    public Player() {}
    /*En el constructor del player tambien le anado al constructor
    public Player(int idPlayer, int TeamId, String firstName, String lastName, String position, Integer heightFeet, Integer heightInches, Integer weightPounds, Team team) {

        this.idPlayer = idPlayer;
        this.teamId = TeamId ;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.weightPounds = weightPounds;
        this.team = team;
    }

     */
    public Player(int idPlayer, String firstName, String lastName, String position, Integer heightFeet, Integer heightInches, Integer weightPounds, Team team) {

        this.idPlayer = idPlayer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.weightPounds = weightPounds;
        this.team = team;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return Id;
    }
    @Column( name = "IdPlayer")
    public int getIdPlayer() {
        return idPlayer;
    }
    //Este es el metodo del que te hablo en el audio, fijate que cuando creamos el resto de columns tmbien las creamos
    //debajo de un get, porque es lo que nos va a devolver el valor
    public int getTeamId() {
        return teamId;
    }
    @Column( name = "FirstName")
    public String getFirstName() {
        return firstName;
    }
    @Column( name = "LastName")
    public String getLastName() {
        return lastName;
    }
    @Column( name = "Position")
    public String getPosition() {
        return position;
    }
    @Column( name = "HeightFeet")
    public Integer getHeightFeet() {
        return heightFeet;
    }
    @Column( name = "HeightInches")
    public Integer getHeightInches() {
        return heightInches;
    }
    @Column( name = "WeightPounds")
    public Integer getWeightPounds() {
        return weightPounds;
    }

    @ManyToOne
    @JoinColumn( name = "TeamId", insertable = false, updatable = false )
    public Team getTeam() {
        return team;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public void setTeamId(int TeamId) {
        this.teamId = TeamId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public void setTeam(Team team) {
        this.team = team;
    }


    @Override
    public String toString() {
        return "Player{" +
                "Id=" + Id +
                ", idPlayer=" + idPlayer +
                ", teamId=" + teamId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", heightFeet=" + heightFeet +
                ", heightInches=" + heightInches +
                ", weightPounds=" + weightPounds +
                ", team=" + team +
                '}';
    }
}
