package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Paciente;
import com.mitocode.repo.IPacienteRepo;
import com.mitocode.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService{
	
	@Autowired 
	private IPacienteRepo repo;

	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Override
	public Paciente registrar(Paciente pac) {
		log.info("guardando paciente "+pac.getNombres());
		return repo.save(pac);
	}

	@Override
	public void modificar(Paciente pac) {
		repo.save(pac);
	}

	@Override
	public List<Paciente> listar() {
		return repo.findAll();
	}

	@Override
	public Optional<Paciente> leerPorId(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

}
