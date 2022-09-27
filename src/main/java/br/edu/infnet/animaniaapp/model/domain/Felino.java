package br.edu.infnet.animaniaapp.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name = "TFelino")
public class Felino extends Animal {

	private boolean castrado;
	private boolean genero;
	private float peso;
	private String raca;
	
	
	//getters and setters
	public boolean isCastrado() {
		return castrado;
	}
	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}
	public boolean isGenero() {
		return genero;
	}
	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	

	
	
	
	
}