package com.example.C4_T26.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.C4_T26.dto.Investigador;
import com.example.C4_T26.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigadores(){
		return investigadorServiceImpl.listarInvestigadores();
	}
	
	@PostMapping("/investigadores")
	public Investigador salvarInvestigador(@RequestBody Investigador investigador) {
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}
	
	@GetMapping("/investigadores/{id}")
	public Investigador InvestigadorXID(@PathVariable(name = "id") int id) {
		return investigadorServiceImpl.investigadorXID(id);
	}
	
	@PutMapping("investigadores/{id}")
	public Investigador actualizarInvestigador(@PathVariable(name = "id") int id, @RequestBody Investigador investigador) {
		Investigador inv_s = new Investigador();
		Investigador inv_a = new Investigador();
		
		inv_s = investigadorServiceImpl.investigadorXID(id);
		
		inv_s.setDni(investigador.getDni());
		inv_s.setNom_apels(investigador.getNom_apels());
		inv_s.setFacultad(investigador.getFacultad());
		
		inv_a = investigadorServiceImpl.actualizarInvestigador(inv_s);
		
		System.out.println("Investigador actualizado:" + inv_a);
		
		return inv_a;
	}
	
	@DeleteMapping("/investigadores/{id}")
	public void eliminarInvestigador(@PathVariable(name = "id") int id) {
		investigadorServiceImpl.eliminarInvestigador(id);
	}
}
