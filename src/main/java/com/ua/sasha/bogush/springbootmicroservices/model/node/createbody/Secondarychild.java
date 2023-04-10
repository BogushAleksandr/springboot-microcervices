
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
        "childId",
        "assocType"
})
public class Secondarychild implements Serializable {

    @JsonProperty("childId")
    private String childId;
    @JsonProperty("assocType")
    private String assocType;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1775847016972585459L;

    /**
     * No args constructor for use in serialization
     */
    public Secondarychild() {
    }

    /**
     * @param assocType
     * @param childId
     */
    public Secondarychild(String childId, String assocType) {
        super();
        this.childId = childId;
        this.assocType = assocType;
    }

    @JsonProperty("childId")
    public String getChildId() {
        return childId;
    }

    @JsonProperty("childId")
    public void setChildId(String childId) {
        this.childId = childId;
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
