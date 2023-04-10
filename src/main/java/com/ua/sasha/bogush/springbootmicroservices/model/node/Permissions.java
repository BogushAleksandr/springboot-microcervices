
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
        "isInheritanceEnabled",
        "inherited",
        "locallySet",
        "settable"
})
public class Permissions implements Serializable {

    @JsonProperty("isInheritanceEnabled")
    private Boolean isInheritanceEnabled;
    @JsonProperty("inherited")
    @Valid
    private List<Inherited> inherited = null;
    @JsonProperty("locallySet")
    @Valid
    private List<LocallySet> locallySet = null;
    @JsonProperty("settable")
    @Valid
    private List<String> settable = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3211575100583544036L;

    /**
     * No args constructor for use in serialization
     */
    public Permissions() {
    }

    /**
     * @param isInheritanceEnabled
     * @param settable
     * @param locallySet
     * @param inherited
     */
    public Permissions(Boolean isInheritanceEnabled, List<Inherited> inherited, List<LocallySet> locallySet, List<String> settable) {
        super();
        this.isInheritanceEnabled = isInheritanceEnabled;
        this.inherited = inherited;
        this.locallySet = locallySet;
        this.settable = settable;
    }

    @JsonProperty("isInheritanceEnabled")
    public Boolean getIsInheritanceEnabled() {
        return isInheritanceEnabled;
    }

    @JsonProperty("isInheritanceEnabled")
    public void setIsInheritanceEnabled(Boolean isInheritanceEnabled) {
        this.isInheritanceEnabled = isInheritanceEnabled;
    }

    @JsonProperty("inherited")
    public List<Inherited> getInherited() {
        return inherited;
    }

    @JsonProperty("inherited")
    public void setInherited(List<Inherited> inherited) {
        this.inherited = inherited;
    }

    @JsonProperty("locallySet")
    public List<LocallySet> getLocallySet() {
        return locallySet;
    }

    @JsonProperty("locallySet")
    public void setLocallySet(List<LocallySet> locallySet) {
        this.locallySet = locallySet;
    }

    @JsonProperty("settable")
    public List<String> getSettable() {
        return settable;
    }

    @JsonProperty("settable")
    public void setSettable(List<String> settable) {
        this.settable = settable;
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
