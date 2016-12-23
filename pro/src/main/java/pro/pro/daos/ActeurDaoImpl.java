package pro.pro.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pro.pro.entities.Acteur;

public class ActeurDaoImpl implements ActeurDao {
	
	
	public List<Acteur> listActeur() {
		String query = "SELECT * FROM acteurssite ORDER BY id_acteur";
		List<Acteur> acteurs = new ArrayList<>(); 
		try (Connection connection =  DataSourceProvider.getDataSource().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while(resultSet.next()) {
						
						Acteur acteur = new Acteur(resultSet.getInt("id_acteur"), resultSet.getString("nom"), 
								resultSet.getString("prenom"),resultSet.getString("date_naissance"), resultSet.getString("nationalite"));
						acteurs.add(acteur);
					}
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acteurs;
	}

	@Override
	public Acteur getActeur(Integer id_acteur) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM acteurssite WHERE id_acteur = ?")) {
				statement.setInt(1, id_acteur);
				try (ResultSet resultSet = statement.executeQuery()) {
					if(resultSet.next()) {
						
						return  new Acteur(resultSet.getInt("id_acteur"), resultSet.getString("nom"), 
								resultSet.getString("prenom"),resultSet.getString("date_naissance"), resultSet.getString("nationalite"));
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Acteur addActeur(Acteur acteur) {
		// TODO Auto-generated method stub
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			try(PreparedStatement statement = connection.prepareStatement("INSERT INTO acteurssite(nom, prenom, date_naissance,nationalite) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, acteur.getNom());
				statement.setString(2, acteur.getPrenom());
				statement.setString(3, acteur.getDate_naissance());
			
				statement.setString(4, acteur.getNationalite());
				
				statement.executeUpdate();
				
				try (ResultSet resultSet = statement.getGeneratedKeys()) {
					if(resultSet.next()) {
						acteur.setId_acteur(resultSet.getInt(1));
						return acteur;
					}
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
   public Acteur deleteActeur(Integer id_acteur){
	   try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {

		   String sqlQuery = "DELETE FROM acteurssite WHERE id_acteur="+id_acteur;

		   try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

		   statement.executeUpdate();

		   }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return null;
   }

public Acteur ModifActeur(Integer id_acteur) {
	// TODO Auto-generated method stub
	   try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {

		   String sqlQuery = "UPDATE acteurssite SET nom='Depardieu', prenom='Gerard', date_naissance='1900',nationalite='Russe' WHERE id_acteur="+id_acteur;

		   try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
			   

			   int rowsAffected    = statement.executeUpdate(sqlQuery);
			  

		   }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return null;
   }

}




