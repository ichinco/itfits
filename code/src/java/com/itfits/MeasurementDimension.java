package com.itfits;

import java.lang.reflect.Type;

/**
 * Created by IntelliJ IDEA.
 * User: denise
 * Date: 3/21/11
 * Time: 9:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class MeasurementDimension<T> {

    private MeasurementType measurementType;

    public MeasurementType getMeasurementType() {
        return measurementType;
    }

    public MeasurementDimension(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }
}
