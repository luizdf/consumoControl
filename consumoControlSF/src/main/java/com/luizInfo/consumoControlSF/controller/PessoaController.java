package com.luizInfo.consumoControlSF.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luizInfo.consumoControlSF.model.Pessoa;
import com.luizInfo.consumoControlSF.model.TipoPessoa;
import com.luizInfo.consumoControlSF.repository.Pessoas;
import com.luizInfo.consumoControlSF.repository.filter.PessoaFilter;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private Pessoas pessoas;

	@GetMapping("/novo")
	public ModelAndView novo(Pessoa pessoa){
		ModelAndView mv = new ModelAndView("pessoa/cad-pessoa");
		mv.addObject("tiposPessoa",TipoPessoa.values());
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()){
			return novo(pessoa);
		}
		
		pessoas.save(pessoa);
		attributes.addFlashAttribute("mensagemSucesso","Pessoa " + pessoa.getId().toString() +  " Salva com Sucesso!");
		return new ModelAndView("redirect:/pessoa/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(PessoaFilter pessoaFilter){
		ModelAndView mv = new ModelAndView("pessoa/pesquisa-pessoa");
		mv.addObject("pessoas", pessoas.findByNomeContainingIgnoreCase(
				Optional.ofNullable(pessoaFilter.getNome()).orElse("%")));
		return mv;
	}
}
