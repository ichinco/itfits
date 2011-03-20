package com.itfits;

/**
 * Created by IntelliJ IDEA.
 * User: glassfin
 * Date: 3/19/11
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ClothingType {
    PANTS("pants"),
    DRESS("dress");

    public String displayName;

    ClothingType(String displayName) {
        this.displayName = displayName;
    }
}
