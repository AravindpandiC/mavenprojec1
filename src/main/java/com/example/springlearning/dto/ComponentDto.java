package com.example.springlearning.dto;

import com.example.springlearning.entity.AttributeDto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.example.springlearning.entity.Component}
 */
public class ComponentDto implements Serializable {
    private Long id;
    private final Long referenceId;
    private final String referenceName;
    private final String componentName;
    private final List<AttributeDto> attributeDtos;

    public ComponentDto(Long referenceId, String referenceName, String componentName, List<AttributeDto> attributeDtos) {
        this.referenceId = referenceId;
        this.referenceName = referenceName;
        this.componentName = componentName;
        this.attributeDtos = attributeDtos;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentDto entity = (ComponentDto) o;
        return Objects.equals(this.referenceId, entity.referenceId) &&
                Objects.equals(this.referenceName, entity.referenceName) &&
                Objects.equals(this.componentName, entity.componentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenceId, referenceName, componentName);
    }

    public List<AttributeDto> getAttributeDtos() {
        return attributeDtos;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "referenceId = " + referenceId + ", " +
                "referenceName = " + referenceName + ", " +
                "componentName = " + componentName + ")";
    }
}