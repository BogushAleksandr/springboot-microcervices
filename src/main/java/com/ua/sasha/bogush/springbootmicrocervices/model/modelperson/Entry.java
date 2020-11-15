package com.ua.sasha.bogush.springbootmicrocervices.model.modelperson;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*response body person after post person*/

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "displayName",
        "description",
        "avatarId",
        "email",
        "skypeId",
        "googleId",
        "instantMessageId",
        "jobTitle",
        "location",
        "company",
        "mobile",
        "telephone",
        "statusUpdatedAt",
        "userStatus",
        "enabled",
        "emailNotificationsEnabled",
        "aspectNames",
        "properties",
        "capabilities"
})
public class Entry implements Serializable {
    @JsonProperty("id")
    private String id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("avatarId")
    private String avatarId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("skypeId")
    private String skypeId;
    @JsonProperty("googleId")
    private String googleId;
    @JsonProperty("instantMessageId")
    private String instantMessageId;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("location")
    private String location;
    @JsonProperty("company")
    private Company company;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("telephone")
    private String telephone;
    @JsonProperty("statusUpdatedAt")
    private String statusUpdatedAt;
    @JsonProperty("userStatus")
    private String userStatus;
    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("emailNotificationsEnabled")
    private Boolean emailNotificationsEnabled;
    @JsonProperty("aspectNames")
    private List<String> aspectNames = null;
    @JsonProperty("properties")
    private Properties properties;
    @JsonProperty("capabilities")
    private Capabilities capabilities;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private final static long serialVersionUID = -787759202443294699L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("avatarId")
    public String getAvatarId() {
        return avatarId;
    }

    @JsonProperty("avatarId")
    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("skypeId")
    public String getSkypeId() {
        return skypeId;
    }

    @JsonProperty("skypeId")
    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }

    @JsonProperty("googleId")
    public String getGoogleId() {
        return googleId;
    }

    @JsonProperty("googleId")
    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    @JsonProperty("instantMessageId")
    public String getInstantMessageId() {
        return instantMessageId;
    }

    @JsonProperty("instantMessageId")
    public void setInstantMessageId(String instantMessageId) {
        this.instantMessageId = instantMessageId;
    }

    @JsonProperty("jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonProperty("mobile")
    public String getMobile() {
        return mobile;
    }

    @JsonProperty("mobile")
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @JsonProperty("telephone")
    public String getTelephone() {
        return telephone;
    }

    @JsonProperty("telephone")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @JsonProperty("statusUpdatedAt")
    public String getStatusUpdatedAt() {
        return statusUpdatedAt;
    }

    @JsonProperty("statusUpdatedAt")
    public void setStatusUpdatedAt(String statusUpdatedAt) {
        this.statusUpdatedAt = statusUpdatedAt;
    }

    @JsonProperty("userStatus")
    public String getUserStatus() {
        return userStatus;
    }

    @JsonProperty("userStatus")
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @JsonProperty("emailNotificationsEnabled")
    public Boolean getEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }

    @JsonProperty("emailNotificationsEnabled")
    public void setEmailNotificationsEnabled(Boolean emailNotificationsEnabled) {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
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

    @JsonProperty("capabilities")
    public Capabilities getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
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
        return new ToStringBuilder(this).append("id", id).append("firstName", firstName).append("lastName", lastName).append("displayName", displayName).append("description", description).append("avatarId", avatarId).append("email", email).append("skypeId", skypeId).append("googleId", googleId).append("instantMessageId", instantMessageId).append("jobTitle", jobTitle).append("location", location).append("company", company).append("mobile", mobile).append("telephone", telephone).append("statusUpdatedAt", statusUpdatedAt).append("userStatus", userStatus).append("enabled", enabled).append("emailNotificationsEnabled", emailNotificationsEnabled).append("aspectNames", aspectNames).append("properties", properties).append("capabilities", capabilities).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(googleId).append(lastName).append(userStatus).append(capabilities).append(displayName).append(jobTitle).append(statusUpdatedAt).append(mobile).append(emailNotificationsEnabled).append(description).append(telephone).append(enabled).append(aspectNames).append(firstName).append(skypeId).append(avatarId).append(instantMessageId).append(location).append(company).append(id).append(additionalProperties).append(email).append(properties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Entry)) {
            return false;
        }
        Entry rhs = ((Entry) other);
        return new EqualsBuilder().append(googleId, rhs.googleId).append(lastName, rhs.lastName).append(userStatus, rhs.userStatus).append(capabilities, rhs.capabilities).append(displayName, rhs.displayName).append(jobTitle, rhs.jobTitle).append(statusUpdatedAt, rhs.statusUpdatedAt).append(mobile, rhs.mobile).append(emailNotificationsEnabled, rhs.emailNotificationsEnabled).append(description, rhs.description).append(telephone, rhs.telephone).append(enabled, rhs.enabled).append(aspectNames, rhs.aspectNames).append(firstName, rhs.firstName).append(skypeId, rhs.skypeId).append(avatarId, rhs.avatarId).append(instantMessageId, rhs.instantMessageId).append(location, rhs.location).append(company, rhs.company).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(email, rhs.email).append(properties, rhs.properties).isEquals();
    }

}
