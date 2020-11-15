package com.ua.sasha.bogush.springbootmicrocervices.model.modelgroup;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "authorityType",
        "shortName",
        "fullName",
        "displayName",
        "url",
        "zones"
})
public class Groupe implements Serializable {

    @JsonProperty("authorityType")
    private String authorityType;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("url")
    private String url;
    @JsonProperty("zones")
    private List<String> zones = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 3089721599628101256L;

    @JsonProperty("authorityType")
    public String getAuthorityType() {
        return authorityType;
    }

    @JsonProperty("authorityType")
    public void setAuthorityType(String authorityType) {
        this.authorityType = authorityType;
    }

    @JsonProperty("shortName")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("shortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("zones")
    public List<String> getZones() {
        return zones;
    }

    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
