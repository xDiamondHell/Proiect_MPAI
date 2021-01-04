package ro.ase.mpai.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ro.ase.mpai.platiStrategy.Card;
import ro.ase.mpai.platiStrategy.Paypal;
import ro.ase.mpai.platiStrategy.ShoppingCart;
import ro.ase.mpai.vin.FactoryProvider;
import ro.ase.mpai.vin.IAbstractFactory;
import ro.ase.mpai.vin.ITipVin;
import ro.ase.mpai.vin.IVin;
import ro.ase.mpai.vin.Produs;
import ro.ase.mpai.web.model.Client;
import ro.ase.mpai.web.model.Client.ClientBuilder;
import ro.ase.mpai.web.model.Comanda;
import ro.ase.mpai.web.model.MetodaPlata;
import ro.ase.mpai.web.repository.ClientRepository;
import ro.ase.mpai.web.repository.ComandaRepository;

@WebServlet("/")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emfactory;
	EntityManager entitymanager;
	ClientRepository clientRepo;
	ComandaRepository comandaRepo;
	public static int clientID;

	public FrontController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		/*
		 * for (int i=1; i<= 15; i++) { clienti.add(new Client(i, "Client " + i,
		 * "Adresa " + i, "Localitate " + i, i+"@email.com", "072212345"+i)); }
		 */

		emfactory = Persistence.createEntityManagerFactory("web");
		entitymanager = emfactory.createEntityManager();
		clientRepo = new ClientRepository(entitymanager);
		comandaRepo = new ComandaRepository(entitymanager);
//		Comanda c1 = new Comanda(new Client.ClientBuilder("Client 1", "Adresa 1", "Localitate 1", "1@email.com")
//				.setCNP("19706614430025").setTelefon("0764545").build(), new MetodaPlata("card"));
//		comandaRepo.add(c1);
//		
//		Comanda c2 = new Comanda(new Client.ClientBuilder("Client 1", "Adresa 1", "Localitate 1", "nastase.victor@yahoo.com")
//				.setCNP("19706614430025").setTelefon("0764545").build(), new MetodaPlata("card"));
//		comandaRepo.add(c2);

//		System.out.println(c1.getId() + " " + c1.getClient().getDenumire() + " " + c1.getMetodaPlata().getDenumire());
//		System.out.println(c1.toString());

//		System.out.println(comandaRepo.getClientOrdersByEmail("nastase.victor@yahoo.com").toString());
//		System.out.println(entitymanager.find(Comanda.class, 1).toString());

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

		case "/afiseazaListaClienti":
			afiseazaListaClienti(request, response);
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
		case "/actualizeazaClient":
			actualizeazaClient(request, response);
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
		case "/plaseazaComandaCard":
			plaseazaComandaCard(request, response);
			break;
		case "/plaseazaComandaPayPal":
			plaseazaComandaPayPal(request, response);
			break;
		default:
			afiseazaFormularVin(request, response);
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

	String extragereSumaDePlataDinCookies(HttpServletRequest request) {
		return Arrays.asList(request.getCookies()).stream().filter(x -> x.getName().equals("sumaDePlata")).map(x -> x.getValue()).collect(Collectors.joining());
	}
	void afiseazaFormularMetodaPlataCard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sumaDePlata = extragereSumaDePlataDinCookies(request);
		System.out.println("Suma de plata este: " + sumaDePlata);
		HttpSession session = request.getSession();
		request.setAttribute("sumaDePlata", sumaDePlata);
		RequestDispatcher dispecer = request.getRequestDispatcher("MetodaPlataCard.jsp");
		dispecer.forward(request, response);
	}

	void afiseazaFormularMetodaPlataPaypal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sumaDePlata = extragereSumaDePlataDinCookies(request);
		System.out.println("Suma de plata este: " + sumaDePlata);
		request.setAttribute("sumaDePlata", sumaDePlata);
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

		HttpSession session = request.getSession();
		session.setAttribute("CNP", CNP);
		session.setAttribute("denumire", denumire);
		session.setAttribute("adresa", adresa);
		session.setAttribute("localitate", localitate);
		session.setAttribute("telefon", telefon);
		session.setAttribute("email", email);
		String sumaDePlata = extragereSumaDePlataDinCookies(request);
		System.out.println("Suma de plata este: " + sumaDePlata);
		session.setAttribute("sumaDePlata", sumaDePlata);

		String CNPClient = (String) session.getAttribute("CNP");
		String denumireClient = (String) session.getAttribute("denumire");
		String adresaClient = (String) session.getAttribute("adresa");
		String localitateClient = (String) session.getAttribute("localitate");
		String telefonClient = (String) session.getAttribute("telefon");
		String emailClient = (String) session.getAttribute("email");

		System.out.println(CNPClient + " " + denumireClient + " " + adresaClient + " " + localitateClient + " " + " "
				+ telefonClient + " " + emailClient);
