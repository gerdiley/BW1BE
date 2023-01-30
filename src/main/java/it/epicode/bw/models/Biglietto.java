package it.epicode.bw.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "titolo_viaggio")
@Getter
@Setter
@NoArgsConstructor
public class Biglietto extends TitoloViaggio {
	private double durata;

	public Biglietto(String codUnivoco, boolean convalida, double durata) {
		super(codUnivoco, convalida);
		this.durata = durata;
	}
	
}
