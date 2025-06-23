package com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexResponse {

    private List<GutendexResult> results;

    public List<GutendexResult> getResults() {
        return results;
    }

    public void setResults(List<GutendexResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GutendexResponse{" +
                "results=" + results +
                '}';
    }
}
