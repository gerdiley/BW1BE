package it.epicode.bw.dao;

import it.epicode.bw.models.Tessera;
import it.epicode.bw.models.Utente;
import it.epicode.bw.utils.JpaUtils;

public class TesseraDAO {
	public static void save(Tessera t) {
		try {
			JpaUtils.t.begin();
			JpaUtils.em.persist(t);
			JpaUtils.t.commit();
			
			System.out.println("Tessera aggiunta correttamente!");
		} catch (Exception e) {
			System.out.println("Errore nell'aggiunta al database" + e.getMessage());
		}
		
	}
}
