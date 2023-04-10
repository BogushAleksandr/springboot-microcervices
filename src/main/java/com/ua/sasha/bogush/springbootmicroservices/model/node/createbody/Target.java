
package com.ua.sasha.bogush.springbootmicroservices.model.node.createbody;

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
        "targetId",
        "assocType"
})
public class Target implements Serializable {

    @JsonProperty("targetId")
    private String targetId;
    @JsonProperty("assocType")
    private String assocType;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1881196268994390660L;

    /**
     * No args constructor for use in serialization
     */
    public Target() {
    }

    /**
     * @param targetId
     * @param assocType
     */
    public Target(String targetId, String assocType) {
        super();
        this.targetId = targetId;
        this.assocType = assocType;
    }

    @JsonProperty("targetId")
    public String getTargetId() {
        return targetId;
    }

    @JsonProperty("targetId")
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    @JsonProperty("assocType")
    public String getAssocType() {
        return assocType;
    }

    @JsonProperty("assocType")
    public void setAssocType(String assocType) {
        this.assocType = assocType;
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