//				
//		Client client = new Client.ClientBuilder(denumireClient, adresaClient, localitateClient, emailClient).setTelefon(telefonClient).setCNP(CNPClient)
//				.build();
//		clientRepo.add(client);
//		FrontController.clientID = client.getCod();
		response.sendRedirect("metodePlata");
//		System.out.println("Clientul cu datele: " + client.getDenumire() + ", " + client.getAdresa() + ", "
//				+ client.getLocalitate() + ", " + client.getCNP() + ", " + client.getTelefon() + ", "
//				+ client.getEmail() + " a fost creat");

	}

	void actualizeazaClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * Datele care vin de pe formularul detalii client
		 */
		System.out.println("Ajuns in actualizeaza client");
		int cod = Integer.parseInt(request.getParameter("id"));
		System.out.println(cod);
		Client client = clientRepo.get(cod);
		String CNP = request.getParameter("cnp");
		String denumire = request.getParameter("denumire");
		String adresa = request.getParameter("adresa");
		String localitate = request.getParameter("localitate");
		String telefon = request.getParameter("telefon");
		String email = request.getParameter("email");
		client.setCNP(CNP);
		client.setAdresa(adresa);
		client.setDenumire(denumire);
		client.setTelefon(telefon);
		client.setLocalitate(localitate);
		client.setEmail(email);
		System.out.println("Ajuns in actualizeaza client 123");
//		request.setAttribute("client", client);
//		RequestDispatcher dispecer = request.getRequestDispatcher("DetaliiClient.jsp");
//		dispecer.forward(request, response);
		System.out.println("Clientul cu datele: " + client.getDenumire() + ", " + client.getAdresa() + ", "
				+ client.getLocalitate() + ", " + client.getCNP() + ", " + client.getTelefon() + ", "
				+ client.getEmail() + " a fost actualizat");
		clientRepo.update(client);
		// TODO cum redirectionam pe lista clienti sau detalii
		response.sendRedirect("afiseazaListaClienti");
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Path venit: " + request.getPathInfo());
		System.out.println("culoare: " + request.getParameter("culoare"));
		System.out.println("tip: " + request.getParameter("tip"));
		doGet(request, response);
	}

	void metodePlata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String metodaPlata = request.getParameter("metodaPlata");
		System.out.println("Metoda de plata aleasa " + metodaPlata);
		System.out.println("Id client " + FrontController.clientID);

		if (metodaPlata.equalsIgnoreCase("card")) {
			session.setAttribute("metodaPlata", "card");

			response.sendRedirect("metodaPlataCard");
		} else if (metodaPlata.equalsIgnoreCase("paypal")) {
			session.setAttribute("metodaPlata", "paypal");

//			Client client = new Client.ClientBuilder(denumireClient, adresaClient, localitateClient, emailClient).setTelefon(telefonClient).setCNP(CNPClient)
//					.build();
//			clientRepo.add(client);			
//			Comanda c1 = new Comanda(client, new MetodaPlata("paypal"));
//			comandaRepo.add(c1);	
//			System.out.println(c1.toString());
			response.sendRedirect("metodaPlataPayPal");
		}
	}

	void plaseazaComandaCard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String cardNumber = request.getParameter("cardNumber");
		String carholderName = request.getParameter("carholderName");
		String expiryDate = request.getParameter("expiryDate");
		String cvc = request.getParameter("cvc");

		String CNPClient = (String) session.getAttribute("CNP");
		String denumireClient = (String) session.getAttribute("denumire");
		String adresaClient = (String) session.getAttribute("adresa");
		String localitateClient = (String) session.getAttribute("localitate");
		String telefonClient = (String) session.getAttribute("telefon");
		String emailClient = (String) session.getAttribute("email");
		String metodaPlataClient = (String) session.getAttribute("metodaPlata");

		int sumaDePlata = Integer.valueOf((String) session.getAttribute("sumaDePlata"));
		System.out.println("Suma de plata: " + sumaDePlata);
		ShoppingCart cosCumparaturi = new ShoppingCart();
		
		System.out.println(CNPClient + " " + denumireClient + " " + adresaClient + " " + localitateClient + " " + " "
				+ telefonClient + " " + emailClient + " " + metodaPlataClient);

		Client client = new Client.ClientBuilder(denumireClient, adresaClient, localitateClient, emailClient)
				.setTelefon(telefonClient).setCNP(CNPClient).build();
		System.out.println(client.toString());
		MetodaPlata metodaPlata1 = new MetodaPlata("card");
		cosCumparaturi.plata(new Card(cardNumber, carholderName, expiryDate, cvc), sumaDePlata);
		System.out.println(metodaPlata1.toString());
		Comanda c1 = new Comanda(client, metodaPlata1);
		System.out.println(c1.toString());
		clientRepo.add(client);
		comandaRepo.add(c1);
		response.sendRedirect("afiseazaListaClienti");
	}

	void plaseazaComandaPayPal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		String CNPClient = (String) session.getAttribute("CNP");
		String denumireClient = (String) session.getAttribute("denumire");
		String adresaClient = (String) session.getAttribute("adresa");
		String localitateClient = (String) session.getAttribute("localitate");
		String telefonClient = (String) session.getAttribute("telefon");
		String emailClient = (String) session.getAttribute("email");
		String metodaPlataClient = (String) session.getAttribute("metodaPlata");
		int sumaDePlata = Integer.valueOf((String) session.getAttribute("sumaDePlata"));
		System.out.println("Suma de plata: " + sumaDePlata);
