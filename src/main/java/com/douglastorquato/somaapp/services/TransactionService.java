package com.douglastorquato.somaapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglastorquato.somaapp.entity.Transaction;
import com.douglastorquato.somaapp.repositories.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Transaction> findAll() {
		List<Transaction> transactions = transactionRepository.findAll();
		return transactions;
	}

}
