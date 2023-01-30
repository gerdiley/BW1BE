package it.epicode.bw.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "rivenditori")
@NoArgsConstructor
public class Rivenditore extends PuntoVendita {public Rivenditore(int numeroBiglietti) {
		super(numeroBiglietti);
		
	}
	
	
}
