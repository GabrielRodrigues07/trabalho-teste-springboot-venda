package com.exampleteste.trabalhoteste.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.exampleteste.trabalhoteste.entities.Venda;
import com.exampleteste.trabalhoteste.repositories.VendaRepository;
import com.exampleteste.trabalhoteste.services.exceptions.DatabaseException;
import com.exampleteste.trabalhoteste.services.exceptions.SaleNotFoundException;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;
	
	public List<Venda> findAll() {
		return repository.findAll();
	}
	
	public Venda findById(Long id) {
		Optional<Venda> obj = repository.findById(id);
		return obj.orElseThrow(() -> new SaleNotFoundException(id));
	}
	
	public Venda inserir(Venda venda) {
		venda.setData(Instant.now());
        return repository.save(venda);
    }
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new SaleNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Venda update(Long id, Venda item) {
		try {
			Venda entity = repository.getOne(id);
			updateData(entity, item);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new SaleNotFoundException(id);
		}
	}

	private void updateData(Venda entity, Venda obj) {
		entity.setIdCliente(obj.getIdCliente());
		entity.setNomeCliente(obj.getNomeCliente());
		entity.setCpfCliente(obj.getCpfCliente());
		entity.setData(Instant.now());
	}
}