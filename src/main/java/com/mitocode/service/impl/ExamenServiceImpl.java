package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Examen;
import com.mitocode.repo.IExamenRepo;
import com.mitocode.service.IExamenService;

@Service
public class ExamenServiceImpl implements IExamenService{

	@Autowired
	private IExamenRepo repo;
	
	@Override
	public void registrar(Examen obj) {
		repo.save(obj);
	}

	@Override
	public void modificar(Examen obj) {
		repo.save(obj);
	}

	@Override
	public List<Examen> listar() {
		return repo.findAll();
	}

	@Override
	public Optional<Examen> leerPorId(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

	
	
}
