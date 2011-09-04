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
    DRESS("dress", new MeasurementDimension[]{}),
    BLAZER("blazer", new MeasurementDimension[]{}),
    ACCESSORY("accessory", new MeasurementDimension[]{}),
    OUTERWEAR("outerwear", new MeasurementDimension[]{}),
    SHIRT("shirt", new MeasurementDimension[]{}),
    SWEATER("sweater", new MeasurementDimension[]{}),
    SHORTS("shorts", new MeasurementDimension[]{}),
    APPAREL("apparel", new MeasurementDimension[]{}),
    SWIMWEAR("swimwear", new MeasurementDimension[]{}),
    SKIRT("skirt", new MeasurementDimension[]{}),
    SOCKS("socks", new MeasurementDimension[]{}),
    HUMAN_FEMALE("girl", new MeasurementDimension[]{new MeasurementDimension<Integer>(MeasurementType.INSEAM), new MeasurementDimension<Integer>(MeasurementType.RISE)}),
    HUMAN_MALE("guy", new MeasurementDimension[]{ new MeasurementDimension<Integer>(MeasurementType.NECK)});

    public String displayName;
    public MeasurementDimension[] relevantDimensions;

    ClothingType(String displayName, MeasurementDimension[] relevantTypes) {
        this.displayName = displayName;
        this.relevantDimensions = relevantTypes;
    }
}
