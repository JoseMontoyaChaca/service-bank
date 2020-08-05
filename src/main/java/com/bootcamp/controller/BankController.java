package com.bootcamp.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import com.bootcamp.entity.Bank;
import com.bootcamp.entity.BankAccount;
import com.bootcamp.entity.Customer;
import com.bootcamp.service.BankService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	BankService bankService;
	
	private WebClient customer = WebClient.create("htpp://localhost:8070/customer");

	private WebClient bankAccount = WebClient.create("htpp://localhost:8072/bankAccount");
	
	@GetMapping("/accountCustomer")
	public Flux<Object> getClient() {
		
		
		Flux<Customer> customerList = customer.get().uri("/allCustomer").accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(Customer.class);
		
		Flux<BankAccount> bankList = bankAccount.get().uri("/getAllBankAccount").accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToFlux(BankAccount.class);
		
		Flux<Object> concat = Flux.concat(customerList,bankList);		
		return concat;				
	}
	
	
	
	
	//CRUD 

	@GetMapping("/findAllBank")
	public Flux<Bank> findAll()		{return bankService.findAll();}
	
	@GetMapping(value = "/findBank/{idBank}")
	public Mono<Bank> findById 	(@PathVariable(name = "idBank") String idBank)	{
		return bankService.findById(idBank);
	}
	
	@PostMapping("/addBank")
	public Mono<Bank> save		(@Valid @RequestBody Bank bank)	{
		return bankService.save(bank);
	}
	
	@PutMapping("/updateBank")
	public Mono<Void> update	(@Valid @RequestBody Bank bank){
		return bankService.update(bank);
	}
	
	@DeleteMapping( "{id}")
	public Mono<Void> delete	(@PathVariable String id){
		return bankService.delete(id);
	}


}
