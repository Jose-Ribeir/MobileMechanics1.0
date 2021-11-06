package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="transmissions")
public class Transmissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transmission_id", nullable = false)
    private Integer id;

    @Column(name = "transmission_type", length = 69)
    private String transmissionType;

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public Integer getId() {
        return id;
    }

}
