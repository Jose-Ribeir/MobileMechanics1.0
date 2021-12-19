package com.iade.mobilemechanics.models.request;

import java.time.LocalDate;
import java.util.Date;

public class RepairDateRequest {
    private LocalDate repairDate;

    public LocalDate  getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(LocalDate  repairDate) {
        this.repairDate = repairDate;
    }
}
