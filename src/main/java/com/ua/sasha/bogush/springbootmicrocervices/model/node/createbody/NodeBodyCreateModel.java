
package com.ua.sasha.bogush.springbootmicrocervices.model.node.createbody;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
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
        "name",
        "nodeType",
        "aspectNames",
        "properties",
        "permissions",
        "relativePath",
        "association",
        "secondaryChildren",
        "targets"
})
public class NodeBodyCreateModel implements Serializable {

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
    @JsonProperty("relativePath")
    private String relativePath;
    @JsonProperty("association")
    @Valid
    private Association association;
    @JsonProperty("secondaryChildren")
    @Valid
    private List<Secondarychild> secondaryChildren = null;
    @JsonProperty("targets")
    @Valid
    private List<Target> targets = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 410188407506272499L;

    /**
     * No args constructor for use in serialization
     */
    public NodeBodyCreateModel() {
    }

    /**
     * @param aspectNames
     * @param permissions
     * @param relativePath
     * @param name
     * @param association
     * @param secondaryChildren
     * @param nodeType
     * @param targets
     * @param properties
     */
    public NodeBodyCreateModel(String name, String nodeType, List<String> aspectNames, Properties properties, Permissions permissions, String relativePath, Association association, List<Secondarychild> secondaryChildren, List<Target> targets) {
        super();
        this.name = name;
        this.nodeType = nodeType;
        this.aspectNames = aspectNames;
        this.properties = properties;
        this.permissions = permissions;
        this.relativePath = relativePath;
        this.association = association;
        this.secondaryChildren = secondaryChildren;
        this.targets = targets;
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

    @JsonProperty("relativePath")
    public String getRelativePath() {
        return relativePath;
    }

    @JsonProperty("relativePath")
    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    @JsonProperty("association")
    public Association getAssociation() {
        return association;
    }

    @JsonProperty("association")
    public void setAssociation(Association association) {
        this.association = association;
    }

    @JsonProperty("secondaryChildren")
    public List<Secondarychild> getSecondaryChildren() {
        return secondaryChildren;
    }

    @JsonProperty("secondaryChildren")
    public void setSecondaryChildren(List<Secondarychild> secondaryChildren) {
        this.secondaryChildren = secondaryChildren;
    }

    @JsonProperty("targets")
    public List<Target> getTargets() {
        return targets;
    }

    @JsonProperty("targets")
    public void setTargets(List<Target> targets) {
        this.targets = targets;
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
