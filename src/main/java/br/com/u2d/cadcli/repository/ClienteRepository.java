package br.com.u2d.cadcli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.cdi.Eager;

import br.com.u2d.cadcli.model.Cliente;

@Eager
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
}
