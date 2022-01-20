package com.bolsaideas.springboot.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.app.dao.ClienteDao;
import com.bolsaideas.springboot.app.entity.Cliente;
import com.bolsaideas.springboot.app.service.IClienteService;

@Controller
@RequestMapping("clientes")
public class ClienteController {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

	//@Autowired	private ClienteDao clienteDao;
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("listar")
	public String listar(Model model) {	
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes",clienteService.findAll() );
		return "listar";
	}
	@GetMapping("form")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "Formulario de Cliente");
		Cliente cliente=new Cliente();
		model.put("cliente", cliente);
		return "form";
	}
	@PostMapping("form")
	public String guardar(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {
			
			return "form";//sin redirect
		}
		log.info("cliente: "+cliente);
		clienteService.save(cliente);
		return "redirect:listar";
	}
	@GetMapping("form/{id}")
	public String editar(Map<String, Object> model,@PathVariable Long id ) {
		Cliente cliente=null;
		if(id>0) {
			try {
				cliente=clienteService.findOne(id);
			} catch (Exception e) {
				log.info(e.getMessage());
				return "redirect:/clientes/listar";
			}
		}
		else 
			return "redirect:/clientes/listar";
		model.put("titulo", "Editar Cliente");		
		model.put("cliente", cliente);
		return "form";
	}
	@GetMapping("delete/{id}")
	public String eliminar(Map<String, Object> model,@PathVariable Long id ) {
		Cliente cliente=null;
		if(id>0) 
				cliente=clienteService.delete(id);
		else 
			return "redirect:/clientes/listar";
		
		model.put("titulo", "Eliminar Cliente");		
		log.info(""+cliente);
		return "redirect:/clientes/listar";
	}
}
