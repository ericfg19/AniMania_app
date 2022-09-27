package br.edu.infnet.animaniaapp.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "TCanino")
public class Canino extends Animal {

	private boolean castrado;
	private boolean genero;
	private float peso;
	private String raca;
	
	
	//getters and setters
	
	
}