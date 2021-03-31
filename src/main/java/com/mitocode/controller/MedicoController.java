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

import com.mitocode.model.Medico;
import com.mitocode.service.IMedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private IMedicoService service;
	
	@GetMapping
	public List<Medico> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Optional<Medico> leerPorId(@PathVariable("id") Integer id) {
		return service.leerPorId(id);
	}
	
	@PostMapping
	public void registrar(@RequestBody Medico med) {
		service.registrar(med);
	}
	
	@PutMapping
	public void modificar(@RequestBody Medico med) {
		service.modificar(med);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}

}
