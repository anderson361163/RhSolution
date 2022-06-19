package com.example.demo.repository;

import com.example.demo.model.DepartamentoPessoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoPessoalRepository extends JpaRepository<DepartamentoPessoal, Long> {

}
