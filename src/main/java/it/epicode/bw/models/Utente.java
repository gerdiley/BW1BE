package it.epicode.bw.models;

import java.time.LocalDate;

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
@Table (name = "utenti")
@Getter
@Setter
@NoArgsConstructor
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nome;
	
	private String cognome;
	
	@OneToOne (mappedBy = "utente")
	private Tessera tessera;
	
	
}
