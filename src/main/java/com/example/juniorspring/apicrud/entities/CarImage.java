package com.example.juniorspring.apicrud.entities;

import javax.persistence.*;

@Entity
@Table(name="car_image")
public class CarImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private CarEntity car;

    @Lob
    private String base64;

    private String kontenType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getKontenType() {
        return kontenType;
    }

    public void setKontenType(String kontenType) {
        this.kontenType = kontenType;
    }
}
