package pro.pro.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import pro.pro.daos.ActeurDaoImpl;
import pro.pro.entities.Acteur;

import pro.pro.manager.FilmLibrary;

@WebServlet("/modif")
public class ModifActeurServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 4982865059712541281L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		context.setVariable("acteurs", FilmLibrary.getInstance().listActeurs());
	
		templateEngine.process("ModifActeur",context,resp.getWriter());
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id_acteur = Integer.parseInt(req.getParameter("id_acteur"));
		String nom=req.getParameter("nom");
		String prenom=req.getParameter("prenom");
		String date_naissance=req.getParameter("date_naissance");
		String nationalite=req.getParameter("nationalite");
	    
	
		ActeurDaoImpl acteurDao = new ActeurDaoImpl();

		acteurDao.ModifActeur(id_acteur);
		
		System.out.println("acteur" + id_acteur);
		System.out.println("nom"+nom);
		
		  PrintWriter writer = resp.getWriter();
	         
	        // build HTML code
	        String htmlRespone = "<html>";
	        htmlRespone += "<h2>Your have uploaded the actor n�: " + id_acteur + "<br/>";      
	        htmlRespone += "<h2>With name : "+ nom +"<br/>";
	      
	        htmlRespone += "</html>";
	         
	      // return response
	      writer.println(htmlRespone);
}
}