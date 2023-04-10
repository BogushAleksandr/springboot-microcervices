
package com.ua.sasha.bogush.springbootmicroservices.model.node.childresponse;

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
        "entry"
})
public class CreateSecondaryChildResponseModel implements Serializable {

    @JsonProperty("entry")
    @Valid
    private Entry entry;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6169892092682579007L;

    /**
     * No args constructor for use in serialization
     */
    public CreateSecondaryChildResponseModel() {
    }

    /**
     * @param entry
     */
    public CreateSecondaryChildResponseModel(Entry entry) {
        super();
        this.entry = entry;
    }

    @JsonProperty("entry")
    public Entry getEntry() {
        return entry;
    }

    @JsonProperty("entry")
    public void setEntry(Entry entry) {
        this.entry = entry;
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
