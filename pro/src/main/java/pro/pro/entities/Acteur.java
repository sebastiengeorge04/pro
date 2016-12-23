package pro.pro.entities;

public class Acteur {
private Integer id_acteur;
public Integer getId_acteur() {
	return id_acteur;
}
public void setId_acteur(Integer id_acteur) {
	this.id_acteur = id_acteur;
}
public Acteur(Integer id_acteur, String nom, String prenom,String date_naissance,String nationalite) {
	super();
	this.id_acteur = id_acteur;
	this.nom = nom;
	this.prenom = prenom;
	this.date_naissance = date_naissance;
	this.nationalite = nationalite;

}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getDate_naissance() {
	return date_naissance;
}
public void setDate_naissance(String date_naissance) {
	this.date_naissance = date_naissance;
}
public String getNationalite() {
	return nationalite;
}
public void setNationalite(String nationalite) {
	this.nationalite = nationalite;
}
private String nom;
private String prenom;
private String date_naissance;
private String nationalite;

}
