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

    @ManyToOne
    @JoinColumn(name = "model_brand_id")
    private Brand modelBrand;

    public Brand getModelBrand() {
        return modelBrand;
    }

    public void setModelBrand(Brand modelBrand) {
        this.modelBrand = modelBrand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
