package com.example.biblioteca.controller;

import com.example.biblioteca.dto.LivroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    private static Collection<LivroDTO> dbLivro = Collections.synchronizedCollection(
            List.of(
                    new LivroDTO("Domine o Java", "Atlas", "Tecnologia"),
                    new LivroDTO("Clean Code", "Person", "Tecnologia"),
                    new LivroDTO("Design Pattern", "Person", "Tecnologia")
            )
    );
    @GetMapping("/livro")
    public ResponseEntity<List<LivroDTO>> consultaLivro(){
        List<LivroDTO> livros = List.of(
                new LivroDTO("Domine o Java", "Atlas", "Tecnologia"),
                new LivroDTO("Clean Code", "Person", "Tecnologia"),
                new LivroDTO("Design Pattern", "Person", "Tecnologia")
        );
        return ResponseEntity.of(Optional.of(livros));
        //return ResponseEntity.ok().build();
    }
}
