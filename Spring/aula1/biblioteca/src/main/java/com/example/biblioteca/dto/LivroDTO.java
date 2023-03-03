package com.example.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor

public class LivroDTO {
    @Getter
    private String nome;
    @Getter
    private String editora;
    @Getter
    private String categoria;
}
