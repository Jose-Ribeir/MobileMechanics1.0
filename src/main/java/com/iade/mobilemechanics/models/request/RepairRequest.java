package com.iade.mobilemechanics.models.request;

import java.time.LocalDate;

public class RepairRequest {
private Integer repairCar;
private Integer repairMechanic;
private LocalDate repairDate;


    public Integer getRepairCar() {
        return repairCar;
    }

    public void setRepairCar(Integer repairCar) {
        this.repairCar = repairCar;
    }

    public Integer getReepairMechanic() {
        return repairMechanic;
    }

    public void setReepairMechanic(Integer repairMechanic) {
        this.repairMechanic = repairMechanic;
    }

    public Integer getRepairMechanic() {
        return repairMechanic;
    }

    public void setRepairMechanic(Integer repairMechanic) {
        this.repairMechanic = repairMechanic;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }
}
