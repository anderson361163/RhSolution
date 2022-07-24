package br.com.anderson.rhsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.anderson.rhsolution.model.DepartamentoPessoal;

@Repository
public interface DepartamentoPessoalRepository extends JpaRepository<DepartamentoPessoal, Long> {

}
