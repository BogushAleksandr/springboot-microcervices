
package com.ua.sasha.bogush.springbootmicroservices.model.node;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 30.12.2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "authorityId",
        "name",
        "accessStatus"
})
public class LocallySet implements Serializable {

    @JsonProperty("authorityId")
    private String authorityId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("accessStatus")
    private String accessStatus;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4310978370254929415L;

    /**
     * No args constructor for use in serialization
     */
    public LocallySet() {
    }

    /**
     * @param authorityId
     * @param name
     * @param accessStatus
     */
    public LocallySet(String authorityId, String name, String accessStatus) {
        super();
        this.authorityId = authorityId;
        this.name = name;
        this.accessStatus = accessStatus;
    }

    @JsonProperty("authorityId")
    public String getAuthorityId() {
        return authorityId;
    }

    @JsonProperty("authorityId")
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("accessStatus")
    public String getAccessStatus() {
        return accessStatus;
    }

    @JsonProperty("accessStatus")
    public void setAccessStatus(String accessStatus) {
        this.accessStatus = accessStatus;
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
