package br.com.u2d.cadcli.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@NotBlank
	@NotNull
	private String cep;
	
	@NotBlank
	@NotNull
	private String logradouro;
	
	private String complemento;
	
	@NotBlank
	@NotNull
	private String bairro;
	
	@NotBlank
	@NotNull
	private String localidade;
	
	@NotBlank
	@NotNull
	private String uf;
	
	private String unidade;
	
	private String ibge;
	
	private String gia;
}
