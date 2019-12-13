package com.douglastorquato.somaapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.douglastorquato.somaapp.entity.Transaction;
import com.douglastorquato.somaapp.services.TransactionService;

@Validated
@RestController
@RequestMapping(value="/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Transaction> listAll() {
		return transactionService.findAll();
	}

}
