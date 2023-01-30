package it.epicode.bw.dao;

import it.epicode.bw.models.Utente;
import it.epicode.bw.utils.JpaUtils;

public class UtenteDAO {
	public static void save(Utente u) {
		try {
			JpaUtils.t.begin();
			JpaUtils.em.persist(u);
			JpaUtils.t.commit();
			
			System.out.println("Utente aggiunto correttamente!");
		} catch (Exception e) {
			System.out.println("Errore nell'aggiunta al database" + e.getMessage());
		}
		
	}
}
