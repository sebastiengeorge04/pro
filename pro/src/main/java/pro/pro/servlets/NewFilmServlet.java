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

import pro.pro.entities.Acteur;

import pro.pro.entities.Film;
import pro.pro.manager.FilmLibrary;

@WebServlet("/addfilm")
public class NewFilmServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 4982865059712541281L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Locale.setDefault(Locale.ENGLISH);
		TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		context.setVariable("acteurs", FilmLibrary.getInstance().listActeurs());
	
		templateEngine.process("FormFilms", context, resp.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
	
		String releaseDate = req.getParameter("release_date");
		String director	 = req.getParameter("director");
		
		Integer duration = Integer.parseInt(req.getParameter("duration"));
		
		Integer note  = Integer.parseInt(req.getParameter("note"));
		String summary = req.getParameter("summary");
		Integer id_acteur = Integer.parseInt(req.getParameter("id_acteur"));
		Acteur acteur = FilmLibrary.getInstance().getActeur(id_acteur);
	
		
		
		System.out.println("film name" + name);
        System.out.println("release date" + releaseDate);
        System.out.println("director" + director);
        System.out.println("duration" + duration);
        System.out.println("note" + note);
        System.out.println("summary" + summary);
        System.out.println("acteur" + acteur);
       
        
		
		Film newFilm = new Film(null, name, releaseDate, director, duration, note, summary,acteur);
		Film addedFilm = FilmLibrary.getInstance().addFilm(newFilm);
		
		
		  PrintWriter writer = resp.getWriter();
	         
	        // build HTML code
	        String htmlRespone = "<html>";
	        htmlRespone += "<h2>Your have uploaded: " + name + "<br/>";      
	         
	        htmlRespone += "</html>";
	         
	      // return response
	      writer.println(htmlRespone);
	}
}
