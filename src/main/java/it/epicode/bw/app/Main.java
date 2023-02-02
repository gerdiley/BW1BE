package it.epicode.bw.app;
import java.time.LocalDate;
import java.util.Scanner;
import it.epicode.bw.dao.DistributoreDAO;
import it.epicode.bw.dao.PuntoVenditaDAO;
import it.epicode.bw.dao.TesseraDAO;
import it.epicode.bw.dao.UtenteDAO;
import it.epicode.bw.models.Abbonamento;
import it.epicode.bw.models.Biglietto;
import it.epicode.bw.models.Distributore;
import it.epicode.bw.models.DurataAbbonamento;
import it.epicode.bw.models.PuntoVendita;
import it.epicode.bw.models.Rivenditore;
import it.epicode.bw.models.StatoDistributore;
import it.epicode.bw.models.Tessera;
import it.epicode.bw.models.Utente;

public class Main {

	// ------CREO NUOVO PUNTO VENDITA------
	static PuntoVendita riv = new Rivenditore();

	static Distributore dis = new Distributore();

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		PuntoVenditaDAO.save(riv);
		
		System.out.println("rivenditore disponibile n: " + riv.getId());
		
		dis.setStato(StatoDistributore.ATTIVO);

		PuntoVenditaDAO.save(dis);
		
		System.out.println("distributore disponibile n: " + dis.getId());

		int scelta;
		do {
			System.out.printf("Scegli operazione : %n"
							+ "1 - Crea nuova tessera %n"
							+ "2 - Acquista un biglietto %n"
							+ "3 - Verifica biglietti venduti %n"
							+ "4 - Verifica biglietti venduti per periodo %n"
							+ "5 - Verifica validita abbonamento %n"
							+ "6 - Rinnova tessera %n");

			scelta = Integer.parseInt(in.nextLine());

			switch (scelta) {
			case 1:
				addTessera();
				break;
			case 2:
				acquistoBiglietto();
				break;
			case 3:
				getBigliettiVenduti();
				break;
			case 4:
				getByDate();
				break;
			case 5:
				verificaValidita();
				break;
			case 6:
				rinnovaTessera();
				break;
			default:

				break;
			}
		} while (scelta != 0);

