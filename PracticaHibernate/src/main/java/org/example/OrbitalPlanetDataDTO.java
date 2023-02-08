package org.example;

import java.sql.Timestamp;

public class OrbitalPlanetDataDTO {

    private String orbit_id;
    private int planetId;
    private String orbit_determination_date;
    private String first_observation_date;
    private String last_observation_date;
    private int data_arc_in_days;
    private int observations_used;
    private String orbit_uncertainty;
    private String minimum_orbit_intersection;
    private String jupiter_tisserand_invariant;
    private String epoch_osculation;
    private String eccentricity;
    private String semi_major_axis;
    private String inclination;
    private String ascending_node_longitude;
    private String orbital_period;
    private String perihelion_distance;
    private String perihelion_argument;
    private Planet planet;

    public OrbitalPlanetDataDTO(String orbit_id, String orbit_determination_date, String first_observation_date, String last_observation_date, int data_arc_in_days, int observation_used, String orbit_uncertainty, String minimun_orbit_intersection, String jupiter_tisserand_invariant, String epoch_osculation, String eccentricity, String semi_major_axis, String inclination, String ascending_node_longitude, String orbital_period, String perihelion_argument, String perihelion_distance) {
        this.orbit_id = orbit_id;

        this.orbit_determination_date = orbit_determination_date;
        this.first_observation_date = first_observation_date;
        this.last_observation_date = last_observation_date;
        this.data_arc_in_days = data_arc_in_days;
        this.observations_used = observation_used;
        this.orbit_uncertainty = orbit_uncertainty;
        this.minimum_orbit_intersection = minimun_orbit_intersection;
        this.jupiter_tisserand_invariant = jupiter_tisserand_invariant;
        this.epoch_osculation = epoch_osculation;
        this.eccentricity = eccentricity;
        this.semi_major_axis = semi_major_axis;
        this.inclination = inclination;
        this.ascending_node_longitude = ascending_node_longitude;
        this.orbital_period = orbital_period;
        this.perihelion_argument = perihelion_argument;
        this.perihelion_distance = perihelion_distance;

    }
    public OrbitalPlanetDataDTO(){

    }

    public String getOrbit_id() {
        return orbit_id;
    }



    public String getOrbit_determination_date() {
        return orbit_determination_date;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public String getPerihelion_distanced() {
        return perihelion_distance ;
    }

    public String getPerihelion_argument() {
        return perihelion_argument;
    }

    public Planet getPlanet() {
        return planet;
    }

    public String getFirst_observation_date() {
        return first_observation_date;
    }

    public String getLast_observation_date() {
        return last_observation_date;
    }

    public int getData_arc_in_days() {
        return data_arc_in_days;
    }

    public int getObservation_used() {
        return observations_used;
    }

    public String getOrbit_uncertainty() {
        return orbit_uncertainty;
    }

    public String getMinimun_orbit_intersection() {
        return minimum_orbit_intersection;
    }

    public String getJupiter_tisserand_invariant() {
        return jupiter_tisserand_invariant;
    }

    public String getEpoch_osculation() {
        return epoch_osculation;
    }

    public String getEccentricity() {
        return eccentricity;
    }

    public String getSemi_major_axis() {
        return semi_major_axis;
    }

    public String getInclination() {
        return inclination;
    }

    public String getAscending_node_longitude() {
        return ascending_node_longitude;
    }
    public String getPerihelion_distance(){
        return this.perihelion_distance;
    }

    public void setOrbit_id(String orbit_id) {
        this.orbit_id = orbit_id;
    }

    public void setOrbit_determination_date(String orbit_determination_date) {
        this.orbit_determination_date = orbit_determination_date;
    }

    public void setFirst_observation_date(String first_observation_date) {
        this.first_observation_date = first_observation_date;
    }

    public void setLast_observation_date(String last_observation_date) {
        this.last_observation_date = last_observation_date;
    }

    public void setData_arc_in_days(int data_arc_in_days) {
        this.data_arc_in_days = data_arc_in_days;
    }

    public void setObservation_used(int observation_used) {
        this.observations_used = observation_used;
    }

    public void setOrbit_uncertainty(String orbit_uncertainty) {
        this.orbit_uncertainty = orbit_uncertainty;
    }

    public void setMinimun_orbit_intersection(String minimun_orbit_intersection) {
        this.minimum_orbit_intersection = minimun_orbit_intersection;
    }

    public void setJupiter_tisserand_invariant(String jupiter_tisserand_invariant) {
        this.jupiter_tisserand_invariant = jupiter_tisserand_invariant;
    }

    public void setEpoch_osculation(String epoch_osculation) {
        this.epoch_osculation = epoch_osculation;
    }

    public void setEccentricity(String eccentricity) {
        this.eccentricity = eccentricity;
    }

    public void setSemi_major_axis(String semi_major_axis) {
        this.semi_major_axis = semi_major_axis;
    }

    public void setInclination(String inclination) {
        this.inclination = inclination;
    }

    public void setAscending_node_longitude(String ascending_node_longitude) {
        this.ascending_node_longitude = ascending_node_longitude;
    }

    public void setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
    }

    public void setAphelion_distance(String perihelion_distanced) {
        this.perihelion_distance  = perihelion_distanced;
    }

    public void setPerihelion_argument(String perihelion_argument) {
        this.perihelion_argument = perihelion_argument;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    @Override
    public String toString() {
        return "OrbitalPlanetDataDTO{" +
                "orbit_id=" + orbit_id +

                ", orbit_determination_date=" + orbit_determination_date +
                ", first_observation_date=" + first_observation_date +
                ", last_observation_date=" + last_observation_date +
                ", data_arc_in_days=" + data_arc_in_days +
                ", observation_used=" + observations_used +
                ", orbit_uncertainty='" + orbit_uncertainty + '\'' +
                ", minimun_orbit_intersection='" + minimum_orbit_intersection + '\'' +
                ", jupiter_tisserand_invariant='" + jupiter_tisserand_invariant + '\'' +
                ", epoch_osculation='" + epoch_osculation + '\'' +
                ", eccentricity='" + eccentricity + '\'' +
                ", semi_major_axis='" + semi_major_axis + '\'' +
                ", inclination='" + inclination + '\'' +
                ", ascending_node_longitude='" + ascending_node_longitude + '\'' +
                ", orbital_period='" + orbital_period + '\'' +
                ", perihelion_distanced='" + perihelion_distance  + '\'' +
                ", perihelion_argument='" + perihelion_argument + '\'' +
                ", planet=" + planet +
                '}';
    }
}
