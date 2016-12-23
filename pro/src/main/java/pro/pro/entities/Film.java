package pro.pro.entities;
import pro.pro.entities.Acteur;

public class Film {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Film(Integer id, String name, String release_date,String director,Integer duration, Integer note,
			String summary, Acteur acteur) {
		super();
		this.id = id;
		this.name = name;
		this.release_date = release_date;
		this.director = director;
		this.duration = duration;
		this.note = note;
		this.summary = summary;
		this.acteur=acteur;
	}
	public String getReleaseDate() {
		return release_date;
	}
	public void setReleaseDate(String release_date) {
		this.release_date = release_date;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	public Acteur getActeur() {
		return acteur;
	}
	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}
	private String name;
	private String release_date;
	private Integer duration;
	private String director;
	private String summary;
	private Integer note;
	private Acteur acteur;
	
}