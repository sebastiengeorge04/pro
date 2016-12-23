package pro.pro.test;



import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import pro.pro.daos.ActeurDao;
import pro.pro.daos.ActeurDaoImpl;
import pro.pro.daos.DataSourceProvider;
import pro.pro.entities.Acteur;

public class ActeurDaoTest {

	private ActeurDao acteurDao = new ActeurDaoImpl();

	@Before
	public void initDb() throws Exception {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement stmt = connection.createStatement()) {
			
			// stmt.executeUpdate("DELETE FROM filmssite");
			stmt.executeUpdate("DELETE FROM filmssite");
			stmt.executeUpdate("DELETE FROM acteurssite");
			stmt.executeUpdate("INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES (1,'Stallone','Sylvester','6 juillet 1946','Americaine')");
			stmt.executeUpdate("INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES (2,'Schwarzennegger','Arnold','30 juillet 1947','Americaine')");
			stmt.executeUpdate("INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES (3,'Willis','Bruce','19 mars 1955','Americaine')");
			stmt.executeUpdate("INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES (4,'Van-Damme','Jean Claude','18 octobre 1960','Belge')");
			stmt.executeUpdate("INSERT INTO `acteurssite`(`id_acteur`,`nom`,`prenom`,`date_naissance`,`nationalite`) VALUES (5,'Plusieurs de ces acteurs','','','')");
			
		}
	
	}

	@Test
	public void shouldListActeur() {
		// WHEN
		List<Acteur> acteur = acteurDao.listActeur();
		// THEN
		assertThat(acteur).hasSize(5);
		assertThat(acteur).extracting("id_acteur", "nom","prenom","date_naissance","nationalite").containsOnly(tuple(5, "Plusieurs de ces acteurs","","",""), tuple(4, "Van-Damme","Jean Claude","18 octobre 1960","Belge"),tuple(3,"Willis","Bruce","19 mars 1955","Americaine"),tuple(2,"Schwarzennegger","Arnold","30 juillet 1947","Americaine"),
				tuple(1, "Stallone","Sylvester","6 juillet 1946","Americaine"));
	}
	@Test
	public void shouldGetActeur() {
		// WHEN
		Acteur acteur = acteurDao.getActeur(1);
		// THEN
		assertThat(acteur).isNotNull();
		assertThat(acteur.getId_acteur()).isEqualTo(1);
		assertThat(acteur.getNom()).isEqualTo("Stallone");
	}
	@Test
	public void shouldAddcteur() throws Exception {
		// WHEN
		Acteur acteur = new Acteur(1,"oo","oo","oo","oo");
		acteur = acteurDao.addActeur(acteur);
		// THEN
		assertThat(acteur.getId_acteur()).isNotNull();
		assertThat(acteur.getNom()).isEqualTo("oo");

		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM acteurssite WHERE id_acteur = ?")) {
			stmt.setInt(1, acteur.getId_acteur());
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isTrue();
				assertThat(rs.getInt("id_acteur")).isEqualTo(acteur.getId_acteur());
				assertThat(rs.getString("nom")).isEqualTo("oo");
				assertThat(rs.next()).isFalse();
			}
		}
	}
	@Test
	public void shouldDeleteActeur() throws Exception {
		// WHEN
		Acteur acteur = new Acteur(6,"oo","oo","oo","oo");
		acteur = acteurDao.addActeur(acteur);
		Integer id_acteur=acteur.getId_acteur();
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("DELETE * FROM acteurssite WHERE id_acteur ="+id_acteur)) {
			assertThat(id_acteur).isNull();
		}
			public void shouldUpdateActeur() throws Exception  {
		public void shouldDeleteActeur() throws Exception {
			// WHEN
			Acteur acteur = new Acteur(6,"oo","oo","oo","oo");
			acteur = acteurDao.ModifActeur(acteur);
			Integer id_acteur=acteur.getId_acteur();
			try (Connection connection = DataSourceProvider.getDataSource().getConnection();
					PreparedStatement stmt = connection.prepareStatement("UPDATE * FROM acteurssite SET nom='jacky' WHERE id_acteur =6")) {
				
			}
			assertThat(acteur.getNom()).isEqualTo("jacky");
	}
}
}
