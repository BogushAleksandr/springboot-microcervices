
package com.ua.sasha.bogush.springbootmicrocervices.model.modelnode;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "aspectNames",
        "createdAt",
        "isFolder",
        "isFile",
        "createdByUser",
        "modifiedAt",
        "permissions",
        "modifiedByUser",
        "name",
        "id",
        "nodeType",
        "parentId"
})
public class Entry implements Serializable {

    @JsonProperty("aspectNames")
    private List<String> aspectNames = null;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("isFolder")
    private Boolean isFolder;
    @JsonProperty("isFile")
    private Boolean isFile;
    @JsonProperty("createdByUser")
    private CreatedByUser createdByUser;
    @JsonProperty("modifiedAt")
    private String modifiedAt;
    @JsonProperty("permissions")
    private Permissions permissions;
    @JsonProperty("modifiedByUser")
    private ModifiedByUser modifiedByUser;
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("nodeType")
    private String nodeType;
    @JsonProperty("parentId")
    private String parentId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -9151082842505334869L;

    @JsonProperty("aspectNames")
    public List<String> getAspectNames() {
        return aspectNames;
    }

    @JsonProperty("aspectNames")
    public void setAspectNames(List<String> aspectNames) {
        this.aspectNames = aspectNames;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("isFolder")
    public Boolean getIsFolder() {
        return isFolder;
    }

    @JsonProperty("isFolder")
    public void setIsFolder(Boolean isFolder) {
        this.isFolder = isFolder;
    }

    @JsonProperty("isFile")
    public Boolean getIsFile() {
        return isFile;
    }

    @JsonProperty("isFile")
    public void setIsFile(Boolean isFile) {
        this.isFile = isFile;
    }

    @JsonProperty("createdByUser")
    public CreatedByUser getCreatedByUser() {
        return createdByUser;
    }

    @JsonProperty("createdByUser")
    public void setCreatedByUser(CreatedByUser createdByUser) {
        this.createdByUser = createdByUser;
    }

    @JsonProperty("modifiedAt")
    public String getModifiedAt() {
        return modifiedAt;
    }

    @JsonProperty("modifiedAt")
    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @JsonProperty("permissions")
    public Permissions getPermissions() {
        return permissions;
    }

    @JsonProperty("permissions")
    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
    }

    @JsonProperty("modifiedByUser")
    public ModifiedByUser getModifiedByUser() {
        return modifiedByUser;
    }

    @JsonProperty("modifiedByUser")
    public void setModifiedByUser(ModifiedByUser modifiedByUser) {
        this.modifiedByUser = modifiedByUser;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("nodeType")
    public String getNodeType() {
        return nodeType;
    }

    @JsonProperty("nodeType")
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    @JsonProperty("parentId")
    public String getParentId() {
        return parentId;
    }

    @JsonProperty("parentId")
    public void setParentId(String parentId) {
        this.parentId = parentId;
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
