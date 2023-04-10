
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
        "displayName",
        "id"
})
public class ModifiedByUser implements Serializable {

    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4176518958383847307L;

    /**
     * No args constructor for use in serialization
     */
    public ModifiedByUser() {
    }

    /**
     * @param displayName
     * @param id
     */
    public ModifiedByUser(String displayName, String id) {
        super();
        this.displayName = displayName;
        this.id = id;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
