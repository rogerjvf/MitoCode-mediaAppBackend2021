package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.dto.ConsultaListaExamenDTO;
import com.mitocode.model.Consulta;
import com.mitocode.repo.IConsultaExamenRepo;
import com.mitocode.repo.IConsultaRepo;
import com.mitocode.service.IConsultaService;

@Service
public class ConsultasServiceImpl implements IConsultaService{

	@Autowired
	private IConsultaRepo repo;
	
	@Autowired 
	private IConsultaExamenRepo ceRepo;
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Transactional
	@Override
	public ConsultaListaExamenDTO registrarTRansaccional(ConsultaListaExamenDTO consultaDTO) {
		log.info("registrarTRansaccional ");
		consultaDTO.getConsulta().getDetalleConsultas().forEach(det->det.setConsulta(consultaDTO.getConsulta()));
		log.info("registrarTRansaccional despues del forEach a detallesConsulta");
		repo.save(consultaDTO.getConsulta());
		log.info("registrarTRansaccional despues del save al objeto consulta");
		
		consultaDTO.getListExamen().forEach(ex-> ceRepo.registrar(consultaDTO.getConsulta().getIdConsulta(), ex.getIdExamen()));
		log.info("registrarTRansaccional despues del forEach a ListExamen y guardado Examen");
		return consultaDTO;
	}
	
	@Override
	public Consulta registrar(Consulta obj) {
		log.info("metodo registrar del repo");
		//funcion lambda siempre que haga uso de maestro detalle
		obj.getDetalleConsultas().forEach(det->{
			log.info("Imprimiendo info de detalleCOnsulta diagmostico"+det.getDiagnostico());
			log.info("Imprimiendo info de detalleCOnsulta tratamiento"+det.getTratamiento());
			det.setConsulta(obj);
		});
		
		//igual ah:
		/*for(DetalleConsulta det : obj.getDetalleConsultas()) {
			log.info("Imprimiendo info de detalleCOnsulta diagmostico"+det.getDiagnostico());
			log.info("Imprimiendo info de detalleCOnsulta tratamiento"+det.getTratamiento());
			det.setConsulta(obj);
		}*/
		
		return repo.save(obj);
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
