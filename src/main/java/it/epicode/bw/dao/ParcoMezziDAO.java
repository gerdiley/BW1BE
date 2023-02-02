package it.epicode.bw.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import it.epicode.bw.models.MezzoTrasporto;
import it.epicode.bw.models.TitoloViaggio;
import it.epicode.bw.models.Tratta;
import it.epicode.bw.utils.JpaUtils;

public class ParcoMezziDAO {

	public static void save(Object o) {
		try {

			JpaUtils.t.begin();
			JpaUtils.em.persist(o);
			JpaUtils.t.commit();

			System.out.println("Oggetto aggiunto correttamente!");
		} catch (Exception e) {
			System.out.println("Errore nell'aggiunta al database" + e.getMessage());
		}
	}

	public static void vidimazione(TitoloViaggio t, MezzoTrasporto m) {
		if (!t.isConvalida()) {
			System.out.println("Il titolo di viaggio non e valido!");
		} else {
			try {
				JpaUtils.t.begin();
				JpaUtils.em.find(TitoloViaggio.class, t.getId()).setConvalida(false);
				JpaUtils.em.find(TitoloViaggio.class, t.getId()).setDataConvalida(LocalDate.now());
				JpaUtils.em.find(TitoloViaggio.class, t.getId()).setMezzoVidimante(m);
				JpaUtils.t.commit();
				System.out.println("Il titolo di viaggio e stato convalidato correttamente");
			} catch (Exception e) {
				JpaUtils.em.getTransaction().rollback();
				throw e;
			}
		}
	}

	public static void numeroVidimazioniMezzo(MezzoTrasporto m) {
		try {
			
			Query q = JpaUtils.em.createNamedQuery("numeroBigliettiVidimatiByMezzo");
			q.setParameter("c", m.getId());

			Object res = q.getResultList();

			System.out.println("Il totale dei biglietti vidimati dal mezzo id: " + m.getId() + " e di: " + res);

		} catch (Exception e) {
			System.out.println("Errore nella ricerca!" + e.getMessage());
		}
	}
	
	public static void getBigliettiVidimatiByData(LocalDate d1, LocalDate d2) {
		try {
			Query q = JpaUtils.em.createNamedQuery("getBigliettiVidimatiByData");
			q.setParameter("d", d1);
			q.setParameter("f", d2);
			
			List res = q.getResultList();
			
			System.out.println("I biglietti vidimati dal: " + d1 + " al " + d2 + " sono:");
			if (res.size()<=0) {
				System.out.println("La ricerca non ha prodotto nessun risultato");
			} else {
				res.forEach(e->System.out.println(e.toString()));
			}
			
		} catch (Exception e) {
			System.out.println("Errore nella ricerca!" + e.getMessage());
		}
	}

	public static void effettuaTratta(MezzoTrasporto m, Tratta t) {
		try {
			JpaUtils.t.begin();
			JpaUtils.em.find(Tratta.class, t.getId()).setMezzo(m);
			JpaUtils.t.commit();
			System.out.println("La tratta e stata percorsa correttamente");
		} catch (Exception e) {
			JpaUtils.em.getTransaction().rollback();
			throw e;
		}
	}
	
	public static void getTratteEffettuate(MezzoTrasporto m) {
		try {
			
			Query q = JpaUtils.em.createNamedQuery("tratteEffettuate");
			
			Object res = q.getResultList();
			
			System.out.println("Il totale delle tratte percorse dal mezzo id: " + m.getId() + " e di: " + res);
			
		} catch (Exception e) {
			System.out.println("Errore nella ricerca!" + e.getMessage());
		}
	}
	
}
