package com.bolsaideas.springboot.app.dao;

import java.util.List;

import com.bolsaideas.springboot.app.entity.Cliente;

public interface ClienteDao {
	public List<Cliente> findAll();
	public void save(Cliente cliente);
	public Cliente findOne(Long id);
	public Cliente delete(Long id);
}
