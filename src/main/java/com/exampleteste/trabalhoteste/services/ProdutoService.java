package com.exampleteste.trabalhoteste.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.exampleteste.trabalhoteste.entities.Produto;
import com.exampleteste.trabalhoteste.entities.dto.ProdutoDTO;
import com.exampleteste.trabalhoteste.repositories.ProdutoRepository;
import com.exampleteste.trabalhoteste.services.exceptions.DatabaseException;
import com.exampleteste.trabalhoteste.services.exceptions.ProductNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll() {
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	public Produto inserir(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(null, produtoDTO.getNome(), produtoDTO.getValor(), Instant.now());
        return repository.save(produto);
    }
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ProductNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
