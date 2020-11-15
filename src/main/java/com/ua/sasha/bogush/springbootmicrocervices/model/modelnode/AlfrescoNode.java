
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
        "entry"
})
public class AlfrescoNode implements Serializable {

    @JsonProperty("entry")
    private Entry entry;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 2140443597481057213L;

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
