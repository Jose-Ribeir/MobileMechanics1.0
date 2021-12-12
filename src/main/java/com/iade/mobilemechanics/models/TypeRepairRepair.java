package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="type_repair_repair")
public class TypeRepairRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_repair_repair_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "type_repair_repair_type_repair_id")
    private TypeRepair typeRepairRepairTypeRepair;

    @ManyToOne
    @JoinColumn(name = "type_repair_repair_repair_id")
    private Repair typeRepairRepairRepair;

    public Repair getTypeRepairRepairRepair() {
        return typeRepairRepairRepair;
    }

    public void setTypeRepairRepairRepair(Repair typeRepairRepairRepair) {
        this.typeRepairRepairRepair = typeRepairRepairRepair;
    }

    public TypeRepair getTypeRepairRepairTypeRepair() {
        return typeRepairRepairTypeRepair;
    }

    public void setTypeRepairRepairTypeRepair(TypeRepair typeRepairRepairTypeRepair) {
        this.typeRepairRepairTypeRepair = typeRepairRepairTypeRepair;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public int getTypeRepairRepairId() {
        return id;
    }


}
