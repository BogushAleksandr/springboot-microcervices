
package com.ua.sasha.bogush.springbootmicroservices.model.group;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 30.12.2020
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
public class Datum implements Serializable {

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
    @Valid
    private List<String> zones = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3611603584687499646L;

    /**
     * No args constructor for use in serialization
     */
    public Datum() {
    }

    /**
     * @param displayName
     * @param fullName
     * @param shortName
     * @param zones
     * @param authorityType
     * @param url
     */
    public Datum(String authorityType, String shortName, String fullName, String displayName, String url, List<String> zones) {
        super();
        this.authorityType = authorityType;
        this.shortName = shortName;
        this.fullName = fullName;
        this.displayName = displayName;
        this.url = url;
        this.zones = zones;
    }

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
