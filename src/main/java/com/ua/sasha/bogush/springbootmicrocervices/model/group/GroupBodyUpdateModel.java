package com.ua.sasha.bogush.springbootmicrocervices.model.group;

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
        "displayName"
})
public class GroupBodyUpdateModel implements Serializable {
    @JsonProperty("displayName")
    private String displayName;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4606376082634559817L;

    /**
     * No args constructor for use in serialization
     */
    public GroupBodyUpdateModel() {
    }

    /**
     * @param displayName
     */
    public GroupBodyUpdateModel(String displayName) {
        super();
        this.displayName = displayName;
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
