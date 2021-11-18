package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="mechanics")
public class Mechanic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mechanic_id", nullable = false)
    private Integer id;

    @Column(name = "mechanic_person_id", nullable = false)
    private Integer mechanicPersonId;

    @Column(name = "mechanic_experience")
    private Integer mechanicExperience;

    @Column(name = "mechanic_about_me", length = 69)
    private String mechanicAboutMe;

    @Column(name = "mechanic_availability", nullable = false)
    private Boolean mechanicAvailability = false;

    public Boolean getMechanicAvailability() {
        return mechanicAvailability;
    }

    public void setMechanicAvailability(Boolean mechanicAvailability) {
        this.mechanicAvailability = mechanicAvailability;
    }

    public String getMechanicAboutMe() {
        return mechanicAboutMe;
    }

    public void setMechanicAboutMe(String mechanicAboutMe) {
        this.mechanicAboutMe = mechanicAboutMe;
    }

    public Integer getMechanicExperience() {
        return mechanicExperience;
    }

    public void setMechanicExperience(Integer mechanicExperience) {
        this.mechanicExperience = mechanicExperience;
    }

    public Integer getMechanicPersonId() {
        return mechanicPersonId;
    }

    public void setMechanicPersonId(Integer mechanicPersonId) {
        this.mechanicPersonId = mechanicPersonId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
