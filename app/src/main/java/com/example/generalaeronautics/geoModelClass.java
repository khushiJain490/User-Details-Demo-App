package com.example.generalaeronautics;

import com.google.gson.annotations.SerializedName;

public class geoModelClass {

    @SerializedName("lat")
    private double lat;

    @SerializedName("lng")
    private double lng;

    public geoModelClass(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
