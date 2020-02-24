package com.sab.textquest;

import java.util.Map;

public class Location {

    int locationId;
    String locationDescription;

    Map<String, Integer> pathToChoose;

    public Location(int locationId, String locationDescription) {
        this.locationId = locationId;
        this.locationDescription = locationDescription;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public Map<String, Integer> getPathToChoose() {
        return pathToChoose;
    }

    public void setPathToChoose(Map<String, Integer> pathToChoose) {
        this.pathToChoose = pathToChoose;
    }
}
