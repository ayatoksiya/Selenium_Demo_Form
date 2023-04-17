package models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Environment {
    Map<String, EnvironmentSpecification> envProperties = new LinkedHashMap<>();

    @JsonAnySetter
    public void setEnvProperties(String key, EnvironmentSpecification environmentSpecification) {
        envProperties.put(key, environmentSpecification);
    }

    @JsonAnyGetter
    public List<EnvironmentSpecification> getEnvProperties() {
        return envProperties.values().stream().toList();
    }
}

