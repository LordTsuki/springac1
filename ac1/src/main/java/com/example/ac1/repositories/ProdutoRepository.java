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
        return entityManager.merge(produto);
       
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

    public List<Produto> obterPorId(Integer id){
        String jpql = " select c from Produto c where c.id like :id";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("id", "%" + id + "%");
        return query.getResultList();

    }

}
