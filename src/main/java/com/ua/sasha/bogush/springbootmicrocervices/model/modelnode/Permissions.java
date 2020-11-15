
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
        "inherited",
        "locallySet",
        "settable",
        "isInheritanceEnabled"
})
public class Permissions implements Serializable {

    @JsonProperty("inherited")
    private List<Inherited> inherited = null;
    @JsonProperty("locallySet")
    private List<LocallySet> locallySet = null;
    @JsonProperty("settable")
    private List<String> settable = null;
    @JsonProperty("isInheritanceEnabled")
    private Boolean isInheritanceEnabled;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 3022333362032590567L;

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

    @JsonProperty("isInheritanceEnabled")
    public Boolean getIsInheritanceEnabled() {
        return isInheritanceEnabled;
    }

    @JsonProperty("isInheritanceEnabled")
    public void setIsInheritanceEnabled(Boolean isInheritanceEnabled) {
        this.isInheritanceEnabled = isInheritanceEnabled;
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
