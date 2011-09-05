package com.itfits;

/**
 * Created by IntelliJ IDEA.
 * User: glassfin
 * Date: 3/19/11
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ClothingType {
    PANTS(true, "pants", new MeasurementDimension[]{new MeasurementDimension<Integer>(MeasurementType.INSEAM), new MeasurementDimension<Integer>(MeasurementType.RISE)}),
    DRESS(true, "dress", new MeasurementDimension[]{}),
    BLAZER(true, "blazer", new MeasurementDimension[]{}),
    ACCESSORY(true, "accessory", new MeasurementDimension[]{}),
    OUTERWEAR(true, "outerwear", new MeasurementDimension[]{}),
    SHIRT(true, "shirt", new MeasurementDimension[]{}),
    SWEATER(true, "sweater", new MeasurementDimension[]{}),
    SHORTS(true, "shorts", new MeasurementDimension[]{}),
    APPAREL(true, "apparel", new MeasurementDimension[]{}),
    SWIMWEAR(true, "swimwear", new MeasurementDimension[]{}),
    SKIRT(true, "skirt", new MeasurementDimension[]{}),
    SOCKS(true, "socks", new MeasurementDimension[]{}),
    HUMAN_FEMALE(false, "girl", new MeasurementDimension[]{new MeasurementDimension<Integer>(MeasurementType.INSEAM), new MeasurementDimension<Integer>(MeasurementType.RISE)}),
    HUMAN_MALE(false, "guy", new MeasurementDimension[]{ new MeasurementDimension<Integer>(MeasurementType.NECK)});

    public String displayName;
    public boolean isClothing;
    public MeasurementDimension[] relevantDimensions;

    ClothingType(boolean isClothing, String displayName, MeasurementDimension[] relevantTypes) {
        this.displayName = displayName;
        this.relevantDimensions = relevantTypes;
        this.isClothing = isClothing;
    }

    public static ClothingType getByDisplayName(String name){
        for (ClothingType type : ClothingType.values()){
            if (type.displayName.equals(name)){
                return type;
            }
        }

        return null;
    }
}
