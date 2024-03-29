
package com.ua.sasha.bogush.springbootmicroservices.model.people;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Oleksandr Bogush
 * @version 1.0
 * @since 30.12.2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})
public class Properties implements Serializable {

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7439573567814234726L;

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
