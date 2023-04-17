package models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;

public class EnvironmentSpecification {
    boolean active;

    public boolean isActive() {
        return active;
    }

    Map<String, Object> envSpecificationProperties = new LinkedHashMap<>();

    @JsonAnySetter
    public void setEnvSpecificationProperties(String key, Object value) {
        envSpecificationProperties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getEnvSpecificationProperties() {
        return envSpecificationProperties;
    }
}
