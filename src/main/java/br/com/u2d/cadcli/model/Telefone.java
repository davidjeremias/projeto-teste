package br.com.u2d.cadcli.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Entity
@Table(name = "telefone")
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
public class Telefone {

	@Tolerate
	public Telefone() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String tipoTelefone;
	
	private String numero;
}
