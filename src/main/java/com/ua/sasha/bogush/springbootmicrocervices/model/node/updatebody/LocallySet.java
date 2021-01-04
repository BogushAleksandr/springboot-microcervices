
package com.ua.sasha.bogush.springbootmicrocervices.model.node.updatebody;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorityId",
    "name",
    "accessStatus"
})
public class LocallySet implements Serializable
{

    @JsonProperty("authorityId")
    private String authorityId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("accessStatus")
    private String accessStatus;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -806541912360165595L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LocallySet() {
    }

    /**
     * 
     * @param authorityId
     * @param name
     * @param accessStatus
     */
    public LocallySet(String authorityId, String name, String accessStatus) {
        super();
        this.authorityId = authorityId;
        this.name = name;
        this.accessStatus = accessStatus;
    }

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
