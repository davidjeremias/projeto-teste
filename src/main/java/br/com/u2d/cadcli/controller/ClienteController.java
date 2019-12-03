package br.com.u2d.cadcli.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping
	public ResponseEntity<ClienteDTO> salvar(@Valid @RequestBody ClienteDTO clienteDTO) throws Exception{
		ClienteDTO retorno = service.salvar(clienteDTO);
		return new ResponseEntity<>(retorno, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> buscar(){
		List<ClienteDTO> listaRetorno = service.buscar();
		return !listaRetorno.isEmpty() ? new ResponseEntity<List<ClienteDTO>>(listaRetorno, HttpStatus.OK)
				: new ResponseEntity<List<ClienteDTO>>(listaRetorno, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> buscaPorId(@PathVariable Integer id) throws Exception{
		ClienteDTO retorno = service.buscaPorId(id);
		return retorno != null ? new ResponseEntity<ClienteDTO>(retorno, HttpStatus.OK)
				: new ResponseEntity<ClienteDTO>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<ClienteDTO> alterar(@RequestBody ClienteDTO clienteDTO) throws Exception{
		ClienteDTO retorno = service.alterar(clienteDTO);
		return new ResponseEntity<ClienteDTO>(retorno, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteDTO> excluir(@PathVariable Integer id) throws Exception{
		service.excluir(id);
		return new ResponseEntity<ClienteDTO>(HttpStatus.OK);
	}
}
