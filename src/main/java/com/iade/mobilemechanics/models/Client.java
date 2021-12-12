package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Integer id;

    @Column(name = "client_person_id", nullable = false)
    private Integer clientPersonId;

    @Column(name = "client_nif", length = 69)
    private String clientNif;

    public String getClientNif() {
        return clientNif;
    }

    public void setClientNif(String clientNif) {
        this.clientNif = clientNif;
    }

    public Integer getClientPersonId() {
        return clientPersonId;
    }

    public void setClientPersonId(Integer clientPersonId) {
        this.clientPersonId = clientPersonId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
