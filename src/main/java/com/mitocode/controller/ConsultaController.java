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

import com.mitocode.dto.ConsultaListaExamenDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Consulta;
import com.mitocode.service.IConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private IConsultaService service;
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@GetMapping
	public ResponseEntity<List<Consulta>> listar() {
		List<Consulta> lista = service.listar(); 
		return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> leerPorId(@PathVariable("id") Integer id ){
		Optional<Consulta> obj = service.leerPorId(id);
		if(!obj.isPresent()) {
			log.info("Id de consulta no encontrado " + id);
			throw new ModelNotFoundException("Id de consulta no encontrado "+id);
		}
		return new ResponseEntity<Consulta>(obj.get(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody ConsultaListaExamenDTO obj) {
		ConsultaListaExamenDTO consul = service.registrarTRansaccional(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(consul.getConsulta().getIdConsulta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Consulta obj) {
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> elimiar(@PathVariable("id") Integer id) {
		Optional<Consulta> obj = service.leerPorId(id);
		if(!obj.isPresent()) {
			throw new ModelNotFoundException("Id de consulta no encontrado "+id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
