package com.example.ac1.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto salvar(Produto produto) {
        entityManager.merge(produto);
        return produto;
    }

    public List<Produto> obterTodos() {
        return entityManager
                .createQuery("from Produto", Produto.class).getResultList();
    }

    @Transactional
    public void excluir(Produto produto) {
        entityManager.remove(produto);
    }

    public List<Produto> obterPorNome(String nome) {
        String jpql = " select c from Produto c where c.nome like :nome";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

}
