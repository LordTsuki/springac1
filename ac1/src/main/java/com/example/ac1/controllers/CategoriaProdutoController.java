package com.example.ac1.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.models.CategoriaProduto;
import com.example.ac1.repositories.CategoriaProdutoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/categoriaProduto")
public class CategoriaProdutoController {
    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    @GetMapping()
    public List<CategoriaProduto> getCategorias() {
        return categoriaProdutoRepository.obterTodos();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postCategorias(@RequestBody CategoriaProduto categoriaProduto) {
        categoriaProdutoRepository.salvar(categoriaProduto);
    }

}
