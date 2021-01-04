
package com.ua.sasha.bogush.springbootmicrocervices.model.node;

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
        "mimeType",
        "mimeTypeName",
        "sizeInBytes",
        "encoding"
})
public class Content implements Serializable {

    @JsonProperty("mimeType")
    private String mimeType;
    @JsonProperty("mimeTypeName")
    private String mimeTypeName;
    @JsonProperty("sizeInBytes")
    private Integer sizeInBytes;
    @JsonProperty("encoding")
    private String encoding;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5652780394556621538L;

    /**
     * No args constructor for use in serialization
     */
    public Content() {
    }

    /**
     * @param sizeInBytes
     * @param mimeTypeName
     * @param mimeType
     * @param encoding
     */
    public Content(String mimeType, String mimeTypeName, Integer sizeInBytes, String encoding) {
        super();
        this.mimeType = mimeType;
        this.mimeTypeName = mimeTypeName;
        this.sizeInBytes = sizeInBytes;
        this.encoding = encoding;
    }

    @JsonProperty("mimeType")
    public String getMimeType() {
        return mimeType;
    }

    @JsonProperty("mimeType")
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @JsonProperty("mimeTypeName")
    public String getMimeTypeName() {
        return mimeTypeName;
    }

    @JsonProperty("mimeTypeName")
    public void setMimeTypeName(String mimeTypeName) {
        this.mimeTypeName = mimeTypeName;
    }

    @JsonProperty("sizeInBytes")
    public Integer getSizeInBytes() {
        return sizeInBytes;
    }

    @JsonProperty("sizeInBytes")
    public void setSizeInBytes(Integer sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    @JsonProperty("encoding")
    public String getEncoding() {
        return encoding;
    }

    @JsonProperty("encoding")
    public void setEncoding(String encoding) {
        this.encoding = encoding;
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
