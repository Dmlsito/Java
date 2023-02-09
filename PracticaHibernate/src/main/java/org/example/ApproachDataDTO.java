package org.example;


import java.util.Set;

public class ApproachDataDTO {
    private String close_approach_date;
    private String close_approach_full;
    private String epoch_data_close_approach;
    private Set<RelativeVelocityDTO> relative_velocity;

    public ApproachDataDTO(String close_approach_date, String close_approach_full, String epoch_data_close_approach, Set<RelativeVelocityDTO> relative_velocity) {
        this.close_approach_date = close_approach_date;
        this.close_approach_full = close_approach_full;
        this.epoch_data_close_approach = epoch_data_close_approach;
        this.relative_velocity = relative_velocity;
    }
    public ApproachDataDTO(){}

    public String getClose_approach_date() {
        return close_approach_date;
    }

    public String getClose_approach_full() {
        return close_approach_full;
    }

    public String getEpoch_data_close_approach() {
        return epoch_data_close_approach;
    }

    public Set<RelativeVelocityDTO> getRelative_velocity() {
        return relative_velocity;
    }

    public void setClose_approach_date(String close_approach_date) {
        this.close_approach_date = close_approach_date;
    }

    public void setClose_approach_full(String close_approach_full) {
        this.close_approach_full = close_approach_full;
    }

    public void setEpoch_data_close_approach(String epoch_data_close_approach) {
        this.epoch_data_close_approach = epoch_data_close_approach;
    }

    public void setRelative_velocity(Set<RelativeVelocityDTO> relative_velocity) {
        this.relative_velocity = relative_velocity;
    }

    @Override
    public String toString() {
        return "ApproachData{" +
                "close_approach_date='" + close_approach_date + '\'' +
                ", close_approach_full='" + close_approach_full + '\'' +
                ", epoch_data_close_approach='" + epoch_data_close_approach + '\'' +
                ", relative_velocity=" + relative_velocity +
                '}';
    }
}
