package org.ensah.domains;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professeur {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	private String email;
	@OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
	private List<Absence> lesAbsences;
	@OneToMany(mappedBy="professeur",cascade=CascadeType.ALL)
	private List<Affectation> lesAffectations;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Absence> getLesAbsences() {
		return lesAbsences;
	}
	public void setLesAbsences(List<Absence> lesAbsences) {
		this.lesAbsences = lesAbsences;
	}
	public List<Affectation> getLesAffectations() {
		return lesAffectations;
	}
	public void setLesAffectations(List<Affectation> lesAffectations) {
		this.lesAffectations = lesAffectations;
	}
	
}
