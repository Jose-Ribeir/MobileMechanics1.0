package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Integer id;

    @Column(name = "person_name", nullable = false, length = 69)
    private String personName;

    @Column(name = "person_phone_number", length = 69)
    private String personPhoneNumber;

    @Column(name = "person_email", length = 69)
    private String personEmail;

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonPhoneNumber() {
        return personPhoneNumber;
    }

    public void setPersonPhoneNumber(String personPhoneNumber) {
        this.personPhoneNumber = personPhoneNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getId() {
        return id;
    }

}
