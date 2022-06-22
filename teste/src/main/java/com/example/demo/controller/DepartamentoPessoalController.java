package com.example.demo.controller;

import com.example.demo.dto.DepartamentoPessoalDTO;
import com.example.demo.dto.DepartamentoPessoalResponseDTO;
import com.example.demo.dto.mapper.DepartamentoPessoalMapper;
import com.example.demo.service.DepartamentoPessoalService;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/departamento-pessoal")
public class DepartamentoPessoalController {

    @Autowired
    private DepartamentoPessoalService departamentoPessoalService;

    @GetMapping("/cadastrar")
    public String formulariodepartamento() {
        return "departamento/form.html";
    }

    @PostMapping("/cadastrar")
    public String cadastrarDepartamento(@Valid DepartamentoPessoalDTO departamentoPessoalDTO) {
        departamentoPessoalService.salvarDepartamento(DepartamentoPessoalMapper.toModel(departamentoPessoalDTO));
        return "departamento/sucessoDepartamento.html";
    }

    @GetMapping("/listar")
    public String listaFuncionario(Model model) {
        model.addAttribute("departamentos", departamentoPessoalService.listarDepartamentos());
        return "departamento/lista.html";
    }

    @GetMapping("/alterar/{id}")
    public String editarDepartamento(@PathVariable Long id, Model model) {
        model.addAttribute("departamento", departamentoPessoalService.buscarDepartamentoById(id));
        return "departamento/formalteracao.html";
    }

    @PostMapping("/alterar/{id}")
    public String editarDepartamento(@PathVariable Long id, @Valid DepartamentoPessoalDTO departamentoPessoalDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "departamento/formalteracao.html";
        }

        departamentoPessoalService.atualizarDepartamento(id, departamentoPessoalDTO);
        return "departamento/sucessoDepartamento.html";
    }

    @GetMapping("/deletar/{id}")
    public String excluirDepartamento(@PathVariable Long id, Model model) {
        try {
            departamentoPessoalService.excluirDepartamentoById(id);
            return "departamento/sucessoDepartamento.html";
        } catch (Exception ex) {
            model.addAttribute("erro", ex.getMessage());
            return listaFuncionario(model);
        }
    }

    @ResponseBody
    @RequestMapping("/listaTodosDepartamentos")
    public List<DepartamentoPessoalResponseDTO> listaTodosDepartamentos() {
        return DepartamentoPessoalMapper.toResponseDTO(departamentoPessoalService.listarDepartamentos());
    }

}
