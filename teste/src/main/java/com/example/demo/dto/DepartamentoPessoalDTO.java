package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class DepartamentoPessoalDTO {

    @NotEmpty(message = "Nome do departamento deve ser preenchido")
    private String nome;

}
