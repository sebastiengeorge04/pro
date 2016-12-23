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
	
	import pro.pro.manager.FilmLibrary;

	@WebServlet("/addactor")
	public class NewActorServlet extends AbstractGenericServlet{

		private static final long serialVersionUID = 4982865059712541281L;

		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Locale.setDefault(Locale.ENGLISH);
			TemplateEngine templateEngine = this.createTemplateEngine(req);
	        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
	        templateResolver.setCharacterEncoding("UTF-8");
			WebContext context = new WebContext(req, resp, req.getServletContext());
			
			context.setVariable("acteurs", FilmLibrary.getInstance().listActeurs());
		
			templateEngine.process("NewActor", context, resp.getWriter());
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String nom = req.getParameter("nom");
		
			String prenom = req.getParameter("prenom");
			String date_naissance	 = req.getParameter("date_naissance");
			
		
			String nationalite = req.getParameter("nationalite");
	
			
			
			System.out.println(" name" + nom);
	        System.out.println("prenom" + prenom);
	        System.out.println("date_naissance" + date_naissance);
	        System.out.println("nationalite" +nationalite);
	        
	        
			Acteur newActor= new Acteur(null,nom,prenom,date_naissance,nationalite);
			Acteur addedActor=FilmLibrary.getInstance().addActeur(newActor);
	
			
			
			  PrintWriter writer = resp.getWriter();
		         
		        // build HTML code
		        String htmlRespone = "<html>";
		        htmlRespone += "<h2>Your have uploaded: " + nom + "<br/>";      
		        htmlRespone += "<h2>Your have uploaded: " + prenom + "<br/>";
		        htmlRespone += "</html>";
		         
		      // return response
		      writer.println(htmlRespone);
		}
}
