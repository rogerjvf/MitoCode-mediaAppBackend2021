package com.mitocode.service;

import java.util.List;
import java.util.Optional;

import com.mitocode.model.Especialidad;

public interface IEspecialidadService {
	
	void registrar(Especialidad obj);

	void modificar(Especialidad obj);
	
	List<Especialidad> listar();

	Optional<Especialidad> leerPorId(Integer id);
	
	void eliminar(Integer id);

}
