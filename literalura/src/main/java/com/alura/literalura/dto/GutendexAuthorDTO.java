package com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexAuthorDTO {

    @JsonAlias("name")
    private String name;

    @JsonAlias("birth_year")
    private Integer birthYear;

    @JsonAlias("death_year")
    private Integer deathYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + name + '\'' +
                ", nascimento=" + birthYear +
                ", falecimento=" + deathYear +
                '}';
    }
}
