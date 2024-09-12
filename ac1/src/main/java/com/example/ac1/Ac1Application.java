package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.CategoriaProduto;
import com.example.ac1.models.Produto;
import com.example.ac1.repositories.CategoriaProdutoRepository;
import com.example.ac1.repositories.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(
			@Autowired ProdutoRepository produtoRepository,
			@Autowired CategoriaProdutoRepository categoriaProdutoRepository) {
		return args -> {
			System.out.println("*** CRIANDO AS CATEGORIAS ***");
			CategoriaProduto c1 = categoriaProdutoRepository.salvar(
					new CategoriaProduto(0, "Cat1", "desc1"));
			CategoriaProduto c2 = categoriaProdutoRepository.salvar(
					new CategoriaProduto(1, "Cat2", "desc2"));
			List<CategoriaProduto> listaCategorias = categoriaProdutoRepository.obterTodos();
			listaCategorias.forEach(System.out::println);

			System.out.println("*** CRIANDO OS PRODUTOS ***");
			produtoRepository.salvar(
					new Produto(0, "Pro1", 2000, c1));
			produtoRepository.salvar(
					new Produto(1, "Pro2", 2050, c2));
			List<Produto> listaProdutos = produtoRepository.obterTodos();
			listaProdutos.forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
