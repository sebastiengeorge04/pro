package pro.pro.daos;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import java.sql.Connection;
import java.sql.PreparedStatement;


import pro.pro.daos.DataSourceProvider;
import pro.pro.daos.FilmDao;
import pro.pro.entities.Acteur;

import pro.pro.entities.Film;





public class FilmDaoImpl implements FilmDao{

	@Override
	public List<Film> listFilms() {
		String query = "SELECT * FROM filmssite JOIN acteurssite ON filmssite.acteur = acteurssite.id_acteur ORDER BY id";
		List<Film> films = new ArrayList<>(); 
		try (Connection connection =  DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						Acteur acteur = new Acteur(resultSet.getInt("id_acteur"), resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("date_naissance"),resultSet.getString("nationalite"));
	
						Film film = new Film(resultSet.getInt("id"), resultSet.getString("name"), 
								resultSet.getString("release_date"),resultSet.getString("director"), resultSet.getInt("duration"), 
								resultSet.getInt("note"), resultSet.getString("summary"),acteur);
						films.add(film);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public Film getFilm(Integer id) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM filmssite JOIN acteurssite ON filmssite.acteur = acteurssite.id_acteur WHERE id = ?")) {
				statement.setInt(1, id);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						
						Acteur acteur = new Acteur(resultSet.getInt("id_acteur"), resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("date_naissance"),resultSet.getString("nationalite"));
						return  new Film(resultSet.getInt("id"), resultSet.getString("name"), 
								resultSet.getString("release_date"),resultSet.getString("director"), resultSet.getInt("duration"), 
								resultSet.getInt("note"), resultSet.getString("summary"),acteur);
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Film addFilm(Film film) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO filmssite(name, release_date, director, duration, note, summary, acteur) VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, film.getName());
				statement.setString(2, film.getReleaseDate());
				statement.setString(3, film.getDirector());
				statement.setInt(4, film.getDuration());
				statement.setInt(5, film.getNote());
				statement.setString(6, film.getSummary());
				statement.setInt(7, film.getActeur().getId_acteur());
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						film.setId(resultSet.getInt(1));
						return film;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

