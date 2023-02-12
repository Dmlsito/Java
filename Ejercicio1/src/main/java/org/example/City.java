package org.example;

import javax.xml.bind.annotation.XmlAttribute;

public class City {

    private String name;
    private String code;

    public City() {
    }
    public City(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
    @XmlAttribute(name = "Name")
    public void setName(String name) {
        this.name = name;
    }
    @XmlAttribute(name = "Code")
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
