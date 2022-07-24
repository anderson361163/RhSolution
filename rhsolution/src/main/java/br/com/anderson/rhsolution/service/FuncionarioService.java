package br.com.anderson.rhsolution.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anderson.rhsolution.dto.FuncionarioDTO;
import br.com.anderson.rhsolution.dto.mapper.FuncionarioMapper;
import br.com.anderson.rhsolution.model.DepartamentoPessoal;
import br.com.anderson.rhsolution.model.Funcionario;
import br.com.anderson.rhsolution.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DepartamentoPessoalService departamentoPessoalService;

    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarFuncionarioById(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    public List<Funcionario> listaFuncionariosDoDepartamentoById(Long id) {
        return funcionarioRepository.findByDepartamentoPessoalId(id);
    }

    public Funcionario salvarFuncionario(FuncionarioDTO funcionarioDTO) {
        DepartamentoPessoal departamentoPessoal = departamentoPessoalService.buscarDepartamentoById(funcionarioDTO.getDepartamentoPessoal());

        Funcionario funcionario = FuncionarioMapper.toModel(funcionarioDTO);
        funcionario.setDepartamentoPessoal(departamentoPessoal);

        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = buscarFuncionarioById(id);
        DepartamentoPessoal departamentoPessoal = departamentoPessoalService.buscarDepartamentoById(funcionarioDTO.getDepartamentoPessoal());

        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setSalario(funcionarioDTO.getSalario());
        funcionario.setDataNascimento(funcionarioDTO.getDataNascimento());
        funcionario.setDepartamentoPessoal(departamentoPessoal);

        //BeanUtils.copyProperties(funcionarioDTO, funcionario, "id", "dataCadastro");

        return funcionarioRepository.save(funcionario);
    }

    public void excluirFuncionarioById(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
