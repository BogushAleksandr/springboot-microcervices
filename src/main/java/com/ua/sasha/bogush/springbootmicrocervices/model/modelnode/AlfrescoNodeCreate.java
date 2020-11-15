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
        "name",
        "nodeType",
        "relativePath"
})
public class AlfrescoNodeCreate implements Serializable {
    @JsonProperty("name")
    private String name;
    @JsonProperty("nodeType")
    private String nodeType;
    @JsonProperty("relativePath")
    private String relativePath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6443231882648988865L;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nodeType")
    public String getNodeType() {
        return nodeType;
    }

    @JsonProperty("nodeType")
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    @JsonProperty("relativePath")
    public String getRelativePath() {
        return relativePath;
    }

    @JsonProperty("relativePath")
    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
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
