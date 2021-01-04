
package com.ua.sasha.bogush.springbootmicrocervices.model.node.copybody;

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
        "targetParentId",
        "name"
})
public class NodeCopyModel implements Serializable {

    @JsonProperty("targetParentId")
    private String targetParentId;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1696381421870355861L;

    /**
     * No args constructor for use in serialization
     */
    public NodeCopyModel() {
    }

    /**
     * @param targetParentId
     * @param name
     */
    public NodeCopyModel(String targetParentId, String name) {
        super();
        this.targetParentId = targetParentId;
        this.name = name;
    }

    @JsonProperty("targetParentId")
    public String getTargetParentId() {
        return targetParentId;
    }

    @JsonProperty("targetParentId")
    public void setTargetParentId(String targetParentId) {
        this.targetParentId = targetParentId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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
