package it.epicode.bw.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany
	private List<MezzoTrasporto> mezzo =  new ArrayList<MezzoTrasporto>();
	
	
public Tratta(String partenza, String capolinea, double tempoMedio, double tempoEffettivo) {
		this.partenza = partenza;
		this.capolinea = capolinea;
		this.tempoMedio = tempoMedio;
		this.tempoEffettivo = tempoEffettivo;
	}
public void setMezzo(MezzoTrasporto mezzo) {
	this.mezzo.add(mezzo);
}
	 
}
