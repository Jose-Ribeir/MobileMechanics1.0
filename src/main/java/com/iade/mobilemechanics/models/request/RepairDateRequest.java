package com.iade.mobilemechanics.models.request;

import java.time.Instant;


public class RepairDateRequest {
    private Instant repairDate;

    public Instant getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Instant repairDate) {
        this.repairDate = repairDate;
    }
}
