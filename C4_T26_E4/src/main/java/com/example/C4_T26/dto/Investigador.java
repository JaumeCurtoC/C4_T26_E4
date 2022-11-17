package com.example.C4_T26.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "investigadores")
public class Investigador {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name = "DNI")
	private String dni;

	@Column(name = "nom_apels")
	private String nom_apels;
	
	@ManyToOne
	@JoinColumn(name = "facultad")
	private Facultad facultad;

	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Reserva> reservas;
	
	//------------------CONSTRUCTORES----------------------------

	public Investigador() {

	}
	
	public Investigador(int codigo, String dni, String nom_apels, Facultad facultad, List<Reserva> reservas) {
		this.codigo = codigo;
		this.dni = dni;
		this.nom_apels = nom_apels;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	//----------------GETTERS Y SETTERS------------------------------

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom_apels() {
		return nom_apels;
	}

	public void setNom_apels(String nom_apels) {
		this.nom_apels = nom_apels;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	//------------------------TOSTRING-----------------------------

	@Override
	public String toString() {
		return "Investigador [codigo=" + codigo + ", dni=" + dni + ", nom_apels=" + nom_apels + ", facultad=" + facultad
				+ "]";
	}
	
}
