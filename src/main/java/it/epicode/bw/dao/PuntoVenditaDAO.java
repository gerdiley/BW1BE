package it.epicode.bw.dao;

import it.epicode.bw.models.Biglietto;
import it.epicode.bw.models.PuntoVendita;
import it.epicode.bw.models.Tessera;
import it.epicode.bw.models.TitoloViaggio;
import it.epicode.bw.utils.JpaUtils;

public class PuntoVenditaDAO {
	
	public static void emettiBiglietto(String codUnivoco, PuntoVendita p) {
			try {
				
				Biglietto b = new Biglietto();
				
				b.setCodUnivoco(codUnivoco);
				b.setPuntoVendita(p);
				
				
				JpaUtils.t.begin();
				JpaUtils.em.persist(b);
				JpaUtils.t.commit();
				
				System.out.println("Titolo aggiunto correttamente!");
			} catch (Exception e) {
				System.out.println("Errore nell'aggiunta al database" + e.getMessage());
			}
}
}
