package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    private Integer id;

    @Column(name = "car_license_plate", length = 8)
    private String carLicensePlate;

    @Column(name = "car_year")
    private Integer carYear;

    @Column(name = "car_client_id")
    private Integer carClientId;

    @Column(name = "car_model_engine_id")
    private Integer carModelEngineId;

    @Column(name = "car_photo_id")
    private Integer carPhotoId;

    @Column(name = "car_transmission", length = 69)
    private String carTransmission;

    @Column(name = "car_information", length = 420)
    private String carInformation;

    public String getCarInformation() {
        return carInformation;
    }

    public void setCarInformation(String carInformation) {
        this.carInformation = carInformation;
    }

    public String getCarTransmission() {
        return carTransmission;
    }

    public void setCarTransmission(String carTransmission) {
        this.carTransmission = carTransmission;
    }

    public Integer getCarPhotoId() {
        return carPhotoId;
    }

    public void setCarPhotoId(Integer carPhotoId) {
        this.carPhotoId = carPhotoId;
    }

    public Integer getCarModelEngineId() {
        return carModelEngineId;
    }

    public void setCarModelEngineId(Integer carModelEngineId) {
        this.carModelEngineId = carModelEngineId;
    }

    public Integer getCarClientId() {
        return carClientId;
    }

    public void setCarClientId(Integer carClientId) {
        this.carClientId = carClientId;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    public Integer getId() {
        return id;
    }

}
