package br.com.anderson.rhsolution.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private Long cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column
    private BigDecimal salario;

    @ManyToOne
    @JoinColumn(name = "fk_departamento_pessoal")
    private DepartamentoPessoal departamentoPessoal;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    private void preCadastro() {
        this.dataCadastro = LocalDateTime.now();
    }

    @PreUpdate
    private void preAtualizacao() {
        this.dataAtualizacao = LocalDateTime.now();
    }

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ ", salario=" + salario + ", departamentoPessoal=" + departamentoPessoal.getNome() + ", dataCadastro="
				+ dataCadastro + ", dataAtualizacao=" + dataAtualizacao + "]";
	}

    
}
