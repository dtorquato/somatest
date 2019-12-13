package com.douglastorquato.somaapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.douglastorquato.somaapp.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query(value = "select * from tb_cad_emp e where e.id_ent=:id_ent", nativeQuery = true)
    public List<Employee> findByEnterprise(@Param("id_ent") Integer id_ent);
}
