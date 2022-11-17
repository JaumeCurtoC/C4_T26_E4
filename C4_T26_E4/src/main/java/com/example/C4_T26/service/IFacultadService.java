package com.example.C4_T26.service;

import java.util.List;

import com.example.C4_T26.dto.Facultad;

public interface IFacultadService {

	// Metodos CRUD
	//Listar
	public List<Facultad> listarFacultades();
	
	// CREATE
	public Facultad guardarFacultad(Facultad facultad);
	
	// READ
	public Facultad facultadXID(int id);
	
	// UPDATE
	public Facultad actualizarFacultad(Facultad facultad);
	
	// DELETE
	public void eliminarFacultad(int id);
	
}
