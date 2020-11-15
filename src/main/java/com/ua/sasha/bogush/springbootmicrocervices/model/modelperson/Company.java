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
        "organization",
        "address1",
        "address2",
        "address3",
        "postcode",
        "telephone",
        "fax",
        "email"
})
public class Company implements Serializable {
    @JsonProperty("organization")
    private String organization;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("address3")
    private String address3;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("telephone")
    private String telephone;
    @JsonProperty("fax")
    private String fax;
    @JsonProperty("email")
    private String email;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -2504299873614219054L;

    @JsonProperty("organization")
    public String getOrganization() {
        return organization;
    }

    @JsonProperty("organization")
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @JsonProperty("address1")
    public String getAddress1() {
        return address1;
    }

    @JsonProperty("address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @JsonProperty("address2")
    public String getAddress2() {
        return address2;
    }

    @JsonProperty("address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @JsonProperty("address3")
    public String getAddress3() {
        return address3;
    }

    @JsonProperty("address3")
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    @JsonProperty("postcode")
    public String getPostcode() {
        return postcode;
    }

    @JsonProperty("postcode")
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @JsonProperty("telephone")
    public String getTelephone() {
        return telephone;
    }

    @JsonProperty("telephone")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @JsonProperty("fax")
    public String getFax() {
        return fax;
    }

    @JsonProperty("fax")
    public void setFax(String fax) {
        this.fax = fax;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
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
        return new ToStringBuilder(this).append("organization", organization).append("address1", address1).append("address2", address2).append("address3", address3).append("postcode", postcode).append("telephone", telephone).append("fax", fax).append("email", email).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(address3).append(address2).append(address1).append(organization).append(postcode).append(telephone).append(additionalProperties).append(fax).append(email).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Company)) {
            return false;
        }
        Company rhs = ((Company) other);
        return new EqualsBuilder().append(address3, rhs.address3).append(address2, rhs.address2).append(address1, rhs.address1).append(organization, rhs.organization).append(postcode, rhs.postcode).append(telephone, rhs.telephone).append(additionalProperties, rhs.additionalProperties).append(fax, rhs.fax).append(email, rhs.email).isEquals();
    }
}
