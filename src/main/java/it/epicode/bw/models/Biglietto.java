package it.epicode.bw.models;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "biglietto")
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "numeroBigliettiByPunto", query= "SELECT COUNT(b) FROM Biglietto b WHERE b.puntoVendita.id = :a")
@NamedQuery(name = "getBigliettiByData", query= "SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione >= :a AND b.dataEmissione <= :b")
public class Biglietto extends TitoloViaggio {
	private double durata;

	public Biglietto(String codUnivoco, boolean convalida) {
		super(codUnivoco, convalida);
	}
	
}//RIMUOVERE LA DURATA DAL BIGLIETTO
