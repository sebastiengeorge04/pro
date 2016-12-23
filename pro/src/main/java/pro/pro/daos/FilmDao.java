package pro.pro.daos;

import java.util.List;


import pro.pro.entities.Film;

	public interface FilmDao {
		public List<Film> listFilms();

		public Film getFilm(Integer id);

		public Film addFilm(Film film);
	}


