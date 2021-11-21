package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="model_engine")
public class ModelEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_engine_id", nullable = false)
    private Integer id;

    @Column(name = "model_engine_engine_id")
    private Integer modelEngineEngineId;

    @Column(name = "model_engine_model_id")
    private Integer modelEngineModelId;

    public Integer getModelEngineModelId() {
        return modelEngineModelId;
    }

    public void setModelEngineModelId(Integer modelEngineModelId) {
        this.modelEngineModelId = modelEngineModelId;
    }

    public Integer getModelEngineEngineId() {
        return modelEngineEngineId;
    }

    public void setModelEngineEngineId(Integer modelEngineEngineId) {
        this.modelEngineEngineId = modelEngineEngineId;
    }

    public Integer getId() {
        return id;
    }


}
