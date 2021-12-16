package com.iade.mobilemechanics.models.request;

public class CarRequest {
    private String carLicensePlate;
    private Integer carYear;
    private Integer carClientId;
    private Integer carModelId;
    private Integer carBrandId;
    private String carTransmission;
    private String carFuel;
    private Integer carEngineId;

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }

    public void setCarClientId(Integer carClientId) {
        this.carClientId = carClientId;
    }

    public void setCarModelId(Integer carModelId) {
        this.carModelId = carModelId;
    }

    public void setCarBrandId(Integer carBrandId) {
        this.carBrandId = carBrandId;
    }

    public void setCarTransmission(String carTransmission) {
        this.carTransmission = carTransmission;
    }

    public void setCarFuel(String carFuel) {
        this.carFuel = carFuel;
    }

    public void setCarEngineId(Integer carEngineId) {
        this.carEngineId = carEngineId;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public Integer getCarClientId() {
        return carClientId;
    }

    public Integer getCarModelId() {
        return carModelId;
    }

    public Integer getCarBrandId() {
        return carBrandId;
    }

    public String getCarTransmission() {
        return carTransmission;
    }

    public String getCarFuel() {
        return carFuel;
    }

    public Integer getCarEngineId() {
        return carEngineId;
    }
}
