package br.edu.infnet.animaniaapp.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TAnimal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private float valor;
	private int idade;
	@ManyToMany(mappedBy = "animais")
	private List<Adocao> adocoes;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	//getters and setters via lombok
	
	@Override
	public String toString() {
		
		return nome;
	}
	
	
}