package com.example.C4_T26.service;

import java.util.List;

import com.example.C4_T26.dto.Reserva;

public interface IReservaService {

	// Metodos CRUD
	//Listar
	public List<Reserva> listarReservas();
	
	// CREATE
	public Reserva guardarReserva(Reserva reserva);
	
	// READ
	public Reserva reservaXID(int id);
	
	// UPDATE
	public Reserva actualizarReserva(Reserva reserva);
	
	// DELETE
	public void eliminarReserva(int id);
	
}
