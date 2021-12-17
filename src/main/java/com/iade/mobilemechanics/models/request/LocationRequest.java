package com.iade.mobilemechanics.models.request;

public class LocationRequest {
    private double repair_lat;
    private double repair_long;

    public double getRepair_lat() {
        return repair_lat;
    }

    public void setRepair_lat(double repair_lat) {
        this.repair_lat = repair_lat;
    }

    public double getRepair_long() {
        return repair_long;
    }

    public void setRepair_long(double repair_long) {
        this.repair_long = repair_long;
    }
}
