package com.mitocode.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {

	T registrar(T t);
	void modificar(T t);
	List<T> listar();
	Optional<T> leerPorId(Integer id);
	void eliminar(Integer id);
}
