package com.bootcamp.entity;

import java.io.Serializable;

import lombok.Data;
@Data
public class BankAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;	
	private String nameAccount;
	private Long  cardNumber;
	private Holder holder;
	private  Signatory signatory;
	private String dniCustomer;
	private double balance;
	
	
}
