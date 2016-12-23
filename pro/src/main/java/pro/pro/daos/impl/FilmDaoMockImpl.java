package pro.pro.daos.impl;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import pro.pro.daos.FilmDao;
import pro.pro.entities.Acteur;

import pro.pro.entities.Film;

public class FilmDaoMockImpl implements FilmDao {
	private TreeMap<Integer, Film> filmsList;

	public FilmDaoMockImpl() {
		filmsList = new TreeMap<Integer, Film>();
		filmsList.put(1, new Film(1,"Expendables","2010","Stallone",110,3,"Unite speciale qui tire sur tout ce qui bouge et dit des blagues beaufs",new Acteur(5,"Plusieurs de ces acteurs","","","")));
		filmsList.put(2, new Film(2,"Rocky","1976","Avildsen",120,5,"Boxeur meconnu qui devient une legende",new Acteur(1,"Stallone","Sylvester","6 juillet 1946","Americaine")));
		filmsList.put(3, new Film(3,"Piege de cristal","1988","McTiernan",100,5,"Bruce est coince dans une tour, qui est attaquee par des mechants",new Acteur(3,"Willis","Bruce","19 mars 1955","Americaine")));	
		filmsList.put(4, new Film(4,"Bloodsport","1988","Newt Arnold",92,5,"JC va bastonner des chinois a un tournoi",new Acteur(3,"Van-Damme","Jean Claude","18 octobre 1960","Belge")));
		filmsList.put(4, new Film(5,"Predator","1987","McTiernan",142,5,"Des aliens attaquent Schwarzy mais le bougre est coriace",new Acteur(2,"Schwarzennegger","Arnold","30 juillet 1947","Americaine")));
	}

	public List<Film> listFilms() {
		return new ArrayList<Film>(filmsList.values());
	}

	public Film getFilm(Integer id) {
		return filmsList.get(id);
	}

	public Film addFilm(Film film) {
		Integer id = filmsList.lastKey() + 1;
		film.setId(id);
		filmsList.put(id, film);
		return film;
	}
}
