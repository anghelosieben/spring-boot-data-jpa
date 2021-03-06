package com.bolsaideas.springboot.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsaideas.springboot.app.entity.Cliente;
@Repository
public class ClienteDaoImpl implements ClienteDao {
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")//quita el warning 
	
	@Override
	public List<Cliente> findAll() {		
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public void save(Cliente cliente) {
		if(cliente.getId()!=null && cliente.getId()>0)
			em.merge(cliente);
		else
			em.persist(cliente);
	}

	@Override
	public Cliente findOne(Long id) {
		
		return em.find(Cliente.class, id);
	}

	@Override
	public Cliente delete(Long id) {
		Cliente cliente=findOne(id);
		em.remove(cliente);
		return cliente;
	}	

}