		// ISTANZA MEZZO
//        MezzoTrasporto m1 = new MezzoTrasporto(StatoMezzo.InSERVIZIO, null, null, LocalDate.now(), LocalDate.now().plusDays(1), 0, TipoMezzo.AUTOBUS, null);
//        ParcoMezziDAO.save(m1);
////         ISTANZA BIGLIETTO
//        TitoloViaggio b1 = PuntoVenditaDAO.emettiBiglietto("20", riv1);
//        TitoloViaggio b2 = PuntoVenditaDAO.emettiBiglietto("22", riv1);
////        STAMPA STATO DI VALIDITA
//        System.out.println(b1.isConvalida());
//        System.out.println(b2.isConvalida());
////        VALIDAZIONE
//        ParcoMezziDAO.vidimazione(b1, m1);
//        ParcoMezziDAO.vidimazione(b2, m1);
////        STAMPA STATO DI VALIDITA DOPO LA VALIDAZIONE
//        System.out.println(b1.isConvalida());
//        System.out.println(m1.getNumeroBiglietti()); 
	}

	// COUNTER TESSERA
	private static long idCounter = 1;

	public static synchronized String createID() {
		return String.valueOf(idCounter++);
	}

	// COUNTER TESSERA
	private static long idCounterBiglietto = 1;

	public static synchronized String createIDBiglietto() {
		return String.valueOf(idCounterBiglietto++);
	}

	// -----------------ADD TESSERA-------------------------------
	public static void addTessera() {

		// -------------CREO NUOVO UTENTE--------------
		System.out.println("Inserisci il tuo nome: ");
		String nome = in.nextLine();

		System.out.println("Inserisci il tuo cognome: ");
		String cognome = in.nextLine();

		Utente u = new Utente();
		u.setCognome(cognome);
		u.setNome(nome);

		UtenteDAO.save(u);

		// ------CREO NUOVA TESSERA---------------------

		Tessera t1 = new Tessera();
		t1.setCodTessera(createID());
		t1.setDataEmissione(LocalDate.now());
		t1.setUtente(u);

		TesseraDAO.save(t1);
		System.out.println("Codice tessera: " + t1.getCodTessera());
		System.out.println("Intestatario: " + u.getNome() + " " + u.getCognome());

		// ----------ACQUISTO ABBONAMENTO-----------------

		int scelta;
		do {
			System.out.printf("Scegli operazione : %n" + "1 - Acquista abbonamento %n" + "0 - Termina operazione %n");
			scelta = Integer.parseInt(in.nextLine());

			switch (scelta) {
			case 1:
				System.out.printf("Scegli tipo Abbonamento : %n" + "1 - MENSILE %n" + "2 - SETTIMANALE %n");
				int scelta1 = Integer.parseInt(in.nextLine());

				switch (scelta1) {
				case 1:
					Abbonamento a = PuntoVenditaDAO.emettiAbbonamento(createIDBiglietto(), riv,
							DurataAbbonamento.MENSILE, t1);
					System.out.println("Hai acquistato l'abbonamento MENSILE con numero  " + a.getCodUnivoco());
					break;
				case 2:
					Abbonamento a1 = PuntoVenditaDAO.emettiAbbonamento(createIDBiglietto(), riv,
							DurataAbbonamento.SETTIMANALE, t1);
					System.out.println("Hai acquistato l'abbonamento SETTIMANALE con numero  " + a1.getCodUnivoco());
					break;
				default:
					System.out.println("Inserire numero valido");
				}
			}
		} while (scelta != 0);

	}

	// -----------------ACQUISTO BIGLIETTO---------------------
	public static void acquistoBiglietto() {

		int scelta;
		do {
			System.out.printf("Scegli dove acquistare il biglietto: %n" + "1 - Rivenditore %n" + "2 - Distributore %n"
					+ "0 - Termina operazione %n");

			scelta = Integer.parseInt(in.nextLine());

			switch (scelta) {
			case 1:
				Biglietto r = PuntoVenditaDAO.emettiBiglietto(createIDBiglietto(), riv);
				System.out.println("Codice biglietto " + r.getCodUnivoco());
				break;
			case 2:
				Biglietto d = DistributoreDAO.emettiBiglietto(createIDBiglietto(), dis);
				System.out.println("Codice biglietto " + d.getCodUnivoco());
				break;
			}
		} while (scelta != 0);

	}
	//	-----------------GET BIGLIETTI VENDUTI PER PUNTO VENDITA-------------------
	
	private static void getBigliettiVenduti() {
		int id;
		do {
			System.out.println("Inserire l'id del Punto vendita :");
			
			id = Integer.parseInt(in.nextLine());
			PuntoVenditaDAO.getBigliettiVenduti(id);
			
		} while(id!=0);
	};
	
//	-----------------GET BIGLIETTI VENDUTI PER PERIODO-------------------
	
	private static void getByDate() {
		String data1;
		String data2;
		
		do {
			System.out.println("Inserire una data di inizio periodo (YYYY-MM-DD): ");
			data1 = in.nextLine();
			System.out.println("Inserire una data di fine periodo (YYYY-MM-DD): ");
			data2 = in.nextLine();
			
			PuntoVenditaDAO.getBigliettiPeriodo(LocalDate.parse(data1), LocalDate.parse(data2));
		} while(data1 != "0" );
	}
	
//	-----------------VERIFICA VALIDITA ABBONAMENTO-------------------
	
	private static void verificaValidita() {
		String id;
		do {
			System.out.println("Inserire il codice abbonamento");
			id = in.nextLine();
			
			PuntoVenditaDAO.isValid(id);
			
		}
		while(id!="0");
	};
	
	
//	-----------------RINNOVA TESSERA------------------------------
	
	private static void rinnovaTessera() {
		String codice;
		do {
			System.out.println("Inserire il codice tessera");
			codice = in.nextLine();
			TesseraDAO.rinnova(codice);
		}
		while(codice!="0");
	}

}
