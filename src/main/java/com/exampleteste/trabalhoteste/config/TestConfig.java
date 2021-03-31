package com.exampleteste.trabalhoteste.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.exampleteste.trabalhoteste.entities.Produto;
import com.exampleteste.trabalhoteste.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);

		Produto prod1 = new Produto(null, "cadeira", 10.00, Instant.now());
		Produto prod2 = new Produto(null, "sofá", 1000.00, Instant.now());

		produtoRepository.saveAll(Arrays.asList(prod1, prod2));
	}
}
