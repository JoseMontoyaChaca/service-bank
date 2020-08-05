package com.bootcamp.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.entity.Bank;


@Repository
public interface  BankRepository  extends  ReactiveMongoRepository<Bank, String> {
	
	
 
}
