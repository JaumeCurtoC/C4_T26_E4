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

import com.example.C4_T26.dto.Facultad;
import com.example.C4_T26.service.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	
	@GetMapping("/facultades")
	public List<Facultad> listarFacultades(){
		return facultadServiceImpl.listarFacultades();
	}
	
	@PostMapping("/facultades")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {
		return facultadServiceImpl.guardarFacultad(facultad);
	}
	
	@GetMapping("/facultades/{id}")
	public Facultad FacultadXID(@PathVariable(name = "id") int id) {
		return facultadServiceImpl.facultadXID(id);
	}
	
	@PutMapping("facultades/{id}")
	public Facultad actualizarFacultad(@PathVariable(name = "id") int id, @RequestBody Facultad facultad) {
		Facultad fac_s = new Facultad();
		Facultad fac_a = new Facultad();
		
		fac_s = facultadServiceImpl.facultadXID(id);
		
		fac_s.setNombre(facultad.getNombre());
		
		fac_a = facultadServiceImpl.actualizarFacultad(fac_s);
		
		System.out.println("Facultad actualizada:" + fac_a);
		
		return fac_a;
	}
	
	@DeleteMapping("/facultades/{id}")
	public void eliminarFacultad(@PathVariable(name = "id") int id) {
		facultadServiceImpl.eliminarFacultad(id);
	}
}
