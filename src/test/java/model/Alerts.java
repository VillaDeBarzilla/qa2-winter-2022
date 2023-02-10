package model;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Alerts {
    @JsonProperty("sender_name")
    private String senderName;
    private String event;
    private long start;
    private long end;
    private String description;
}
