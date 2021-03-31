package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Consulta;
import com.mitocode.repo.IConsultaRepo;
import com.mitocode.service.IConsultaService;

@Service
public class ConsultasServiceImpl implements IConsultaService{

	@Autowired
	private IConsultaRepo repo;
	
	@Override
	public void registrar(Consulta obj) {
		repo.save(obj);
	}

	@Override
	public void modificar(Consulta obj) {
		repo.save(obj);
	}

	@Override
	public List<Consulta> listar() {
		return repo.findAll();
	}

	@Override
	public Optional<Consulta> leerPorId(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

	
}
