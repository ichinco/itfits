package com.itfits;


import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 2/19/11
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 */
public enum MeasurementType {
    INSEAM("inseam"),
    RISE("rise"),
    WAIST("waist"),
    HIPS("hips"),
    NECK("neck");

    public String displayName;

    MeasurementType(String displayName) {
        this.displayName = displayName;
    }
}
