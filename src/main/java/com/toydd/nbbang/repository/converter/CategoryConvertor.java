package com.toydd.nbbang.repository.converter;

import com.toydd.nbbang.payment.Category;

import javax.persistence.AttributeConverter;

public class CategoryConvertor implements AttributeConverter<Category, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Category attribute) {
        return attribute.getCode();
    }

    @Override
    public Category convertToEntityAttribute(Integer dbData) {
        return Category.ofCategoryCode(dbData);
    }
}
