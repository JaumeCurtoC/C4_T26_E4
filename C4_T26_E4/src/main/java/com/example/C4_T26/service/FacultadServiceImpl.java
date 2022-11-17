package com.example.C4_T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.C4_T26.dao.IFacultadDAO;
import com.example.C4_T26.dto.Facultad;

@Service
public class FacultadServiceImpl implements IFacultadService {

	@Autowired
	IFacultadDAO facultadDAO;

	@Override
	public List<Facultad> listarFacultades() {
		// TODO Auto-generated method stub
		return facultadDAO.findAll();
	}

	@Override
	public Facultad guardarFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		return facultadDAO.save(facultad);
	}

	@Override
	public Facultad facultadXID(int id) {
		// TODO Auto-generated method stub
		return facultadDAO.findById(id).get();
	}

	@Override
	public Facultad actualizarFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		return facultadDAO.save(facultad);
	}

	@Override
	public void eliminarFacultad(int id) {
		// TODO Auto-generated method stub
		facultadDAO.deleteById(id);
	}
}
