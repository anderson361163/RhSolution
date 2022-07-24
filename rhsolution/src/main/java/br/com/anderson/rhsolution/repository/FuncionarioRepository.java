package br.com.anderson.rhsolution.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.anderson.rhsolution.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByDepartamentoPessoalId(Long id);

}
