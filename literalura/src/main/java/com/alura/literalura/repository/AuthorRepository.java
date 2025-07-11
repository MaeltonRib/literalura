package com.alura.literalura.repository;

import com.alura.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(Integer born, Integer died);
    List<Author> findByBirthYearLessThanEqualAndDeathYearIsNull(Integer year);
}