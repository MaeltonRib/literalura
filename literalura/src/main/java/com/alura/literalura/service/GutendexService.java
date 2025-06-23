package com.alura.literalura.service;

import com.alura.literalura.client.GutendexClient;
import com.alura.literalura.dto.GutendexAuthorDTO;
import com.alura.literalura.dto.GutendexResponse;
import com.alura.literalura.dto.GutendexResult;
import com.alura.literalura.model.Author;
import com.alura.literalura.model.Book;
import com.alura.literalura.repository.AuthorRepository;
import com.alura.literalura.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GutendexService {
    private final GutendexClient client;
    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;

    public GutendexService(GutendexClient client, BookRepository bookRepo, AuthorRepository authorRepo) {
        this.client = client;
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    public void searchAndSave(String title) {
        try {
            GutendexResponse resp = client.searchByTitle(title);
            if (resp.getResults().isEmpty()) {
                System.out.println("Nenhum livro encontrado para: " + title);
                return;
            }

            GutendexResult r = resp.getResults().get(0);
            GutendexAuthorDTO adto = r.getAuthors().get(0);

            Author author = new Author();
            author.setName(adto.getName());
            author.setBirthYear(adto.getBirthYear());
            author.setDeathYear(adto.getDeathYear());

            Book book = new Book();
            book.setId(r.getId());
            book.setTitle(r.getTitle());
            book.setLanguage(r.getLanguages().get(0));
            book.setDownloadCount(r.getDownloadCount());
            book.setAuthor(author);

            bookRepo.save(book);
            System.out.println("Salvo: " + book);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public List<Book> listAllBooks() {
        return bookRepo.findAll();
    }

    public List<Book> listByLanguage(String lang) {
        return bookRepo.findByLanguage(lang);
    }

    public List<Author> listAllAuthors() {
        return authorRepo.findAll();
    }

    public List<Author> listAuthorsAliveIn(int year) {
        List<Author> result = new ArrayList<>();
        result.addAll(authorRepo.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(year, year));
        result.addAll(authorRepo.findByBirthYearLessThanEqualAndDeathYearIsNull(year));
        return result;
    }

    public long countBooksByLanguage(String lang) {
        return bookRepo.findByLanguage(lang).size();
    }
}
