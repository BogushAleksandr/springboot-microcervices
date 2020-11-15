
package com.ua.sasha.bogush.springbootmicrocervices.model.modelnode;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "displayName"
})
public class CreatedByUser implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("displayName")
    private String displayName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 7283473002893908162L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
