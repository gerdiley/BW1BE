package it.epicode.bw.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "tessere")
@Getter
@Setter
@NoArgsConstructor
public class Tessera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "cod_tessera")
	private String codTessera;
	
	@Column(name = "data_emissione")
	private LocalDate dataEmissione;
	
	@OneToOne
	@JoinColumn(name = "utente_id", referencedColumnName = "id")
	private Utente utente;
}
