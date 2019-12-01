package br.com.u2d.cadcli.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.u2d.cadcli.model.dto.ClienteDTO;
import br.com.u2d.cadcli.service.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	public ResponseEntity<ClienteDTO> salvar(@Valid @RequestBody ClienteDTO clienteDTO){
		ClienteDTO retorno = service.salvar(clienteDTO);
		return new ResponseEntity<>(retorno, HttpStatus.CREATED);
	}
}
