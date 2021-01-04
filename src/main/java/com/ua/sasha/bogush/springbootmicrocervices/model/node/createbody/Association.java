
package com.ua.sasha.bogush.springbootmicrocervices.model.node.createbody;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
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
        "assocType"
})
public class Association implements Serializable {

    @JsonProperty("assocType")
    private String assocType;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5871353034613523117L;

    /**
     * No args constructor for use in serialization
     */
    public Association() {
    }

    /**
     * @param assocType
     */
    public Association(String assocType) {
        super();
        this.assocType = assocType;
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
