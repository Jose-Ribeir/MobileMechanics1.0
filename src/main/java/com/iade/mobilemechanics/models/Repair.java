package com.iade.mobilemechanics.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="repairs")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_id", nullable = false)
    private Integer id;

    @Column(name = "repair_name", nullable = false, length = 69)
    private String repairName;

    @Column(name = "repair_date", nullable = false)
    private LocalDate repairDate;

    @Column(name = "repair_price", length = 69)
    private String repairPrice;

    @Column(name = "repair_mechanic_id")
    private Integer repairMechanicId;

    @Column(name = "repair_car_id")
    private Integer repairCarId;

    public Integer getRepairCarId() {
        return repairCarId;
    }

    public void setRepairCarId(Integer repairCarId) {
        this.repairCarId = repairCarId;
    }

    public Integer getRepairMechanicId() {
        return repairMechanicId;
    }

    public void setRepairMechanicId(Integer repairMechanicId) {
        this.repairMechanicId = repairMechanicId;
    }

    public String getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(String repairPrice) {
        this.repairPrice = repairPrice;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public Integer getId() {
        return id;
    }

}
