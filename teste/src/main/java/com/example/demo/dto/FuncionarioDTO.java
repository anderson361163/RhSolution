package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

    @NotEmpty(message = "Nome do funcionário deve ser preenchido")
    private String nome;

    @NotNull(message = "CPF do funcionário deve ser preenchido")
    private Long cpf;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Data de Nascimento do funcionário deve ser preenchido")
    private LocalDate dataNascimento;

    @NotNull
    @Positive
    private Long departamentoPessoal;

    @NotNull
    @Digits(integer = 5, fraction = 2, message = "Valor de salário valido é 99.999,10")
    private BigDecimal salario;

}
