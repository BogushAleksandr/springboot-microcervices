
package com.ua.sasha.bogush.springbootmicroservices.model.node.updatebody;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isInheritanceEnabled",
        "locallySet"
})
public class Permissions implements Serializable {

    @JsonProperty("isInheritanceEnabled")
    private Boolean isInheritanceEnabled;
    @JsonProperty("locallySet")
    @Valid
    private List<LocallySet> locallySet = null;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4415242619351367265L;

    /**
     * No args constructor for use in serialization
     */
    public Permissions() {
    }

    /**
     * @param isInheritanceEnabled
     * @param locallySet
     */
    public Permissions(Boolean isInheritanceEnabled, List<LocallySet> locallySet) {
        super();
        this.isInheritanceEnabled = isInheritanceEnabled;
        this.locallySet = locallySet;
    }

    @JsonProperty("isInheritanceEnabled")
    public Boolean getIsInheritanceEnabled() {
        return isInheritanceEnabled;
    }

    @JsonProperty("isInheritanceEnabled")
    public void setIsInheritanceEnabled(Boolean isInheritanceEnabled) {
        this.isInheritanceEnabled = isInheritanceEnabled;
    }

    @JsonProperty("locallySet")
    public List<LocallySet> getLocallySet() {
        return locallySet;
    }

    @JsonProperty("locallySet")
    public void setLocallySet(List<LocallySet> locallySet) {
        this.locallySet = locallySet;
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
