package com.example.C4_T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.C4_T26.dao.IEquipoDAO;
import com.example.C4_T26.dto.Equipo;

@Service
public class EquipoServiceImpl implements IEquipoService{

	@Autowired
	IEquipoDAO equipoDAO;

	@Override
	public List<Equipo> listarEquipos() {
		// TODO Auto-generated method stub
		return equipoDAO.findAll();
	}

	@Override
	public Equipo guardarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		return equipoDAO.save(equipo);
	}

	@Override
	public Equipo equipoXID(int id) {
		// TODO Auto-generated method stub
		return equipoDAO.findById(id).get();
	}

	@Override
	public Equipo actualizarEquipo(Equipo equipo) {
		// TODO Auto-generated method stub
		return equipoDAO.save(equipo);
	}

	@Override
	public void eliminarEquipo(int id) {
		// TODO Auto-generated method stub
		equipoDAO.deleteById(id);
	}
	
	
}
