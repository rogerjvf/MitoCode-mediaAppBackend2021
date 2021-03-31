package com.mitocode.service;

import java.util.List;
import java.util.Optional;

import com.mitocode.model.Paciente;


public interface IPacienteService {
	
	void registrar(Paciente obj);
	
	void modificar(Paciente obj);
	
	List<Paciente> listar();

	Optional<Paciente> leerPorId(Integer id);
	
	void eliminar(Integer id);
	
}
