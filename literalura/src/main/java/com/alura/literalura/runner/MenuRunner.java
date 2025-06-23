package com.alura.literalura.runner;

import com.alura.literalura.model.*;
import com.alura.literalura.service.GutendexService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class MenuRunner implements CommandLineRunner {
    private final GutendexService svc;
    private final Scanner sc = new Scanner(System.in);

    public MenuRunner(GutendexService svc) {
        this.svc = svc;
    }

    @Override
    public void run(String... args) {
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Buscar livro por título");
            System.out.println("2. Listar todos os livros");
            System.out.println("3. Listar livros por idioma");
            System.out.println("4. Listar autores");
            System.out.println("5. Autores vivos em ano");
            System.out.println("6. Estatística: livros por idioma");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            int opt = sc.nextInt(); sc.nextLine();
            switch (opt) {
                case 1:
                    System.out.print("Título: ");
                    svc.searchAndSave(sc.nextLine());
                    break;
                case 2:
                    svc.listAllBooks().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Idioma (ex: en): ");
                    svc.listByLanguage(sc.nextLine()).forEach(System.out::println);
                    break;
                case 4:
                    svc.listAllAuthors().forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Ano (ex: 1900): ");
                    svc.listAuthorsAliveIn(sc.nextInt()).forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("Idioma (ex: en): ");
                    String lang = sc.nextLine();
                    long count = svc.countBooksByLanguage(lang);
                    System.out.println("Total de livros em '" + lang + "': " + count);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
