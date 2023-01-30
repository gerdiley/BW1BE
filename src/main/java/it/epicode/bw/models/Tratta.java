package it.epicode.bw.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tratta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String partenza;
	private String capolinea;
	private double tempoMedio;
	private double tempoEffettivo;
	 
}
