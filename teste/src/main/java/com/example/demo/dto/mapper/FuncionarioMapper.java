package com.example.demo.dto.mapper;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.model.Funcionario;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FuncionarioMapper {

    public static FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setNome(funcionario.getNome());
        funcionarioDTO.setCpf(funcionario.getCpf());
        funcionarioDTO.setDataNascimento(funcionario.getDataNascimento());
        funcionarioDTO.setDepartamentoPessoal((funcionario.getDepartamentoPessoal().getId()));
        funcionarioDTO.setSalario(funcionario.getSalario());
        return funcionarioDTO;
    }

    public static Funcionario toModel(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setDataNascimento(funcionarioDTO.getDataNascimento());
        funcionario.setSalario(funcionarioDTO.getSalario());
        return funcionario;
    }

}
