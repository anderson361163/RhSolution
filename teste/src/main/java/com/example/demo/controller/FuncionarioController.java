package com.example.demo.controller;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.dto.mapper.DepartamentoPessoalMapper;
import com.example.demo.model.Funcionario;
import com.example.demo.service.DepartamentoPessoalService;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private DepartamentoPessoalService departamentoPessoalService;

    @GetMapping("/cadastrar")
    public String formFuncionario(String departamento, Model model) {
        model.addAttribute("funcionario", new FuncionarioDTO());
        model.addAttribute("departamentos", DepartamentoPessoalMapper.toResponseDTO(departamentoPessoalService.listarDepartamentos()));
        return "funcionario/form.html";
    }

    @PostMapping("/cadastrar")
    public String salvaFuncionario(@Valid FuncionarioDTO funcionarioDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "funcionario/form";
        }

        funcionarioService.salvarFuncionario(funcionarioDTO);
        return "funcionario/sucessoFuncionario.html";
    }
    
    @GetMapping("/alterar/{id}")
    public String telaalterarFuncionario(@PathVariable Long id, Model model) {
    	System.out.println("qUAL O VALOR: "+ id);
    	Funcionario buscarFuncionarioById = funcionarioService.buscarFuncionarioById(id);
    	System.out.println(buscarFuncionarioById.toString());
    	model.addAttribute("funcionarios", funcionarioService.buscarFuncionarioById(id));
        model.addAttribute("departamentos", DepartamentoPessoalMapper.toResponseDTO(departamentoPessoalService.listarDepartamentos()));
        return "funcionario/formAlteracao.html";
    }
    
    @PostMapping("/alterar/{id}")
    public String alterarFuncionario(@PathVariable Long id, @Valid FuncionarioDTO funcionarioDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "funcionario/form";
        }

        funcionarioService.atualizarFuncionario(id, funcionarioDTO);
        return "funcionario/sucessoFuncionario.html";
    }
    
    

    @GetMapping("/deletar/{id}")
    public String excluirdepartamento(@PathVariable Long id, Model model) {
        funcionarioService.excluirFuncionarioById(id);
        return "funcionario/sucessoFuncionario.html";
    }

    @GetMapping("/listar")
    public String listaFuncionario(Model model) {
        model.addAttribute("funcionarios", funcionarioService.listarTodosFuncionarios());
        return "funcionario/lista.html";
    }

}
