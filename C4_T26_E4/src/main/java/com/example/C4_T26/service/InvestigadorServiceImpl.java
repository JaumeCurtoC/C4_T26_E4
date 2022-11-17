package com.example.C4_T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.C4_T26.dao.IInvestigadorDAO;
import com.example.C4_T26.dto.Investigador;


@Service
public class InvestigadorServiceImpl implements IInvestigadorService {

	@Autowired
	IInvestigadorDAO investigadorDAO;

	@Override
	public List<Investigador> listarInvestigadores() {
		// TODO Auto-generated method stub
		return investigadorDAO.findAll();
	}

	@Override
	public Investigador guardarInvestigador(Investigador investigador) {
		// TODO Auto-generated method stub
		return investigadorDAO.save(investigador);
	}

	@Override
	public Investigador investigadorXID(int id) {
		// TODO Auto-generated method stub
		return investigadorDAO.findById(id).get();
	}

	@Override
	public Investigador actualizarInvestigador(Investigador investigador) {
		// TODO Auto-generated method stub
		return investigadorDAO.save(investigador);
	}

	@Override
	public void eliminarInvestigador(int id) {
		// TODO Auto-generated method stub
		investigadorDAO.deleteById(id);
	}

	
}
