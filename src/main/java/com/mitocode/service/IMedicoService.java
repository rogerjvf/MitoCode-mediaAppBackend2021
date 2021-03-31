package com.mitocode.service;

import java.util.List;
import java.util.Optional;

import com.mitocode.model.Medico;

public interface IMedicoService {
	
	void registrar(Medico obj);
	
	void modificar(Medico obj);
	
	List<Medico> listar();

	Optional<Medico> leerPorId(Integer id);
	
	void eliminar(Integer id);

}
