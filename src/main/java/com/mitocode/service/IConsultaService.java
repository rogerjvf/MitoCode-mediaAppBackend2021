package com.mitocode.service;

import java.util.List;
import java.util.Optional;

import com.mitocode.model.Consulta;

public interface IConsultaService {

	void registrar(Consulta obj);

	void modificar(Consulta obj);
	
	List<Consulta> listar();

	Optional<Consulta> leerPorId(Integer id);
	
	void eliminar(Integer id);
	
}
