package com.example.C4_T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.C4_T26.dao.IReservaDAO;
import com.example.C4_T26.dto.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	IReservaDAO reservaDAO;

	@Override
	public List<Reserva> listarReservas() {
		// TODO Auto-generated method stub
		return reservaDAO.findAll();
	}

	@Override
	public Reserva guardarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return reservaDAO.save(reserva);
	}

	@Override
	public Reserva reservaXID(int id) {
		// TODO Auto-generated method stub
		return reservaDAO.findById(id).get();
	}

	@Override
	public Reserva actualizarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return reservaDAO.save(reserva);
	}

	@Override
	public void eliminarReserva(int id) {
		// TODO Auto-generated method stub
		reservaDAO.deleteById(id);
	}
}
