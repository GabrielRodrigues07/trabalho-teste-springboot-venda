package com.exampleteste.trabalhoteste.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
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
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);

		Produto prod = new Produto(null, "cadeira", 10.0, Instant.now());

		produtoRepository.save(prod);
	}

}
