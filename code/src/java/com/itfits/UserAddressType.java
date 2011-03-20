package com.itfits;

/**
 * Created by IntelliJ IDEA.
 * User: glassfin
 * Date: 3/20/11
 * Time: 12:08 PM
 * To change this template use File | Settings | File Templates.
 */
public enum UserAddressType {
    HOME("pants"),
    BILLING("dress");

    public String displayName;

    UserAddressType(String displayName) {
        this.displayName = displayName;
    }
}