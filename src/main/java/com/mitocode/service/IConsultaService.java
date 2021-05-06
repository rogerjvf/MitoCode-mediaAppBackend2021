package com.mitocode.service;

import com.mitocode.dto.ConsultaListaExamenDTO;
import com.mitocode.model.Consulta;

public interface IConsultaService extends ICRUD<Consulta>{

	/*void registrar(Consulta obj);
	void modificar(Consulta obj);
	List<Consulta> listar();
	Optional<Consulta> leerPorId(Integer id);
	void eliminar(Integer id);*/
	
	
	ConsultaListaExamenDTO registrarTRansaccional(ConsultaListaExamenDTO consultaDTO);
	
}
