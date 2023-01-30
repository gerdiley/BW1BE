package it.epicode.bw.app;

import java.time.LocalDate;

import it.epicode.bw.dao.PuntoVenditaDAO;
import it.epicode.bw.dao.TesseraDAO;
import it.epicode.bw.dao.UtenteDAO;
import it.epicode.bw.models.PuntoVendita;
import it.epicode.bw.models.Rivenditore;
import it.epicode.bw.models.Tessera;
import it.epicode.bw.models.Utente;

public class Main {

	public static void main(String[] args) {
		
		
		
		Utente u1 = new Utente();
		u1.setCognome("Midolo");
		u1.setNome("Angelo");
		
		Tessera t1 = new Tessera();
		
		t1.setCodTessera("100");
		t1.setDataEmissione(LocalDate.parse("2023-01-20"));
		t1.setUtente(u1);
//		
//		UtenteDAO.save(u1);
//		
//		TesseraDAO.save(t1);
		
		
		PuntoVendita riv1 = new Rivenditore();
		
		
		PuntoVenditaDAO.emettiBiglietto("20", riv1);
		
		
	}

}
