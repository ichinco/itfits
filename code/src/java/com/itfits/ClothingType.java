package com.itfits;

/**
 * Created by IntelliJ IDEA.
 * User: glassfin
 * Date: 3/19/11
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ClothingType {
    PANTS("pants", new MeasurementDimension[]{new MeasurementDimension<Integer>(MeasurementType.INSEAM), new MeasurementDimension<Integer>(MeasurementType.RISE)}),
    DRESS("dress", new MeasurementDimension[]{});

    public String displayName;
    public MeasurementDimension[] relevantDimensions;

    ClothingType(String displayName, MeasurementDimension[] relevantTypes) {
        this.displayName = displayName;
        this.relevantDimensions = relevantTypes;
    }
}
