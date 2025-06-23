package com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexResult {

    @JsonAlias("id")
    private Long id;

    @JsonAlias("title")
    private String title;

    @JsonAlias("authors")
    private List<GutendexAuthorDTO> authors;

    @JsonAlias("languages")
    private List<String> languages;

    @JsonAlias("download_count")
    private Integer downloadCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<GutendexAuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<GutendexAuthorDTO> authors) {
        this.authors = authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "LivroDTO{" +
                "id=" + id +
                ", título='" + title + '\'' +
                ", autores=" + authors +
                ", idiomas=" + languages +
                ", downloads=" + downloadCount +
                '}';
    }
}
