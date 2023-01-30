package it.epicode.bw.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "titoli_viaggio")
@Getter
@Setter
@NoArgsConstructor
public class Abbonamento extends TitoloViaggio{
	
	
//	private Utente utente;
	
	@OneToOne
	private Tessera tessera;
	private DurataAbbonamento durataAbbonamento;
	
}
