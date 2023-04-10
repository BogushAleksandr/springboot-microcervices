
package com.ua.sasha.bogush.springbootmicroservices.model.node.updatebody;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "nodeType",
        "aspectNames",
        "properties",
        "permissions"
})
public class NodeBodyUpdateModel implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("nodeType")
    private String nodeType;
    @JsonProperty("aspectNames")
    @Valid
    private List<String> aspectNames = null;
    @JsonProperty("properties")
    @Valid
    private Properties properties;
    @JsonProperty("permissions")
    @Valid
    private Permissions permissions;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7452162971948388688L;

    /**
     * No args constructor for use in serialization
     */
    public NodeBodyUpdateModel() {
    }

    /**
     * @param aspectNames
     * @param permissions
     * @param name
     * @param nodeType
     * @param properties
     */
    public NodeBodyUpdateModel(String name, String nodeType, List<String> aspectNames, Properties properties, Permissions permissions) {
        super();
        this.name = name;
        this.nodeType = nodeType;
        this.aspectNames = aspectNames;
        this.properties = properties;
        this.permissions = permissions;
    }

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

    @JsonProperty("aspectNames")
    public List<String> getAspectNames() {
        return aspectNames;
    }

    @JsonProperty("aspectNames")
    public void setAspectNames(List<String> aspectNames) {
        this.aspectNames = aspectNames;
    }

    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @JsonProperty("permissions")
    public Permissions getPermissions() {
        return permissions;
    }

    @JsonProperty("permissions")
    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
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
