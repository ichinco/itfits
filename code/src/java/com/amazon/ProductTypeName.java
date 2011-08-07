package com.amazon;

import com.itfits.ClothingType;

/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 8/7/11
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ProductTypeName {
    BAG(null),
    CARRYING_CASE_OR_BAG(null),
    CONSUMER_ELECTRONICS(null),
    ABIS_ELECTRONICS(null),
    SPORTING_GOODS(null),
    BLAZER(ClothingType.BLAZER),
    DRESS(ClothingType.DRESS),
    ACCESSORY(ClothingType.ACCESSORY),
    PANTS(ClothingType.PANTS),
    TOYS_AND_GAMES(null),
    OUTERWEAR(ClothingType.OUTERWEAR),
    SHIRT(ClothingType.SHIRT),
    SWEATER(ClothingType.SWEATER),
    SHORTS(ClothingType.SHORTS),
    APPAREL(ClothingType.APPAREL),
    SWIMWEAR(ClothingType.SWIMWEAR),
    CE_ACCESSORY(null),
    BABY_PRODUCT(null),
    SKIRT(ClothingType.SKIRT),
    SOCKSHOSIERY(ClothingType.SOCKS);

    private ClothingType type;

    ProductTypeName(ClothingType type) {
        this.type = type;
    }

    public ClothingType getType() {
        return type;
    }

    public void setType(ClothingType type) {
        this.type = type;
    }
}
