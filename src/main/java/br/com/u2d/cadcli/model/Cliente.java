package br.com.u2d.cadcli.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = false)
public class Cliente {

	@Tolerate
	public Cliente() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String cpf;
	
	@OneToOne(optional = false)
	private Endereco endereco;
	
	@OneToMany
	@JoinColumn(name = "id_cliente", nullable = false)
	private List<Telefone> telefones;
	
	@OneToMany
	@JoinColumn(name = "id_cliente", nullable = false)
	private List<Email> emails;
}
