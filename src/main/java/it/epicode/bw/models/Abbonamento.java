package it.epicode.bw.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "abbonamenti")
@Getter
@Setter
@NoArgsConstructor
public class Abbonamento extends TitoloViaggio{
	
	
//	private Utente utente;
	
	@OneToOne
	private Tessera tessera;
	@Enumerated(EnumType.STRING)
	private DurataAbbonamento durataAbbonamento;
	
	private boolean isValid;
	
}
