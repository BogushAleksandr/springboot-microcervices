
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
        "authorityId",
        "name",
        "accessStatus"
})
public class Inherited implements Serializable {

    @JsonProperty("authorityId")
    private String authorityId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("accessStatus")
    private String accessStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7796277832299335451L;

    @JsonProperty("authorityId")
    public String getAuthorityId() {
        return authorityId;
    }

    @JsonProperty("authorityId")
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("accessStatus")
    public String getAccessStatus() {
        return accessStatus;
    }

    @JsonProperty("accessStatus")
    public void setAccessStatus(String accessStatus) {
        this.accessStatus = accessStatus;
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
