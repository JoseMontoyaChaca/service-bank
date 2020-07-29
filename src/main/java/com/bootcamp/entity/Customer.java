package com.bootcamp.entity;


import java.io.Serializable;
import lombok.Data;

@Data
public class Customer implements Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String dniCustomer;
	
	private String firstName;
	
	private String lastName;
	
	private Integer key;
	
	private boolean status;
	
	private TypeCustomer typeCustomer;
	
}
