package pro.pro.daos.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import pro.pro.daos.ActeurDao;
import pro.pro.entities.Acteur;



public class ActeurDaoMockImpl implements ActeurDao{
	private TreeMap<Integer, Acteur> ActeurList;

	public ActeurDaoMockImpl() {
		
		ActeurList.put(1, new Acteur(1, "Stallone","Sylvester","6juillet 1946","Americaine"));
		ActeurList.put(2, new Acteur(2, "Schwarzennegger", "Arnold", "30 juillet 1947","Americaine"));
		ActeurList.put(3, new Acteur(3, "Willis", "Bruce", "19 mars 1955","Americaine"));
		ActeurList.put(4, new Acteur(4, "Van-Damme", "Jean Claude", "18 octobre 1960","Belge"));
		ActeurList.put(5, new Acteur(5, "Plusieurs de ces acteurs", "", "",""));
	}

	public List<Acteur> listActeur() {
		return new ArrayList<Acteur>(ActeurList.values());
	}

	public Acteur getActeur(Integer id_acteur) {
		return ActeurList.get(id_acteur);
	}

	@Override
	public Acteur addActeur(Acteur acteur) {
		Integer id_acteur = ActeurList.lastKey() + 1;
		acteur.setId_acteur(id_acteur);
		ActeurList.put(id_acteur, acteur);
		return acteur;
	}

	@Override
	public Acteur deleteActeur(Integer id_acteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acteur ModifActeur(Integer id_acteur) {
		// TODO Auto-generated method stub
		return null;
	}

}
