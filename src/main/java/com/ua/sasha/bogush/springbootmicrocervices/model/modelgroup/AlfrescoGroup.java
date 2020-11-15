package com.ua.sasha.bogush.springbootmicrocervices.model.modelgroup;

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
        "data"
})
public class AlfrescoGroup implements Serializable {

    @JsonProperty("data")
    private Groupe groupe;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 3422432291849261426L;

    @JsonProperty("data")
    public Groupe getData() {
        return groupe;
    }

    @JsonProperty("data")
    public void setData(Groupe groupe) {
        this.groupe = groupe;
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