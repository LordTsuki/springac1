package com.example.ac1.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.ac1.models.Produto;
import com.example.ac1.repositories.ProdutoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping()
    public List<Produto> getProdutos() {
        return produtoRepository.obterTodos();
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable Integer id) {
        return (Produto) produtoRepository.obterPorId(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postProdutos(@RequestBody Produto produto) {
        produtoRepository.salvar(produto);
    }

}
