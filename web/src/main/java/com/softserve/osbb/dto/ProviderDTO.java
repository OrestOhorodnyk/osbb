package com.softserve.osbb.dto;


import com.softserve.osbb.model.Bill;
import com.softserve.osbb.model.Contract;
import com.softserve.osbb.model.ProviderType;
import com.softserve.osbb.model.enums.Periodicity;

import java.util.Collection;

/**
 * Created by Anastasiia Fedorak on 8/2/16.
 */
public class ProviderDTO {
    private Integer providerId;
    private String name;
    private String description;
    private String logoUrl;
    private String periodicity;
    private Integer type;

    public ProviderDTO() {
    }

    public ProviderDTO(Integer providerId, String name, String description, String logoUrl, Periodicity periodicity, ProviderType type) {
        this.providerId = providerId;
        this.name = name;
        this.description = description;
        this.logoUrl = logoUrl;
        this.periodicity = periodicity != null ? periodicity.toString() : "";
        this.type = type != null ? type.getProviderTypeId(): 0;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
