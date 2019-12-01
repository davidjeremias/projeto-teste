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
public class TelefoneDTO implements Serializable{
	
	@Tolerate
	public TelefoneDTO() {
		super();
	}
	
	private static final long serialVersionUID = -4375021103076072000L;

	private Integer id;
	
	@NotBlank
	@NotNull
	private String tipoTelefone;
	
	@NotBlank
	@NotNull
	private String numero;
}
