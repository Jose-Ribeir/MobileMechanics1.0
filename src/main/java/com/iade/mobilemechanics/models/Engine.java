package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="engines")
public class Engine {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "engine_id", nullable = false)
    private Integer id;

    @Column(name = "engine_name", length = 69)
    private String engineName;

    @Column(name = "engine_oil", length = 69)
    private String engineOil;

    @Column(name = "engine_displacement", length = 69)
    private String engineDisplacement;

    public String getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(String engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public String getEngineOil() {
        return engineOil;
    }

    public void setEngineOil(String engineOil) {
        this.engineOil = engineOil;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
