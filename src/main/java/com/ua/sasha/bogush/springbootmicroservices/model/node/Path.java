
package com.ua.sasha.bogush.springbootmicroservices.model.node;

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
        "elements",
        "name",
        "isComplete"
})
public class Path implements Serializable {

    @JsonProperty("elements")
    @Valid
    private List<Element> elements = null;
    @JsonProperty("name")
    private String name;
    @JsonProperty("isComplete")
    private Boolean isComplete;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2114423765966527105L;

    /**
     * No args constructor for use in serialization
     */
    public Path() {
    }

    /**
     * @param elements
     * @param name
     * @param isComplete
     */
    public Path(List<Element> elements, String name, Boolean isComplete) {
        super();
        this.elements = elements;
        this.name = name;
        this.isComplete = isComplete;
    }

    @JsonProperty("elements")
    public List<Element> getElements() {
        return elements;
    }

    @JsonProperty("elements")
    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("isComplete")
    public Boolean getIsComplete() {
        return isComplete;
    }

    @JsonProperty("isComplete")
    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
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
