package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Endereco;



@Service
public class HomeService {
	
	RestTemplate restTemplate = new RestTemplate();

	static String webService = "http://viacep.com.br/ws/";
	static int codigoSucesso = 200;

	public Endereco buscaEnderecoPelo(String cep) throws Exception {
		
		Endereco endereco;
		try {	
			endereco = restTemplate.getForObject(webService + cep + "/json", Endereco.class);
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
		return endereco;
	}
}
