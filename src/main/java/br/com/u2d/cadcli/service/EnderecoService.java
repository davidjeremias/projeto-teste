package br.com.u2d.cadcli.service;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.u2d.cadcli.model.dto.EnderecoDTO;

@Service
public class EnderecoService {

	private static final String URL = "https://viacep.com.br/ws/";
	private static final String FORMAT = "/json/";
	private static final String CEP = "cep";
	@Autowired
	RestTemplate rest;
	
	@Autowired
	ModelMapper model;

	public EnderecoDTO findEnderecoByCep(Map<String, String[]> filter) {
		String cep = filter.get(CEP) != null ? filter.get(CEP)[0] : null;
		return rest.getForObject(URL+cep+FORMAT, EnderecoDTO.class);
	}
	
	
}
