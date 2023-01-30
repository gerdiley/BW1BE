package it.epicode.bw.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PuntoVendita {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	private int numeroBiglietti;

	public PuntoVendita(int numeroBiglietti) {
		
		this.numeroBiglietti = numeroBiglietti;
	}

	
}
