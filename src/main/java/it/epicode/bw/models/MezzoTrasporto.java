package it.epicode.bw.models;

import java.time.LocalDate;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MezzoTrasporto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column (name = "stato_mezzo")
	private StatoMezzo statoMezzo;
	
	@Column (name = "inizio_manutenzione")
	private LocalDate inizioManutenzione;
	
	@Column (name = "fine_manutenzione")
	private LocalDate fineManutenzione;
	
	@Column (name = "inizio_servizio")
	private LocalDate inizioServizio;
	
	@Column (name = "fine_servizio")
	private LocalDate fineServizio;
	
	@Column (name = "numero_biglietti")
	private int numeroBiglietti;
	
	private TipoMezzo tipoMezzo;
	
	@ManyToOne
	private Tratta tratta;
	

	private int capienza;


	public MezzoTrasporto(StatoMezzo statoMezzo, LocalDate inizioManutenzione, LocalDate fineManutenzione,
			LocalDate inizioServizio, LocalDate fineServizio, int numeroBiglietti, TipoMezzo tipoMezzo, Tratta tratta,
			int capienza) {
		
		this.statoMezzo = statoMezzo;
		this.inizioManutenzione = inizioManutenzione;
		this.fineManutenzione = fineManutenzione;
		this.inizioServizio = inizioServizio;
		this.fineServizio = fineServizio;
		this.numeroBiglietti = numeroBiglietti;
		this.tipoMezzo = tipoMezzo;
		this.tratta = tratta;
		this.capienza = capienza;
	}
	
	
}
