package com.bolsaideas.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsaideas.springboot.app.dao.ClienteDao;
import com.bolsaideas.springboot.app.entity.Cliente;

@Service
public class IClienteServiceImpl implements IClienteService {
	
	@Autowired
	private ClienteDao clienteDao;//puede tener varios daos como un puto de acceso

	@Override
	@Transactional
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)//sera solo de lectura
	public void save(Cliente cliente) {
		clienteDao.save(cliente);		
	}

	@Override
	@Transactional(readOnly=true)//sera solo de lectura
	public Cliente findOne(Long id) {
		return clienteDao.findOne(id);
	}

	@Override
	@Transactional
	public Cliente delete(Long id) {
		return clienteDao.delete(id);
	}
	
}
