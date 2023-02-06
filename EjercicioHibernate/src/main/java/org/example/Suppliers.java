package org.example;

import java.io.Serializable;

public class Suppliers implements Serializable {

    private int supplierId;
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private String homepage;

    public Suppliers(){}
    public Suppliers(String companyName, String contactName, String contactTitle, String address, String city, String region,
                     String postalCode, String country, String phone, String fax, String homepage ){
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.fax = fax;
        this.homepage = homepage;

    }
    public String getCompanyName(){
        return this.companyName;
    }
    public void setCompanyName(String company){
        this.contactName = contactName;
    }
    public String getAdress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getContactName(){
        return this.contactName;
    }
    public void setContactName(String contactName){
        this.contactName = contactName;
    }
    public String getContactTitle(){
        return this.contactTitle;
    }
    public void setContactTitle(String contactTitle){
        this.contactTitle = contactTitle;
    }
    public String getCity(){
        return this.city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getRegion(){
        return this.region;
    }
    public void setRegion(String region){
        this.region = region;
    }
    public String getPostalCode(){
        return this.postalCode;
    }
    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    public String getCountry(){
        return this.country;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getFax(){
        return this.fax;
    }
    public void setFax(String fax){
        this.fax = fax;
    }
    public String getHomepage(){
        return this.homepage;
    }
    public void setHomepage(String homepage){
        this.homepage = homepage;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "supplierId=" + supplierId +
                ", companyName='" + companyName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactTitle='" + contactTitle + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", homepage='" + homepage + '\'' +
                '}';
    }
}
