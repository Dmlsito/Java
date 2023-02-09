package org.example;

public class PlayerDTO {

    // idPlayer es la clave que relaciona team y player//
    //private int idEquipo;

    private int id;
    private String first_name;

    private String last_name;

    private String position;

    private Integer height_feet;

    private Integer height_inches;

    private Integer weight_pounds;

    private Team team;




    public PlayerDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getHeight_feet() {
        return height_feet;
    }

    public void setHeight_feet(Integer height_feet) {
        this.height_feet = height_feet;
    }

    public Integer getHeight_inches() {
        return height_inches;
    }

    public void setHeight_inches(Integer height_inches) {
        this.height_inches = height_inches;
    }

    public Integer getWeight_pounds() {
        return weight_pounds;
    }

    public void setWeight_pounds(Integer weight_pounds) {
        this.weight_pounds = weight_pounds;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
