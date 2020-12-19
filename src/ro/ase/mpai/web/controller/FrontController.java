package ro.ase.mpai.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ro.ase.mpai.vin.FactoryProvider;
import ro.ase.mpai.vin.IAbstractFactory;
import ro.ase.mpai.vin.ITipVin;
import ro.ase.mpai.vin.IVin;
import ro.ase.mpai.vin.Produs;
import ro.ase.mpai.web.model.Client;
import ro.ase.mpai.web.model.Repo;
import ro.ase.mpai.web.repository.ClientRepository;

@WebServlet("/")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emfactory;
	EntityManager entitymanager;
	ClientRepository clientRepo;

	public FrontController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		Client client = new Client.ClientBuilder("Client 1", "Adresa 1", "Localitate 1", "1@email.com").setCNP("19708")
				.setTelefon("0764545").build();
		/*
		 * for (int i=1; i<= 15; i++) { clienti.add(new Client(i, "Client " + i,
		 * "Adresa " + i, "Localitate " + i, i+"@email.com", "072212345"+i)); }
		 */
		emfactory = Persistence.createEntityManagerFactory("web");
		entitymanager = emfactory.createEntityManager();
		clientRepo = new ClientRepository(entitymanager);

		clientRepo.add(client);
	}

	@Override
	public void destroy() {
		entitymanager.close();
		emfactory.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {

		// detalii?cod=1
		case "/detaliiClient":
			afiseazaDetaliiClient(request, response);
			break;
		case "/formAdaugareClient":
			afiseazaFormularAdaugareClient(request, response);
			break;
		case "/adaugaClient":
			adaugaClient(request, response);
			break;
		case "/adaugaVin":
			afiseazaFormularVin(request, response);
			break;
		case "/creeazaProdus":
			creeazaProdus(request, response);
			break;
		case "/metodePlata":
			afiseazaFormularMetodaPlata(request, response);
			break;
		case "/tipMetodaPlata":
			metodePlata(request, response);
			break;
		case "/metodaPlataCard":
			afiseazaFormularMetodaPlataCard(request, response);
			break;
		case "/metodaPlataPayPal":
			afiseazaFormularMetodaPlataPaypal(request, response);
			break;
		default:
			afiseazaFormularAdaugareClient(request, response);
		}

	}

	void afiseazaListaClienti(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. obtinere lista clienti din baza de date
		// 2. transmitere lista catre View (pagina ListaClienti.jsp)
		// 3. redirectionare catre pagina ListaClienti.jsp

		List<Client> lista = clientRepo.getAll();
		request.setAttribute("lista", lista);
		RequestDispatcher dispecer = request.getRequestDispatcher("ListaClienti.jsp");
		dispecer.forward(request, response);
	}

	void afiseazaDetaliiClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. obtinere cod client
		// 2. obtinere client din baza de date, folosind codul primit
		// 3. transmitere client catre View (pagina DetaliiClient.jsp)
		// 4. redirectionare catre pagina DetaliiClient.jsp

		int cod = Integer.valueOf(request.getParameter("cod"));
		Client client = clientRepo.get(cod);
		request.setAttribute("client", client);
		RequestDispatcher dispecer = request.getRequestDispatcher("DetaliiClient.jsp");
		dispecer.forward(request, response);

	}

	void afiseazaFormularAdaugareClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispecer = request.getRequestDispatcher("AdaugaClient.jsp");
		dispecer.forward(request, response);
	}

	void afiseazaFormularVin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispecer = request.getRequestDispatcher("AdaugaVin.jsp");
		dispecer.forward(request, response);
	}

	void afiseazaFormularMetodaPlata(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setAttribute("metodaPlata", "card");
		RequestDispatcher dispecer = request.getRequestDispatcher("MetodePlata.jsp");
		dispecer.forward(request, response);
	}

	void afiseazaFormularMetodaPlataCard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispecer = request.getRequestDispatcher("MetodaPlataCard.jsp");
		dispecer.forward(request, response);
	}

	void afiseazaFormularMetodaPlataPaypal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispecer = request.getRequestDispatcher("MetodaPlataPayPal.jsp");
		dispecer.forward(request, response);
	}

	void adaugaClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. preluare valori cimpuri formular
		// 2. creare obiect client
		// 3. salvare obiect client in baza de date
		// 3. redirectionare catre pagina ListaClienti.jsp
		String CNP = request.getParameter("cnp");
		String denumire = request.getParameter("denumire");
		String adresa = request.getParameter("adresa");
		String localitate = request.getParameter("localitate");
		String telefon = request.getParameter("telefon");
		String email = request.getParameter("email");

		Client client = new Client.ClientBuilder(denumire, adresa, localitate, email).setTelefon(telefon).setCNP(CNP)
				.build();
		clientRepo.add(client);
		response.sendRedirect("adaugaVin");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Path venit: " + request.getPathInfo());
		System.out.println("culoare: " + request.getParameter("culoare"));
		System.out.println("tip: " + request.getParameter("tip"));
		doGet(request, response);
	}

	void metodePlata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String metodaPlata = request.getParameter("metodaPlata");
		System.out.println("Parametrii card"+ metodaPlata) ;
		if (metodaPlata.equalsIgnoreCase("card")) {
			response.sendRedirect("metodaPlataCard");
		} else {
			response.sendRedirect("metodaPlataPayPal");
		}
	}

	void creeazaProdus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Intrat in creare produs method");
		Produs p = new Produs();
		try {

			String culoare = request.getParameter("culoare");
			String tip = request.getParameter("tip");
			IAbstractFactory vinFactory;
			IAbstractFactory tipVinFactory;

			/*
			 * int flag = 0; while (flag == 0) { if (culoare.equals("Alb") == true ||
			 * culoare.equals("Rosu") == true || culoare.equals("Rose") == true) { flag++; }
			 * else {
			 * System.out.println("Reintroduceti culoare vinului: Alb, Rosu sau Rose...");
			 * culoare = scanner.next(); } }
			 */

			switch (culoare) {
			case "Alb":
				vinFactory = FactoryProvider.getFactory("Vin");
				IVin vinAlb = (IVin) vinFactory.create(culoare);
				p.denumire = vinAlb.getVin();
				break;
			case "Rosu":
				vinFactory = FactoryProvider.getFactory("Vin");
				IVin vinRosu = (IVin) vinFactory.create(culoare);
				p.denumire = vinRosu.getVin();
				break;
			case "Rose":
				vinFactory = FactoryProvider.getFactory("Vin");
				IVin vinRose = (IVin) vinFactory.create(culoare);
				p.denumire = vinRose.getVin();
				break;
			default:
				System.out.println("Ai introdus o culoare incorecta...");
			}

// Verificam daca tipul vinului introdus este cel corespunzator
			/*
			 * flag = 0; while (flag == 0) { if (tip.equals("Sec") == true ||
			 * tip.equals("DemiSec") == true || tip.equals("Dulce") == true ||
			 * tip.equals("DemiDulce") == true) { flag++; } else { System.out.
			 * println("Reintroduceti tipul vinului: Sec, DemiSec, Dulce sau DemiDulce...");
			 * tip = scanner.next(); } }
			 */

// Creem tipul vinului corespunzator introdus
			switch (tip) {
			case "Sec":
				vinFactory = FactoryProvider.getFactory("Tip");
				ITipVin vinSec = (ITipVin) vinFactory.create(tip);
				p.caracteristici = vinSec.getTipVin();
				break;
			case "DemiSec":
				vinFactory = FactoryProvider.getFactory("Tip");
				ITipVin vinDemiSec = (ITipVin) vinFactory.create(tip);
				p.caracteristici = vinDemiSec.getTipVin();
				break;
			case "Dulce":
				vinFactory = FactoryProvider.getFactory("Tip");
				ITipVin vinDulce = (ITipVin) vinFactory.create(tip);
				p.caracteristici = vinDulce.getTipVin();
				break;
			case "DemiDulce":
				vinFactory = FactoryProvider.getFactory("Tip");
				ITipVin vinDemiDulce = (ITipVin) vinFactory.create(tip);
				p.caracteristici = vinDemiDulce.getTipVin();
				break;
			}

			System.out.println("Produsul este: " + p.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("metodePlata");
	}

}
