package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Medico;

//@Repository no se usa el stereotype porq ya esta heredando de JpaRepository
public interface IMedicoRepo extends JpaRepository<Medico, Integer>{

}
