package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Consulta;

//@Repository no se usa el stereotype porq ya esta heredando de JpaRepository
public interface IConsultaRepo extends JpaRepository<Consulta, Integer>{

}
