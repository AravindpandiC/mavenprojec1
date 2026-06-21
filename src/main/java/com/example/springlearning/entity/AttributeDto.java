package com.example.springlearning.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Attribute}
 */
public class AttributeDto implements Serializable {
    private final Long componentId;
    private final String attributeName;
    private final String attributeValue;

    public AttributeDto(Long componentId, String attributeName, String attributeValue) {
        this.componentId = componentId;
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    public Long getComponentId() {
        return componentId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeDto entity = (AttributeDto) o;
        return Objects.equals(this.componentId, entity.componentId) &&
                Objects.equals(this.attributeName, entity.attributeName) &&
                Objects.equals(this.attributeValue, entity.attributeValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentId, attributeName, attributeValue);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "componentId = " + componentId + ", " +
                "attributeName = " + attributeName + ", " +
                "attributeValue = " + attributeValue + ")";
    }
}