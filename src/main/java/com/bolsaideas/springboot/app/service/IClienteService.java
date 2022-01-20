package com.bolsaideas.springboot.app.service;

import java.util.List;

import com.bolsaideas.springboot.app.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	public void save(Cliente cliente);
	public Cliente findOne(Long id);
	public Cliente delete(Long id);

}
