package com.mitocode.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.validation.Valid;

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
import com.mitocode.exception.ModelNotFoundException2;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService service;
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@GetMapping
	public ResponseEntity<List<Paciente>> listar(){
		List<Paciente> obj=service.listar();
		return new ResponseEntity<List<Paciente>>(obj,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> leerPorId(@Valid @PathVariable("id") Integer id) {
		Optional<Paciente> optional= service.leerPorId(id);
		
		if(!optional.isPresent()) {
			log.info("Id de paciente no encontrado " + id);
			throw new ModelNotFoundException2("Id de paciente no encontrado " + id);
		}
		return new ResponseEntity<Paciente>(optional.get(),HttpStatus.OK);
	}
	
	/*//para el uso del nivel 3 de maduracion de richardson
	 @GetMapping("/hateoas/{id}")
	public Resou<Paciente> leerPorIdHateoas(@Valid @PathVariable("id") Integer id) {
		Optional<Paciente> optional= service.leerPorId(id);
		
		if(!optional.isPresent()) {
			log.info("Id de paciente no encontrado " + id);
			throw new ModelNotFoundException2("Id de paciente no encontrado " + id);
		}
		return new ResponseEntity<Paciente>(optional.get(),HttpStatus.OK);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> regristrar (@Valid @RequestBody Paciente pac) {
		Paciente paciente = service.registrar(pac);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object>  modificar( @RequestBody Paciente pac) {
		service.modificar(pac);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Optional<Paciente> obj= service.leerPorId(id);
		if(!obj.isPresent()) {
			log.info("Id de paciente a eliminar no encontrado" + id);
			throw new ModelNotFoundException("Id de paciente a eliminar no encontrado " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
