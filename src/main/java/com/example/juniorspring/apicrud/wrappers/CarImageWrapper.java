package com.example.juniorspring.apicrud.wrappers;

public class CarImageWrapper {
    private int carId;
    private String kontenType;
    private String base64;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getKontenType() {
        return kontenType;
    }

    public void setKontenType(String kontenType) {
        this.kontenType = kontenType;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    @Override
    public String toString() {
        return "CarImageWrapper{" +
                "carId=" + carId +
                ", kontenType='" + kontenType + '\'' +
                ", base64='" + base64 + '\'' +
                '}';
    }
}