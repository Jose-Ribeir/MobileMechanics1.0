package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id", nullable = false)
    private Integer id;

    @Column(name = "model_name", length = 69)
    private String modelName;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getId() {
        return id;
    }

}
