package pro.pro.manager;

import java.util.List;

import pro.pro.daos.FilmDao;
import pro.pro.daos.FilmDaoImpl;
import pro.pro.daos.ActeurDao;
import pro.pro.daos.ActeurDaoImpl;
import pro.pro.daos.BonusDao;
import pro.pro.daos.BonusDaoImpl;
import pro.pro.entities.Film;
import pro.pro.entities.Acteur;
import pro.pro.entities.Bonus;


public class FilmLibrary {
	
	private static class FilmLibraryHolder {
		private final static FilmLibrary instance = new FilmLibrary();
	}
	
	public static FilmLibrary getInstance() {
		return FilmLibraryHolder.instance;
	}
	
	private FilmDao filmDao = new FilmDaoImpl();
	private ActeurDao acteurDao=new ActeurDaoImpl();
	private BonusDao bonusDao=new BonusDaoImpl();


	private FilmLibrary() {
	}

	public List<Film> listFilms() {
		return filmDao.listFilms();
	}

	public Film getFilm(Integer id) {
		return filmDao.getFilm(id);
	}

	public Film addFilm(Film film) {
		return filmDao.addFilm(film);
	}
	public Acteur getActeur(Integer id_acteur){
		return acteurDao.getActeur(id_acteur);
	}
	public List<Acteur> listActeurs(){
		return acteurDao.listActeur();
	}
	public Acteur addActeur(Acteur acteur){
		return acteurDao.addActeur(acteur);
	}
    public void deleteActeur(Integer id_acteur){
    	acteurDao.deleteActeur(id_acteur);
    }
    public void ModifActeur(Integer id_acteur){
    	acteurDao.ModifActeur(id_acteur);
    }
    public List<Bonus> listBonus(){
    	return bonusDao.listBonus();
    }
}

