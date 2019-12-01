package br.com.u2d.cadcli.model.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Getter
@Setter
@Builder
public class EnderecoDTO implements Serializable{
	
	@Tolerate
	public EnderecoDTO() {
		super();
	}
	
	private static final long serialVersionUID = -351953667730215999L;

	private Integer id;
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	private String complemento;
}
