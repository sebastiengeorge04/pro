package pro.pro.test;

import static org.assertj.core.api.Assertions.assertThat;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import pro.pro.daos.DataSourceProvider;
import pro.pro.daos.FilmDao;
import pro.pro.daos.impl.FilmDaoMockImpl;
import pro.pro.entities.Film;


public class FilmDaoTest {
	private FilmDao filmDao = new FilmDaoMockImpl();

	@Before
	public void initDb() throws Exception {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement stmt = connection.createStatement()) {
			stmt.executeUpdate("DELETE FROM filmssite");
			stmt.executeUpdate("DELETE FROM acteurssite");
			stmt.executeUpdate("INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES (1,'Stallone','Sylvester','6 juillet 1946','Americaine')");
			stmt.executeUpdate("INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES (5,'Plusieurs de ces acteurs','','','')");
	
			stmt.executeUpdate(
					"INSERT INTO `filmssite`(`id`,`name`,`release_date`,`director` ,`duration`,`note`,`summary`,`acteur`) "
							+ "VALUES (1,'Expendables','2010','Stallone',110,3,'Unite speciale qui tire sur tout ce qui bouge et dit des blagues beaufs',5)");
			stmt.executeUpdate(
					"INSERT INTO `filmssite`(`id`,`name`, `release_date`, `director` , `duration`,`note`,`summary`,`acteur`) "
							+ "VALUES (2,'Rocky','1976','Avildsen',120,5,'Boxeur meconnu qui devient une legende',1)");

		}
}
	@Test
	public void shouldListFilm() {
		// WHEN
		List<Film> films = filmDao.listFilms();
		// THEN
		Assertions.assertThat(films).hasSize(4);
		Assertions.assertThat(films).extracting("id", "name", "release_date", "director", "duration","note","summary", "acteurssite.id_acteur","acteurssite.nom","acteurssite.prenom","acteurssite.date_naissance","acteurssite.nationalite").containsOnly(
			Assertions.tuple(1, "Expendables", "2010", "Stallone", 110, 3, "Unite speciale qui tire sur tout ce qui bouge et dit des blagues beaufs", 5,"Plusieurs de ces acteurs","","",""),
			Assertions.tuple(2, "Rocky", "1976", "Avildsen", 120, 5, "Boxeur meconnu qui devient une legende", 1,"Stallone","Sylvester","6 juillet 1946","Americaine")
		
		);
		
	
	}
	@Test
	public void shouldgetFilm() {
		// TODO Auto-generated method stub
		Film film = filmDao.getFilm(1);
		// THEN
		Assertions.assertThat(film).isNotNull();
		Assertions.assertThat(film.getId()).isEqualTo(1);
		Assertions.assertThat(film.getName()).isEqualTo("Expendables");
		Assertions.assertThat(film.getReleaseDate()).isEqualTo("2010");
		Assertions.assertThat(film.getDirector()).isEqualTo("Stallone");
		Assertions.assertThat(film.getDuration()).isEqualTo(110);
		Assertions.assertThat(film.getSummary()).isEqualTo("Unite speciale qui tire sur tout ce qui bouge et dit des blagues beaufs");
		Assertions.assertThat(film.getActeur()).isEqualTo("5");
	}
	}

	

