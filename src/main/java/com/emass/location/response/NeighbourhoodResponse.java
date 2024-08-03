package com.emass.location.response;

import com.emass.location.components.Neighbourhood;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NeighbourhoodResponse {
    private String status;
    private List<Neighbourhood> data;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("data")
    public List<Neighbourhood> getData() {
        return data;
    }

    public void setData(List<Neighbourhood> data) {
        this.data = data;
    }
}
