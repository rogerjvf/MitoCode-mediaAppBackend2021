package com.mitocode.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Consulta;
import com.mitocode.service.IConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private IConsultaService service;
	
	@GetMapping
	public List<Consulta> listar() {
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Optional<Consulta> leerPorId(@PathVariable("id") Integer id ){
		return service.leerPorId(id);
	}
	
	@PostMapping
	public void registrar(@RequestBody Consulta obj) {
		service.registrar(obj);
	}
	
	@PutMapping
	public void modificar(@RequestBody Consulta obj) {
		service.modificar(obj);
	}
	
	@DeleteMapping("/{id}")
	public void elimiar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}

}
