package it.epicode.bw.dao;

import javax.management.Query;

import it.epicode.bw.models.MezzoTrasporto;
import it.epicode.bw.models.TitoloViaggio;
import it.epicode.bw.utils.JpaUtils;

public class ParcoMezziDAO {

	public static void save(Object o){
		 try {

	            JpaUtils.t.begin();
	            JpaUtils.em.persist(o);
	            JpaUtils.t.commit();

	            System.out.println("Mezzo aggiunto correttamente!");
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
			JpaUtils.em.find(MezzoTrasporto.class, m.getId()).setNumeroBiglietti(m.getNumeroBiglietti() + 1);;
			JpaUtils.t.commit();
			System.out.println("Il titolo di viaggio e stato convalidato correttamente");
			} catch (Exception e) {
				JpaUtils.em.getTransaction().rollback();
				throw e;
			}
		}
	}
}
