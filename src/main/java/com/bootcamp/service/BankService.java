package com.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bootcamp.entity.Bank;
import com.bootcamp.repository.BankRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankService {
	
	
	@Autowired
	BankRepository repository;
	public <T> Mono <T> monoResponseStatusNotFoundExeption(){
		return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"Bank not found"));
	}
	
	public Flux<Bank> findAll  ()			{
		return repository.findAll();
	}
	
	public Mono<Bank> findById (String idBank) 	{
		Flux<Bank> flux = repository.findAll().filter(p -> p.getIdBank().equals(idBank));
		return Mono.from(flux);
	}
	
	public Mono<Bank> save 	   (Bank bank)	{
		return repository.save(bank);
	}
	
	public Mono<Void> update   (Bank bank)	{
		return findById(bank.getIdBank())
				.flatMap(repository::save)
				.thenEmpty(Mono.empty());
	}
	
	public Mono<Void> delete	(String id){
		return findById(id)
				.flatMap(repository::delete);
	}
	
	
}
