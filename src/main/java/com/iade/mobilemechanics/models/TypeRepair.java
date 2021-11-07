package com.iade.mobilemechanics.models;

import javax.persistence.*;

@Entity
@Table(name="type_repair")
public class TypeRepair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_repair_id", nullable = false)
    private Integer id;

    @Column(name = "type_repair_name", length = 69)
    private String typeRepairName;

    public String getTypeRepairName() {
        return typeRepairName;
    }

    public void setTypeRepairName(String typeRepairName) {
        this.typeRepairName = typeRepairName;
    }

    public Integer getId() {
        return id;
    }
}
