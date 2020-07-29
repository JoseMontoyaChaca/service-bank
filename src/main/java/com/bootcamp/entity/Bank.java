package com.bootcamp.entity;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
//@ApiModel(value = "Bank entity", description = "Complete data of an entity Bank")
public class Bank implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@ApiModelProperty(value = "The id of the bank", required = false)
	@Id
	private String idBank;
	//@ApiModelProperty(value = "The bank name", required = true)
	private String nameBank;
	
	
	

}
