package br.com.u2d.cadcli.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

	public ClienteDTO salvar(ClienteDTO clienteDTO) throws Exception {
		Cliente cliente = model.map(clienteDTO, Cliente.class);
		return model.map(repository.save(cliente), ClienteDTO.class);
	}

	public List<ClienteDTO> buscar() {
		List<Cliente> listaRetorno = repository.findAll();
		List<ClienteDTO> listaDTO = new ArrayList<>();
		listaRetorno.forEach(cliente -> {
			ClienteDTO dto = model.map(cliente, ClienteDTO.class);
			listaDTO.add(dto);
		});
		return listaDTO;
	}

	public ClienteDTO buscaPorId(Integer id) throws Exception {
		Optional<Cliente> retorno = repository.findById(id);
		if(!retorno.isPresent()) 
			throw new Exception("Cliente não encontrado");
		return model.map(retorno.get(), ClienteDTO.class);
	}

	public ClienteDTO alterar(ClienteDTO clienteDTO) throws Exception {
		Cliente cliente = model.map(clienteDTO, Cliente.class);
		if(!repository.existsById(cliente.getId()))
			throw new Exception("Cliente não encontrado");
		return model.map(repository.save(cliente), ClienteDTO.class);
	}

	public void excluir(Integer id) throws Exception {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception("Cliente não encontrado");
		}
	}

}
