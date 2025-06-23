package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    private Long id;
    private String title;
    private String language;
    private Integer downloadCount;

    @ManyToOne(cascade = CascadeType.ALL)
    private Author author;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", título='" + title + '\'' +
                ", idioma='" + language + '\'' +
                ", downloads=" + downloadCount +
                ", autor=" + author.getName() +
                '}';
    }
}
