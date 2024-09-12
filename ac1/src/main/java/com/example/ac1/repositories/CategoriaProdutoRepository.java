package com.example.ac1.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.CategoriaProduto;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public CategoriaProduto salvar(CategoriaProduto categoriaProduto) {
        categoriaProduto = entityManager.merge(categoriaProduto);
        return categoriaProduto;
    }

    public List<CategoriaProduto> obterTodos() {
        return entityManager
                .createQuery("SELECT c FROM CategoriaProduto c",
                        CategoriaProduto.class)
                .getResultList();
    }
}
