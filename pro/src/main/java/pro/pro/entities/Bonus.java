package pro.pro.entities;

public class Bonus {
private int id_bonus;
public int getId_bonus() {
	return id_bonus;
}
public void setId_bonus(int id_bonus) {
	this.id_bonus = id_bonus;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getLien_youtube() {
	return lien_youtube;
}
public void setLien_youtube(String lien_youtube) {
	this.lien_youtube = lien_youtube;
}
private String description;
private String lien_youtube;
public Bonus(int id_bonus, String description, String lien_youtube) {
	super();
	this.id_bonus = id_bonus;
	this.description = description;
	this.lien_youtube = lien_youtube;
}

}
