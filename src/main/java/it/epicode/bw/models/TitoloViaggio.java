package it.epicode.bw.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
public abstract class TitoloViaggio {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true, name = "cod_univoco")
	protected String codUnivoco;
	
	protected boolean convalida =  false;
	
	@ManyToOne
	protected PuntoVendita puntoVendita;

	public TitoloViaggio(String codUnivoco, boolean convalida) {
		
		this.codUnivoco = codUnivoco;
		this.convalida = convalida;
	}
	
	
	
	
}
