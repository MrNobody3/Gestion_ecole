package org.ensah.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue
	private Long id;
	private String cne;
	private String nom;
	private String prenom;
	private String photo;
	private String sexe;
	@OneToMany(mappedBy="etudiant",cascade=CascadeType.ALL)
	private List<Absence> lesAbsences;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public List<Absence> getLesAbsences() {
		return lesAbsences;
	}
	public void setLesAbsences(List<Absence> lesAbsences) {
		this.lesAbsences = lesAbsences;
	}
	public void addAbsence(Absence absence){
		this.lesAbsences.add(absence);
	}
	
}
