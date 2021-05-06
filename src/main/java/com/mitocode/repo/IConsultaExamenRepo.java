package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitocode.model.ConsultaExamen;

//@Repository no se usa el stereotype porq ya esta heredando de JpaRepository
public interface IConsultaExamenRepo extends JpaRepository<ConsultaExamen, Integer>{
	
	//@Transactional
	@Modifying
	@Query(value = "INSERT INTO consulta_examen(id_consulta,id_examen) VALUES (:idConsulta, :idExamen)", nativeQuery = true)
	Integer registrar(@Param("idConsulta") Integer idCnsulta, @Param("idExamen") Integer idExamen);

}
