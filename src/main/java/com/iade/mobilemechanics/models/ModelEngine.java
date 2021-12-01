package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="model_engine")
public class ModelEngine {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_engine_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "model_engine_engine_id")
    private Engine modelEngineEngine;

    @ManyToOne
    @JoinColumn(name = "model_engine_model_id")
    private Model modelEngineModel;

    public Model getModelEngineModel() {
        return modelEngineModel;
    }

    public void setModelEngineModel(Model modelEngineModel) {
        this.modelEngineModel = modelEngineModel;
    }

    public Engine getModelEngineEngine() {
        return modelEngineEngine;
    }

    public void setModelEngineEngine(Engine modelEngineEngine) {
        this.modelEngineEngine = modelEngineEngine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