//		String CNP = clientRepo.getClientByEmail(emailClient).getCNP();
//		String numeClient = clientRepo.getClientByEmail(emailClient).getDenumire();
//		String adresaObiectClient = clientRepo.getClientByEmail(emailClient).getAdresa();
//		String localitateObiectClient = clientRepo.getClientByEmail(emailClient).getLocalitate();
//		String emailObiectClient = clientRepo.getClientByEmail(emailClient).getEmail();
//		String telefonObiectClient = clientRepo.getClientByEmail(emailClient).getTelefon();

		ShoppingCart cosCumparaturi = new ShoppingCart();
		if (clientRepo.get(clientRepo.getClientByEmail(emailClient).getCod()) != null) {

//			System.out.println(CNPClient + " " + denumireClient + " " + adresaClient + " " + localitateClient + " "
//					+ " " + telefonClient + " " + emailClient + " " + metodaPlataClient);
			
			MetodaPlata metodaPlata1 = new MetodaPlata("paypal");
			System.out.println(metodaPlata1.toString());
			cosCumparaturi.plata(new Paypal(email, password), sumaDePlata);
			Comanda c1 = new Comanda(clientRepo.get(clientRepo.getClientByEmail(emailClient).getCod()), metodaPlata1);
			System.out.println(c1.toString());
			comandaRepo.getClientOrdersByEmail(emailClient);
			comandaRepo.add(c1);
			response.sendRedirect("afiseazaListaClienti");
		} else {
			Client client = new Client.ClientBuilder(denumireClient, adresaClient, localitateClient, emailClient)
					.setTelefon(telefonClient).setCNP(CNPClient).build();
			System.out.println(client.toString());
			MetodaPlata metodaPlata1 = new MetodaPlata("paypal");
			System.out.println(metodaPlata1.toString());
			cosCumparaturi.plata(new Paypal(email, password), sumaDePlata);
			Comanda c1 = new Comanda(client, metodaPlata1);
			System.out.println(c1.toString());
			clientRepo.add(client);
			comandaRepo.add(c1);
			response.sendRedirect("afiseazaListaClienti");
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
		response.sendRedirect("formAdaugareClient");
	}

}
