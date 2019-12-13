package com.douglastorquato.somaapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.douglastorquato.somaapp.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	@Query(value = "select * from tb_cad_tra t where t.id_ent=:id_ent", nativeQuery = true)
    public List<Transaction> findByEnterprise(@Param("id_ent") Integer id_ent);

}
