package com.iade.mobilemechanics.models.request;

import java.time.LocalDate;

public class RepairRequest {
private Integer repairCar;
private Integer repairMechanic;
private LocalDate repairDate;
private Boolean repairTaken;
private Boolean repairCompleted;

    public Integer getRepairCar() {
        return repairCar;
    }

    public void setRepairCar(Integer repairCar) {
        this.repairCar = repairCar;
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

    public Boolean getRepairTaken() {
        return false;
    }

    public void setRepairTaken(Boolean repairTaken) {
        this.repairTaken = Boolean.FALSE;
    }

    public Boolean getRepairCompleted() {
        return false;
    }

    public void setRepairCompleted(Boolean repairCompleted) {
        this.repairCompleted = Boolean.FALSE;
    }
}
