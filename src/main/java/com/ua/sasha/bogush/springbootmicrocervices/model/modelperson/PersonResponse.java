package com.ua.sasha.bogush.springbootmicrocervices.model.modelperson;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
        "entry"
})
public class PersonResponse implements Serializable {

    @JsonProperty("entry")
    private Entry entry;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = 3771538637543604919L;

    @JsonProperty("entry")
    public Entry getEntry() {
        return entry;
    }

    @JsonProperty("entry")
    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("entry", entry).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(entry).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof PersonResponse)) {
            return false;
        }
        PersonResponse rhs = ((PersonResponse) other);
        return new EqualsBuilder().append(entry, rhs.entry).append(additionalProperties, rhs.additionalProperties).isEquals();
    }
}
