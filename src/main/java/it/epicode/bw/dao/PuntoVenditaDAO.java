package it.epicode.bw.dao;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import it.epicode.bw.models.Abbonamento;
import it.epicode.bw.models.Biglietto;
import it.epicode.bw.models.DurataAbbonamento;
import it.epicode.bw.models.PuntoVendita;
import it.epicode.bw.models.Rivenditore;
import it.epicode.bw.models.Tessera;
import it.epicode.bw.models.TitoloViaggio;
import it.epicode.bw.utils.JpaUtils;


public class PuntoVenditaDAO {

	public static void save(PuntoVendita p) {
		try {

			JpaUtils.t.begin();
			JpaUtils.em.persist(p);
			JpaUtils.t.commit();

			System.out.println("Punto vendita aggiunto correttamente!");
		} catch (Exception e) {
			System.out.println("Errore nell'aggiunta al database" + e.getMessage());
		}
	}

	public static Biglietto emettiBiglietto(String codUnivoco, PuntoVendita p) {
		try {

			Biglietto b = new Biglietto();

			b.setCodUnivoco(codUnivoco);
			b.setPuntoVendita(p);
			b.setDataEmissione(LocalDate.now());

			JpaUtils.t.begin();
			JpaUtils.em.persist(b);
			JpaUtils.t.commit();

			System.out.println("Biglietto emesso correttamente!");

			return b;

		} catch (Exception e) {
			System.out.println("Errore nell'emissione del biglietto!!" + e.getMessage());

			return null;
		}
	}

	public static Abbonamento emettiAbbonamento(String codUnivoco, PuntoVendita p, DurataAbbonamento durata,
			Tessera t) {
		try {

			Abbonamento a = new Abbonamento();
			a.setCodUnivoco(codUnivoco);
			a.setDataEmissione(LocalDate.now());
			a.setDurataAbbonamento(durata);
			// try catch per controllare se la tessera e` valida 
			a.setTessera(t);
			a.setPuntoVendita(p);

			JpaUtils.t.begin();
			JpaUtils.em.persist(a);
			JpaUtils.t.commit();

			System.out.println("Abbonamento emesso correttamente!" + a.toString());

			return a;

		} catch (Exception e) {
			System.out.println("Errore nell'emissione dell'abbonamento" + e.getMessage());

			return null;
		}
	}

	public static void getBigliettiVenduti(int id) {
		try {

			Query q = JpaUtils.em.createNamedQuery("numeroBigliettiByPunto");
			q.setParameter("a", id);

			Object res = q.getResultList();

			System.out.println("Totale biglietti venduti: " + res);

		} catch (Exception e) {
			System.out.println("Errore nell'emissione del biglietto!!" + e.getMessage());

		}
	}

	public static void getBigliettiPeriodo(LocalDate a, LocalDate b) {
		try {

			Query q = JpaUtils.em.createNamedQuery("getBigliettiByData");
			q.setParameter("a", a);
			q.setParameter("b", b);

			Object res = q.getResultList();

			System.out.println("Totale biglietti venduti nel perodo da " + a + " a " + b + ": " + res);

		} catch (Exception e) {
			System.out.println("Errore nella ricerca!!" + e.getMessage());

		}
	}

	public static void isValid(String codTessera) {// COME PARAMETRO DEVE RICEVERE IL NUMERO DI TESSERA NON L'ABBONAMENTO
		try {
			Query q = JpaUtils.em.createNamedQuery("getDateByCod");
			q.setParameter("c", codTessera);
			
			Object res = q.getSingleResult();
			
			String date1 = res.toString();
			LocalDate date2 = LocalDate.parse(date1);
			System.out.println("Data emissione abbonamento: "+ date2);
			
			
			Query q1 = JpaUtils.em.createNamedQuery("getDurataByCod");
			q1.setParameter("d", codTessera);
			
			Object res1 = q1.getSingleResult();
			
			String durata = res1.toString();
			System.out.println("Durata abbonamento: " + durata);
			
			switch (durata) {
			case "MENSILE": 
				if(LocalDate.now().isAfter(date2.plusMonths(1))){
					System.out.println("Abbonamento scaduto");
				} else {System.out.println("Abbonamento valido fino al " + date2.plusMonths(1));}
				
				break;
			case "SETTIMANALE": 
				if(LocalDate.now().isAfter(date2.plusWeeks(1))){
					System.out.println("Abbonamento scaduto");
				} else {System.out.println("Abbonamento valido fino al " + date2.plusWeeks(1));}
				
				break;
			default:
				System.out.println("Errore durante la verifica");;
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Codice tessera non valido" + e.getMessage());
		}
		//		if (LocalDate.now().isAfter(a.getDataEmissione().plusYears(1))) {
//			a.setValid(false);
//			System.out.println("L'abbonamento non è valido");
//		} else {
//			a.setValid(true);
//			System.out.println("L'abbonamento è valido");
//		}
	}
	

}
