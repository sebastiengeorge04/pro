package pro.pro.daos;

import java.util.List;

import pro.pro.entities.Acteur;

	public interface ActeurDao {
		public List<Acteur> listActeur();

		public Acteur getActeur(Integer id_acteur);

		public Acteur addActeur(Acteur acteur);
		public Acteur deleteActeur(Integer id_acteur);
		public Acteur ModifActeur(Integer id_acteur);
	}