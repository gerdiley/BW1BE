package it.epicode.bw.app;

import java.time.LocalDate;

import it.epicode.bw.dao.ParcoMezziDAO;
import it.epicode.bw.dao.PuntoVenditaDAO;
import it.epicode.bw.dao.TesseraDAO;
import it.epicode.bw.dao.UtenteDAO;
import it.epicode.bw.models.Abbonamento;
import it.epicode.bw.models.Biglietto;
import it.epicode.bw.models.DurataAbbonamento;
import it.epicode.bw.models.MezzoTrasporto;
import it.epicode.bw.models.PuntoVendita;
import it.epicode.bw.models.Rivenditore;
import it.epicode.bw.models.StatoMezzo;
import it.epicode.bw.models.Tessera;
import it.epicode.bw.models.TipoMezzo;
import it.epicode.bw.models.TitoloViaggio;
import it.epicode.bw.models.Utente;

public class Main {

	public static void main(String[] args) {

		// ------CREO NUOVO UTENTE------
		Utente u1 = new Utente();
		u1.setCognome("Midolo");
		u1.setNome("Angelo");

		UtenteDAO.save(u1);

		// ------CREO NUOVA TESSERA------
		Tessera t1 = new Tessera();
		t1.setCodTessera("100");
		t1.setDataEmissione(LocalDate.parse("2023-01-20"));
		t1.setUtente(u1);

		TesseraDAO.save(t1);

		// ------CREO NUOVO PUNTO VENDITA------
		PuntoVendita riv1 = new Rivenditore();

		PuntoVenditaDAO.save(riv1);

		PuntoVendita riv2 = new Rivenditore();

		PuntoVenditaDAO.save(riv2);

		// ------EMETTO IL BIGLIETTO DAL PUNTO VENDITA------

		Biglietto b6 = PuntoVenditaDAO.emettiBiglietto("37", riv2);
		
		Biglietto b8 = PuntoVenditaDAO.emettiBiglietto("39", riv1);
		
		//PuntoVenditaDAO.emettiAbbonamento(null, riv2, null, t1)
		PuntoVenditaDAO.emettiAbbonamento("43", riv1, DurataAbbonamento.MENSILE, t1);

		//PuntoVenditaDAO.getBigliettiVenduti(52);
		
		//PuntoVenditaDAO.getBigliettiPeriodo(LocalDate.parse("2023-01-31"), LocalDate.parse("2023-01-31"));
		
//		PuntoVenditaDAO.isValid("100");
		
		
		
		
		// ISTANZA MEZZO
        MezzoTrasporto m1 = new MezzoTrasporto(StatoMezzo.InSERVIZIO, null, null, LocalDate.now(), LocalDate.now().plusDays(1), 0, TipoMezzo.AUTOBUS, null);
        ParcoMezziDAO.save(m1);
//         ISTANZA BIGLIETTO
        TitoloViaggio b1 = PuntoVenditaDAO.emettiBiglietto("20", riv1);
        TitoloViaggio b2 = PuntoVenditaDAO.emettiBiglietto("22", riv1);
//        STAMPA STATO DI VALIDITA
        System.out.println(b1.isConvalida());
        System.out.println(b2.isConvalida());
//        VALIDAZIONE
        ParcoMezziDAO.vidimazione(b1, m1);
        ParcoMezziDAO.vidimazione(b2, m1);
//        STAMPA STATO DI VALIDITA DOPO LA VALIDAZIONE
        System.out.println(b1.isConvalida());
        System.out.println(m1.getNumeroBiglietti()); 
	}

}
