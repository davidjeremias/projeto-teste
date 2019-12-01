package br.com.u2d.cadcli.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Builder
public class ClienteDTO implements Serializable{
	
	@Tolerate
	public ClienteDTO() {
		super();
	}
	
	private static final long serialVersionUID = -2896222119640987429L;
	
	private Integer id;
	private String nome;
	private EnderecoDTO endereco;
	private List<TelefoneDTO> telefones;
	private List<EmailDTO> emails;
}
