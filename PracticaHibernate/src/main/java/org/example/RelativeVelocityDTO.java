package org.example;

public class RelativeVelocityDTO {

    private double kilometers_per_seconds;
    private double kilometers_per_hour;
    private double miles_per_hour;
    private ApproachDataDTO approachData;


    public RelativeVelocityDTO(){}

    public RelativeVelocityDTO(double kilometers_per_seconds, double kilometers_per_hour, double miles_per_hour, ApproachDataDTO approachData) {
        this.kilometers_per_seconds = kilometers_per_seconds;
        this.kilometers_per_hour = kilometers_per_hour;
        this.miles_per_hour = miles_per_hour;
        this.approachData = approachData;
    }

    public double getKilometers_per_seconds() {
        return kilometers_per_seconds;
    }

    public double getKilometers_per_hour() {
        return kilometers_per_hour;
    }

    public double getMiles_per_hour() {
        return miles_per_hour;
    }

    public void setKilometers_per_seconds(double kilometers_per_seconds) {
        this.kilometers_per_seconds = kilometers_per_seconds;
    }

    public void setKilometers_per_hour(double kilometers_per_hour) {
        this.kilometers_per_hour = kilometers_per_hour;
    }

    public void setMiles_per_hour(double miles_per_hour) {
        this.miles_per_hour = miles_per_hour;
    }

    public ApproachDataDTO getApproachData() {
        return approachData;
    }

    public void setApproachData(ApproachDataDTO approachData) {
        this.approachData = approachData;
    }

    @Override
    public String toString() {
        return "RelativeVelocity{" +
                "kilometers_per_seconds=" + kilometers_per_seconds +
                ", kilometers_per_hour=" + kilometers_per_hour +
                ", miles_per_hour=" + miles_per_hour +
                '}';
    }
}
