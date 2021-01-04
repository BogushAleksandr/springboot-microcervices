
package com.ua.sasha.bogush.springbootmicrocervices.model.node;

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
        "id",
        "name",
        "nodeType",
        "isFolder",
        "isFile",
        "isLocked",
        "modifiedAt",
        "modifiedByUser",
        "createdAt",
        "createdByUser",
        "parentId",
        "isLink",
        "isFavorite",
        "content",
        "aspectNames",
        "properties",
        "allowableOperations",
        "path",
        "permissions"
})
public class Entry implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nodeType")
    private String nodeType;
    @JsonProperty("isFolder")
    private Boolean isFolder;
    @JsonProperty("isFile")
    private Boolean isFile;
    @JsonProperty("isLocked")
    private Boolean isLocked;
    @JsonProperty("modifiedAt")
    private String modifiedAt;
    @JsonProperty("modifiedByUser")
    @Valid
    private ModifiedByUser modifiedByUser;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("createdByUser")
    @Valid
    private CreatedByUser createdByUser;
    @JsonProperty("parentId")
    private String parentId;
    @JsonProperty("isLink")
    private Boolean isLink;
    @JsonProperty("isFavorite")
    private Boolean isFavorite;
    @JsonProperty("content")
    @Valid
    private Content content;
    @JsonProperty("aspectNames")
    @Valid
    private List<String> aspectNames = null;
    @JsonProperty("properties")
    @Valid
    private Properties properties;
    @JsonProperty("allowableOperations")
    @Valid
    private List<String> allowableOperations = null;
    @JsonProperty("path")
    @Valid
    private Path path;
    @JsonProperty("permissions")
    @Valid
    private Permissions permissions;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7248521301002426133L;

    /**
     * No args constructor for use in serialization
     */
    public Entry() {
    }

    /**
     * @param isLink
     * @param isFile
     * @param createdByUser
     * @param modifiedAt
     * @param nodeType
     * @param parentId
     * @param content
     * @param aspectNames
     * @param createdAt
     * @param path
     * @param isFolder
     * @param permissions
     * @param isLocked
     * @param modifiedByUser
     * @param name
     * @param id
     * @param properties
     * @param allowableOperations
     * @param isFavorite
     */
    public Entry(String id, String name, String nodeType, Boolean isFolder, Boolean isFile, Boolean isLocked, String modifiedAt, ModifiedByUser modifiedByUser, String createdAt, CreatedByUser createdByUser, String parentId, Boolean isLink, Boolean isFavorite, Content content, List<String> aspectNames, Properties properties, List<String> allowableOperations, Path path, Permissions permissions) {
        super();
        this.id = id;
        this.name = name;
        this.nodeType = nodeType;
        this.isFolder = isFolder;
        this.isFile = isFile;
        this.isLocked = isLocked;
        this.modifiedAt = modifiedAt;
        this.modifiedByUser = modifiedByUser;
        this.createdAt = createdAt;
        this.createdByUser = createdByUser;
        this.parentId = parentId;
        this.isLink = isLink;
        this.isFavorite = isFavorite;
        this.content = content;
        this.aspectNames = aspectNames;
        this.properties = properties;
        this.allowableOperations = allowableOperations;
        this.path = path;
        this.permissions = permissions;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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

    @JsonProperty("isLocked")
    public Boolean getIsLocked() {
        return isLocked;
    }

    @JsonProperty("isLocked")
    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    @JsonProperty("modifiedAt")
    public String getModifiedAt() {
        return modifiedAt;
    }

    @JsonProperty("modifiedAt")
    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @JsonProperty("modifiedByUser")
    public ModifiedByUser getModifiedByUser() {
        return modifiedByUser;
    }

    @JsonProperty("modifiedByUser")
    public void setModifiedByUser(ModifiedByUser modifiedByUser) {
        this.modifiedByUser = modifiedByUser;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("createdByUser")
    public CreatedByUser getCreatedByUser() {
        return createdByUser;
    }

    @JsonProperty("createdByUser")
    public void setCreatedByUser(CreatedByUser createdByUser) {
        this.createdByUser = createdByUser;
    }

    @JsonProperty("parentId")
    public String getParentId() {
        return parentId;
    }

    @JsonProperty("parentId")
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @JsonProperty("isLink")
    public Boolean getIsLink() {
        return isLink;
    }

    @JsonProperty("isLink")
    public void setIsLink(Boolean isLink) {
        this.isLink = isLink;
    }

    @JsonProperty("isFavorite")
    public Boolean getIsFavorite() {
        return isFavorite;
    }

    @JsonProperty("isFavorite")
    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    @JsonProperty("content")
    public Content getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(Content content) {
        this.content = content;
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

    @JsonProperty("allowableOperations")
    public List<String> getAllowableOperations() {
        return allowableOperations;
    }

    @JsonProperty("allowableOperations")
    public void setAllowableOperations(List<String> allowableOperations) {
        this.allowableOperations = allowableOperations;
    }

    @JsonProperty("path")
    public Path getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(Path path) {
        this.path = path;
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
