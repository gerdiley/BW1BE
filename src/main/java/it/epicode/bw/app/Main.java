package it.epicode.bw.app;

import java.time.LocalDate;

import it.epicode.bw.dao.PuntoVenditaDAO;
import it.epicode.bw.dao.TesseraDAO;
import it.epicode.bw.dao.UtenteDAO;
import it.epicode.bw.models.Abbonamento;
import it.epicode.bw.models.Biglietto;
import it.epicode.bw.models.DurataAbbonamento;
import it.epicode.bw.models.PuntoVendita;
import it.epicode.bw.models.Rivenditore;
import it.epicode.bw.models.Tessera;
import it.epicode.bw.models.TitoloViaggio;
import it.epicode.bw.models.Utente;

public class Main {

	public static void main(String[] args) {

		// ------CREO NUOVO UTENTE------
		Utente u1 = new Utente();
		u1.setCognome("Midolo");
		u1.setNome("Angelo");

		//UtenteDAO.save(u1);

		// ------CREO NUOVA TESSERA------
		Tessera t1 = new Tessera();
		t1.setCodTessera("100");
		t1.setDataEmissione(LocalDate.parse("2023-01-20"));
		t1.setUtente(u1);

		//TesseraDAO.save(t1);

		// ------CREO NUOVO PUNTO VENDITA------
		PuntoVendita riv1 = new Rivenditore();

		//PuntoVenditaDAO.save(riv1);

		PuntoVendita riv2 = new Rivenditore();

		//PuntoVenditaDAO.save(riv3);

		// ------EMETTO IL BIGLIETTO DAL PUNTO VENDITA------

		//Biglietto b6 = PuntoVenditaDAO.emettiBiglietto("37", riv2);
		
		//Biglietto b6 = PuntoVenditaDAO.emettiBiglietto("38", riv1);
		
		Abbonamento b7 = new Abbonamento();
		b7.setCodUnivoco("44");
		b7.setPuntoVendita(riv1);
		b7.setDurataAbbonamento(DurataAbbonamento.SETTIMANALE);
		b7.setTessera(t1);
		b7.setDataEmissione(LocalDate.now());
		
		//PuntoVenditaDAO.emettiAbbonamento(null, riv2, null, t1)
		//PuntoVenditaDAO.emettiAbbonamento("43", riv1, DurataAbbonamento.MENSILE, t1)

		//PuntoVenditaDAO.getBigliettiVenduti(52);
		
		//PuntoVenditaDAO.getBigliettiPeriodo(LocalDate.parse("2023-01-31"), LocalDate.parse("2023-01-31"));
		
		PuntoVenditaDAO.isValid(b7);
	}

}
