package br.com.anderson.rhsolution.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.com.anderson.rhsolution.dto.DepartamentoPessoalDTO;
import br.com.anderson.rhsolution.dto.DepartamentoPessoalResponseDTO;
import br.com.anderson.rhsolution.model.DepartamentoPessoal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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
