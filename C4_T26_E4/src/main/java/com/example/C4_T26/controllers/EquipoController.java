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

import com.example.C4_T26.dto.Equipo;
import com.example.C4_T26.service.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipo> listarEquipos(){
		return equipoServiceImpl.listarEquipos();
	}
	
	@PostMapping("/equipos")
	public Equipo salvarEquipo(@RequestBody Equipo equipo) {
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	
	@GetMapping("/equipos/{id}")
	public Equipo EquipoXID(@PathVariable(name = "id") int id) {
		return equipoServiceImpl.equipoXID(id);
	}
	
	@PutMapping("equipos/{id}")
	public Equipo actualizarEquipo(@PathVariable(name = "id") int id, @RequestBody Equipo equipo) {
		Equipo eq_s = new Equipo();
		Equipo eq_a = new Equipo();
		
		eq_s = equipoServiceImpl.equipoXID(id);
		
		eq_s.setNombre(equipo.getNombre());
		eq_s.setFacultad(equipo.getFacultad());
		
		eq_a = equipoServiceImpl.actualizarEquipo(eq_s);
		
		System.out.println("Equipo actualizado:" + eq_a);
		
		return eq_a;
	}
	
	@DeleteMapping("/equipos/{id}")
	public void eliminarEquipo(@PathVariable(name = "id") int id) {
		equipoServiceImpl.eliminarEquipo(id);
	}
}
