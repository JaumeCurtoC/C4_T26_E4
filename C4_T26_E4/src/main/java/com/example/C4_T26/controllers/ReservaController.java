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

import com.example.C4_T26.dto.Reserva;
import com.example.C4_T26.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/reservas")
	public List<Reserva> listarReservas(){
		return reservaServiceImpl.listarReservas();
	}
	
	@PostMapping("/reservas")
	public Reserva salvarReserva(@RequestBody Reserva reserva) {
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	@GetMapping("/reservas/{id}")
	public Reserva ReservaXID(@PathVariable(name = "id") int id) {
		return reservaServiceImpl.reservaXID(id);
	}
	
	@PutMapping("reservas/{id}")
	public Reserva actualizarReserva(@PathVariable(name = "id") int id, @RequestBody Reserva reserva) {
		Reserva res_s = new Reserva();
		Reserva res_a = new Reserva();
		
		res_s = reservaServiceImpl.reservaXID(id);
		
		res_s.setInvestigador(reserva.getInvestigador());
		res_s.setEquipo(reserva.getEquipo());
		res_s.setInicio(reserva.getInicio());
		res_s.setFin(reserva.getFin());
		
		res_a = reservaServiceImpl.actualizarReserva(res_s);
		
		System.out.println("Reserva actualizada:" + res_a);
		
		return res_a;
	}
	
	@DeleteMapping("/reservas/{id}")
	public void eliminarReserva(@PathVariable(name = "id") int id) {
		reservaServiceImpl.eliminarReserva(id);
	}
}
