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
public class EmailDTO implements Serializable{
	
	@Tolerate
	public EmailDTO() {
		super();
	}
	
	private static final long serialVersionUID = 3349023036587500735L;

	private Integer id;
	
	@NotBlank
	@NotNull
	private String email;
}
