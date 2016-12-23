package pro.pro.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import pro.pro.entities.Bonus;


public class BonusDaoImpl implements BonusDao{

	@Override
	public List<Bonus> listBonus() {
		// TODO Auto-generated method stub

			String query = "SELECT * FROM bonussite  ORDER BY id_bonus";
			List<Bonus> bonus = new ArrayList<>(); 
			try (Connection connection =  DataSourceProvider.getDataSource().getConnection()) {
				try (Statement statement = connection.createStatement()) {
					try (ResultSet resultSet = statement.executeQuery(query)) {
						while(resultSet.next()) {
							Bonus bonus1 = new Bonus(resultSet.getInt("id_bonus"), resultSet.getString("description"),resultSet.getString("lien_youtube"));
		
					
							bonus.add(bonus1);
						}
					}
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return bonus;
		}
	}


