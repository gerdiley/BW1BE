package it.epicode.bw.dao;

import java.time.LocalDate;

import it.epicode.bw.models.Biglietto;
import it.epicode.bw.models.Distributore;
import it.epicode.bw.models.PuntoVendita;
import it.epicode.bw.models.StatoDistributore;
import it.epicode.bw.utils.JpaUtils;

public class DistributoreDAO {

	public static Biglietto emettiBiglietto(String codUnivoco, Distributore d) {

		if (d.getStato() == StatoDistributore.ATTIVO) {

			try {

				Biglietto b = new Biglietto();

				b.setCodUnivoco(codUnivoco);
				b.setPuntoVendita(d);
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
		} else 
		{ System.out.println("Distributore inattivo");
			return null;
		}
	}
}
