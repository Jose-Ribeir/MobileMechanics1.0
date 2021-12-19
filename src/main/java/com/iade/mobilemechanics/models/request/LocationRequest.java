package com.iade.mobilemechanics.models.request;

public class LocationRequest {
    private double repairLat;
    private double repairLong;

    public double getRepairLat() {
        return repairLat;
    }

    public void setRepairLat(double repairLat) {
        this.repairLat = repairLat;
    }

    public double getRepairLong() {
        return repairLong;
    }

    public void setRepairLong(double repairLong) {
        this.repairLong = repairLong;
    }
}
