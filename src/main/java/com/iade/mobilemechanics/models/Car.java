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

    @Column(name = "car_year", nullable = false)
    private Integer carYear;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_client_id", nullable = false)
    private Client carClient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_model_id", nullable = false)
    private ModelEngine carModel;

    @Column(name = "car_photo_id")
    private Integer carPhotoId;

    @Column(name = "car_transmission", nullable = false, length = 69)
    private String carTransmission;

    @Column(name = "car_information", length = 420)
    private String carInformation;

    @Column(name = "car_fuel", length = 8)
    private String carFuel;

    @Column(name = "car_brand_id")
    private Integer carBrandId;

    @Column(name = "car_engine_id")
    private Integer carEngineId;

    public Integer getCarEngineId() {
        return carEngineId;
    }

    public void setCarEngineId(Integer carEngineId) {
        this.carEngineId = carEngineId;
    }

    public Integer getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(Integer carBrandId) {
        this.carBrandId = carBrandId;
    }

    public String getCarFuel() {
        return carFuel;
    }

    public void setCarFuel(String carFuel) {
        this.carFuel = carFuel;
    }

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

    public ModelEngine getCarModel() {
        return carModel;
    }

    public void setCarModel(ModelEngine carModel) {
        this.carModel = carModel;
    }

    public Client getCarClient() {
        return carClient;
    }

    public void setCarClient(Client carClient) {
        this.carClient = carClient;
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

    public void setId(Integer id) {
        this.id = id;
    }
}
