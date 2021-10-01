package org.test.shiftTest.services;

import org.test.shiftTest.models.Dimensions;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DimensionsConverter implements AttributeConverter<Dimensions, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Dimensions dimensions) {
        return dimensions.getValue();
    }

    @Override
    public Dimensions convertToEntityAttribute(Integer integer) {
        return Dimensions.getByValue(integer);
    }
}
