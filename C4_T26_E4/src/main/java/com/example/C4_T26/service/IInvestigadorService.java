package com.example.C4_T26.service;

import java.util.List;

import com.example.C4_T26.dto.Investigador;

public interface IInvestigadorService {

	// Metodos CRUD
	//Listar
	public List<Investigador> listarInvestigadores();
	
	// CREATE
	public Investigador guardarInvestigador(Investigador investigador);
	
	// READ
	public Investigador investigadorXID(int id);
	
	// UPDATE
	public Investigador actualizarInvestigador(Investigador investigador);
	
	// DELETE
	public void eliminarInvestigador(int id);
	
}
