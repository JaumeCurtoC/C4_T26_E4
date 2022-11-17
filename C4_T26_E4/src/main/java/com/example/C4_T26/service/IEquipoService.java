package com.example.C4_T26.service;

import java.util.List;

import com.example.C4_T26.dto.Equipo;

public interface IEquipoService {

	// Metodos CRUD
	//Listar
	public List<Equipo> listarEquipos();
	
	// CREATE
	public Equipo guardarEquipo(Equipo equipo);
	
	// READ
	public Equipo equipoXID(int id);
	
	// UPDATE
	public Equipo actualizarEquipo(Equipo equipo);
	
	// DELETE
	public void eliminarEquipo(int id);
	
}
