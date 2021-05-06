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
import com.mitocode.model.Examen;
import com.mitocode.service.IExamenService;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

	@Autowired
	private IExamenService service;
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@GetMapping
	public ResponseEntity<List<Examen>> listar(){
		List<Examen> lista =service.listar();
		return new ResponseEntity<List<Examen>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Examen> leerPorId(@PathVariable("id") Integer id){
		Optional<Examen> obj = service.leerPorId(id);
		if(!obj.isPresent()) {
			log.info("Id de examen no encontrado " + id);
			throw new ModelNotFoundException("Id del examen no encontrado "+id);
		}
		return new ResponseEntity<Examen>(obj.get(),HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Examen obj) {
		Examen examen =service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(examen.getIdExamen()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Examen obj) {
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id ) {
		Optional<Examen> obj = service.leerPorId(id);
		if(!obj.isPresent()) {
			throw new ModelNotFoundException("Id del examen no encontrado "+id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
