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

import com.mitocode.model.Examen;
import com.mitocode.service.IExamenService;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

	@Autowired
	private IExamenService service;
	
	@GetMapping
	public List<Examen> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Optional<Examen> leerPorId(@PathVariable("id") Integer id){
		return service.leerPorId(id);
	}
	
	@PostMapping
	public void registrar(@RequestBody Examen obj) {
		service.registrar(obj);
	}
	
	@PutMapping
	public void modificar(@RequestBody Examen obj) {
		service.modificar(obj);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id ) {
		service.eliminar(id);
	}
	
}
