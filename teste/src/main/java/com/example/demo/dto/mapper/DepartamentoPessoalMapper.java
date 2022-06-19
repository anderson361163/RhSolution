package com.example.demo.dto.mapper;

import com.example.demo.dto.DepartamentoPessoalDTO;
import com.example.demo.dto.DepartamentoPessoalResponseDTO;
import com.example.demo.model.DepartamentoPessoal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DepartamentoPessoalMapper {

    public static DepartamentoPessoal toModel(DepartamentoPessoalDTO departamentoPessoalDTO) {
        DepartamentoPessoal departamentoPessoal = new DepartamentoPessoal();
        departamentoPessoal.setNome(departamentoPessoalDTO.getNome());
        return departamentoPessoal;
    }

    public static DepartamentoPessoalResponseDTO toResponseDTO(DepartamentoPessoal departamentoPessoal) {
        DepartamentoPessoalResponseDTO dto = new DepartamentoPessoalResponseDTO();
        dto.setId(departamentoPessoal.getId());
        dto.setNome(departamentoPessoal.getNome());
        return dto;
    }

    public static List<DepartamentoPessoalResponseDTO> toResponseDTO(List<DepartamentoPessoal> departamentosPessoais) {
        return departamentosPessoais.stream()
                .map(DepartamentoPessoalMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

}
