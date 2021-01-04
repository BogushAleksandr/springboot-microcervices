
package com.ua.sasha.bogush.springbootmicrocervices.model.error;

import com.fasterxml.jackson.annotation.*;

import javax.validation.Valid;
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
        "errorKey",
        "statusCode",
        "briefSummary",
        "stackTrace",
        "descriptionURL",
        "logId"
})
public class Error implements Serializable {

    @JsonProperty("errorKey")
    private String errorKey;
    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonProperty("briefSummary")
    private String briefSummary;
    @JsonProperty("stackTrace")
    private String stackTrace;
    @JsonProperty("descriptionURL")
    private String descriptionURL;
    @JsonProperty("logId")
    private String logId;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1482992156952210007L;

    /**
     * No args constructor for use in serialization
     */
    public Error() {
    }

    /**
     * @param errorKey
     * @param briefSummary
     * @param descriptionURL
     * @param logId
     * @param stackTrace
     * @param statusCode
     */
    public Error(String errorKey, Integer statusCode, String briefSummary, String stackTrace, String descriptionURL, String logId) {
        super();
        this.errorKey = errorKey;
        this.statusCode = statusCode;
        this.briefSummary = briefSummary;
        this.stackTrace = stackTrace;
        this.descriptionURL = descriptionURL;
        this.logId = logId;
    }

    @JsonProperty("errorKey")
    public String getErrorKey() {
        return errorKey;
    }

    @JsonProperty("errorKey")
    public void setErrorKey(String errorKey) {
        this.errorKey = errorKey;
    }

    @JsonProperty("statusCode")
    public Integer getStatusCode() {
        return statusCode;
    }

    @JsonProperty("statusCode")
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("briefSummary")
    public String getBriefSummary() {
        return briefSummary;
    }

    @JsonProperty("briefSummary")
    public void setBriefSummary(String briefSummary) {
        this.briefSummary = briefSummary;
    }

    @JsonProperty("stackTrace")
    public String getStackTrace() {
        return stackTrace;
    }

    @JsonProperty("stackTrace")
    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @JsonProperty("descriptionURL")
    public String getDescriptionURL() {
        return descriptionURL;
    }

    @JsonProperty("descriptionURL")
    public void setDescriptionURL(String descriptionURL) {
        this.descriptionURL = descriptionURL;
    }

    @JsonProperty("logId")
    public String getLogId() {
        return logId;
    }

    @JsonProperty("logId")
    public void setLogId(String logId) {
        this.logId = logId;
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
