
package com.ua.sasha.bogush.springbootmicroservices.model.group;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 30.12.2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
public class GroupModel implements Serializable {

    @JsonProperty("data")
    @Valid
    private List<Datum> data = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7839523705929869996L;

    /**
     * No args constructor for use in serialization
     */
    public GroupModel() {
    }

    /**
     * @param data
     */
    public GroupModel(List<Datum> data) {
        super();
        this.data = data;
    }

    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
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
