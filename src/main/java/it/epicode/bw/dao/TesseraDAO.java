package it.epicode.bw.dao;

import java.time.LocalDate;

import javax.persistence.Query;

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
	
	public static void rinnova(String codTessera) {
		
		try {
			Query q = JpaUtils.em.createNamedQuery("getDataEmissione");
			q.setParameter("t", codTessera);
			
			Object res = q.getSingleResult();
			
			String date1 = res.toString();
			LocalDate date2 = LocalDate.parse(date1);
			System.out.println("Data emissione tessera: "+ date2);
			
			if (LocalDate.now().isAfter(date2)) {
				date2 = LocalDate.now().plusYears(1);
				JpaUtils.t.begin();
				
				Query q1 = JpaUtils.em.createQuery("UPDATE Tessera t SET dataEmissione = :d WHERE t.codTessera = :t");
				q1.setParameter("d", date2);
				q1.setParameter("t", codTessera);
				
				q1.executeUpdate();
				
				JpaUtils.t.commit();
				
				System.out.println("tessera rinnovata!");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
