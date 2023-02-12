package org.example;

public class ApproachDataDTO {

    private String close_approach_date;
    private String close_approach_date_full;
    private int epoch_date_close_approach;
    private String orbiting_body;
    private Planet planet;

    public ApproachDataDTO() {
    }

    public ApproachDataDTO(String close_approach_date, String close_approach_date_full, int epoch_date_close_approach, String orbiting_body, Planet planet) {
        this.close_approach_date = close_approach_date;
        this.close_approach_date_full = close_approach_date_full;
        this.epoch_date_close_approach = epoch_date_close_approach;
        this.orbiting_body = orbiting_body;
        this.planet = planet;
    }
    public String getClose_approach_date() {
        return close_approach_date;
    }

    public Planet getPlanet() {
        return planet;
    }

    public String getClose_approach_date_full() {
        return close_approach_date_full;
    }

    public int getEpoch_date_close_approach() {
        return epoch_date_close_approach;
    }

    public String getOrbiting_body() {
        return orbiting_body;
    }

    public void setClose_approach_date(String close_approach_date) {
        this.close_approach_date = close_approach_date;
    }

    public void setClose_approach_date_full(String close_approach_date_full) {
        this.close_approach_date_full = close_approach_date_full;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public void setEpoch_date_close_approach(int epoch_date_close_approach) {
        this.epoch_date_close_approach = epoch_date_close_approach;
    }

    public void setOrbiting_body(String orbiting_body) {
        this.orbiting_body = orbiting_body;
    }

    @Override
    public String toString() {
        return "ApproachDataDTO{" +
                "close_approach_date='" + close_approach_date + '\'' +
                ", close_approach_date_full='" + close_approach_date_full + '\'' +
                ", epoch_date_close_approach=" + epoch_date_close_approach +
                ", orbiting_body='" + orbiting_body + '\'' +
                '}';
    }
}
