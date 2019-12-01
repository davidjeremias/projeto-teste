package br.com.u2d.cadcli.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.u2d.cadcli.model.Cliente;
import br.com.u2d.cadcli.model.dto.ClienteDTO;
import br.com.u2d.cadcli.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	ModelMapper model;

	public ClienteDTO salvar(ClienteDTO clienteDTO) {
		Cliente cliente = model.map(clienteDTO, Cliente.class);
		return model.map(repository.save(cliente), ClienteDTO.class);
	}

}
