package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Endereco;
import com.example.demo.services.HomeService;

@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/cepEndereco")
	public String getEndereco(Model model, @RequestParam String cep, @ModelAttribute Endereco endereco) {
		try {
			endereco = homeService.buscaEnderecoPelo(cep);
			model.addAttribute("endereco", endereco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
}
