
package com.ua.sasha.bogush.springbootmicrocervices.model.group;

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
        "displayName",
        "parentIds"
})
public class GroupBodyCreateModel implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("parentIds")
    @Valid
    private List<String> parentIds = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -608583942395150248L;

    /**
     * No args constructor for use in serialization
     */
    public GroupBodyCreateModel() {
    }

    /**
     * @param displayName
     * @param parentIds
     * @param id
     */
    public GroupBodyCreateModel(String id, String displayName, List<String> parentIds) {
        super();
        this.id = id;
        this.displayName = displayName;
        this.parentIds = parentIds;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("parentIds")
    public List<String> getParentIds() {
        return parentIds;
    }

    @JsonProperty("parentIds")
    public void setParentIds(List<String> parentIds) {
        this.parentIds = parentIds;
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
