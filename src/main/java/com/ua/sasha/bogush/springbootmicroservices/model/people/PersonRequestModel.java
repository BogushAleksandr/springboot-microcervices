package com.ua.sasha.bogush.springbootmicroservices.model.people;

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
        "id",
        "firstName",
        "lastName",
        "description",
        "email",
        "skypeId",
        "googleId",
        "instantMessageId",
        "jobTitle",
        "location",
        "company",
        "mobile",
        "telephone",
        "userStatus",
        "enabled",
        "emailNotificationsEnabled",
        "password",
        "aspectNames",
        "properties"
})
public class PersonRequestModel implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("description")
    private String description;
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
    @Valid
    private Company company;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("telephone")
    private String telephone;
    @JsonProperty("userStatus")
    private String userStatus;
    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("emailNotificationsEnabled")
    private Boolean emailNotificationsEnabled;
    @JsonProperty("password")
    private String password;
    @JsonProperty("aspectNames")
    @Valid
    private List<String> aspectNames = null;
    @JsonProperty("properties")
    @Valid
    private Properties properties;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7260751713847255466L;

    /**
     * No args constructor for use in serialization
     */
    public PersonRequestModel() {
    }

    /**
     * @param googleId
     * @param lastName
     * @param userStatus
     * @param jobTitle
     * @param mobile
     * @param emailNotificationsEnabled
     * @param description
     * @param telephone
     * @param enabled
     * @param aspectNames
     * @param firstName
     * @param skypeId
     * @param password
     * @param instantMessageId
     * @param location
     * @param company
     * @param id
     * @param email
     * @param properties
     */
    public PersonRequestModel(String id, String firstName, String lastName, String description, String email, String skypeId, String googleId, String instantMessageId, String jobTitle, String location, Company company, String mobile, String telephone, String userStatus, Boolean enabled, Boolean emailNotificationsEnabled, String password, List<String> aspectNames, Properties properties) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.email = email;
        this.skypeId = skypeId;
        this.googleId = googleId;
        this.instantMessageId = instantMessageId;
        this.jobTitle = jobTitle;
        this.location = location;
        this.company = company;
        this.mobile = mobile;
        this.telephone = telephone;
        this.userStatus = userStatus;
        this.enabled = enabled;
        this.emailNotificationsEnabled = emailNotificationsEnabled;
        this.password = password;
        this.aspectNames = aspectNames;
        this.properties = properties;
    }

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

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}