package com.itfits;

/**
 * Created by IntelliJ IDEA.
 * User: glassfin
 * Date: 3/19/11
 * Time: 9:49 PM
 * To change this template use File | Settings | File Templates.
 */
public enum RatingDimension {
    DURABILITY("durability"),
    IN_STYLE("in style"),
    DIRT_RESIST("dirt resistant"),
    WATERPROOF("waterproofness"),
    SHEAR("shearness"),
    BLEED("color-fastness");

    private String displayName;

    RatingDimension(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
