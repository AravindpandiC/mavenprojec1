package com.example.springlearning.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * DTO for {@link com.example.springlearning.entity.Site}
 */
public class SiteDto implements Serializable {
    private final String siteName;
    private final String location;
    private  String status;
    private  Integer orderId;
    private  String createdBy;
    private  Instant createdAt;
    private  String updatedBy;
    private  Instant updatedAt;
    private  Boolean isActive;

    private final List<ComponentDto> componentDtos;

    public SiteDto(String siteName, String location, List<ComponentDto> componentDtos) {
        this.siteName = siteName;
        this.location = location;
        this.componentDtos = componentDtos;
    }


    public String getSiteName() {
        return siteName;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteDto entity = (SiteDto) o;
        return Objects.equals(this.siteName, entity.siteName) &&
                Objects.equals(this.location, entity.location) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.orderId, entity.orderId) &&
                Objects.equals(this.createdBy, entity.createdBy) &&
                Objects.equals(this.createdAt, entity.createdAt) &&
                Objects.equals(this.updatedBy, entity.updatedBy) &&
                Objects.equals(this.updatedAt, entity.updatedAt) &&
                Objects.equals(this.isActive, entity.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(siteName, location, status, orderId, createdBy, createdAt, updatedBy, updatedAt, isActive);
    }

    public List<ComponentDto> getComponentDtos() {
        return componentDtos;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "siteName = " + siteName + ", " +
                "location = " + location + ", " +
                "status = " + status + ", " +
                "orderId = " + orderId + ", " +
                "createdBy = " + createdBy + ", " +
                "createdAt = " + createdAt + ", " +
                "updatedBy = " + updatedBy + ", " +
                "updatedAt = " + updatedAt + ", " +
                "isActive = " + isActive + ")";
    }
}