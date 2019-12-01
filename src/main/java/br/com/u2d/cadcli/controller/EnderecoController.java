package br.com.u2d.cadcli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import br.com.u2d.cadcli.model.dto.EnderecoDTO;
import br.com.u2d.cadcli.service.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public ResponseEntity<EnderecoDTO> findEnderecoByCep(WebRequest request){
		EnderecoDTO retorno = service.findEnderecoByCep(request.getParameterMap());
		return retorno != null ? new ResponseEntity<EnderecoDTO>(retorno, HttpStatus.OK)
				: new ResponseEntity<EnderecoDTO>(HttpStatus.NO_CONTENT);
	}
}
