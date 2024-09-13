package com.example.ac1.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(nullable = true)
    private Integer qtd;

    @ManyToOne
    @JoinColumn(name = "categoriaProduto_id")
    @JsonManagedReference
    private CategoriaProduto categoriaProduto;

    public Produto(Integer id, String nome, Integer qtd, CategoriaProduto categoriaProduto) {
        this.id = id;
        this.nome = nome;
        this.qtd = qtd;
        this.categoriaProduto = categoriaProduto;
    }

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", quantidade=" + qtd + "]";
    }

    
    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
}
