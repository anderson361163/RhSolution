package com.example.demo.service;

import com.example.demo.dto.DepartamentoPessoalDTO;
import com.example.demo.model.DepartamentoPessoal;
import com.example.demo.model.Funcionario;
import com.example.demo.repository.DepartamentoPessoalRepository;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoPessoalService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DepartamentoPessoalRepository departamentoPessoalRepository;

    public List<DepartamentoPessoal> listarDepartamentos() {
        return departamentoPessoalRepository.findAll();
    }

    public void excluirDepartamentoById(Long id) {
        List<Funcionario> funcionarios = funcionarioRepository.findByDepartamentoPessoalId(id);

        if (!funcionarios.isEmpty()) {
            throw new RuntimeException("Por favor, exclua primeiro os funcionários do departamento.");
        }

        departamentoPessoalRepository.deleteById(id);
    }

    public DepartamentoPessoal buscarDepartamentoById(Long id) {
        return departamentoPessoalRepository.findById(id).get();
    }

    public DepartamentoPessoal salvarDepartamento(DepartamentoPessoal departamentoPessoal) {
        return departamentoPessoalRepository.save(departamentoPessoal);
    }

    public DepartamentoPessoal atualizarDepartamento(Long id, DepartamentoPessoalDTO dto) {
        DepartamentoPessoal departamentoPessoal = buscarDepartamentoById(id);
        departamentoPessoal.setNome(dto.getNome());
        return departamentoPessoalRepository.save(departamentoPessoal);
    }

}
