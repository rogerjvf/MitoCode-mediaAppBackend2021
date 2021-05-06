package com.mitocode.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Especialidad;
import com.mitocode.service.IEspecialidadService;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
	
	@Autowired
	private IEspecialidadService service;
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@GetMapping
	public ResponseEntity<List<Especialidad>> listar(){
		List<Especialidad> lista = service.listar();
		return new ResponseEntity<List<Especialidad>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> leerPorId(@PathVariable("id") Integer id){
		Optional<Especialidad> obj=service.leerPorId(id);
		if(!obj.isPresent()) {
			log.info("Id de Especialidad no encontrado " + id);
			throw new ModelNotFoundException("Id de Especialidad no encontrado "+id);
		}
		return new ResponseEntity<Especialidad>(obj.get(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Especialidad obj) {
		Especialidad esp = service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(esp.getIdEspecialidad()).toUri();
		return ResponseEntity.created(location).build(); 
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Especialidad obj) {
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Optional<Especialidad> obj=service.leerPorId(id);
		if(!obj.isPresent()) {
			throw new ModelNotFoundException("Id de Especialidad no encontrado "+id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
