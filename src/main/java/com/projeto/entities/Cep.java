package com.projeto.entities;

public class Cep {

    private String cep;
    private String street;
    private String district;
    private String city;
    private String state;

    public Cep(String cep, String street, String district, String city, String state) {
        this.cep = cep;
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public String getStreet() {
        return street;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
