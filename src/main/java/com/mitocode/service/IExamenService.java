package com.mitocode.service;

import java.util.List;
import java.util.Optional;

import com.mitocode.model.Examen;

public interface IExamenService {
	
	void registrar(Examen obj);
	
	void modificar(Examen obj);
	
	List<Examen> listar();

	Optional<Examen> leerPorId(Integer id);
	
	void eliminar(Integer id);

}
