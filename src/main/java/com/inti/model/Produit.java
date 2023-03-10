package com.inti.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String reference;
	private String prix;
	private String poids;
	
	@ManyToMany
	@JoinTable(name="Magasin_Produit",
    joinColumns = @JoinColumn(name="idP"),
    inverseJoinColumns = @JoinColumn(name="idM"))
	private List<Magasin> listeMagasin;
	
	public Produit() {
		super();
	}
	public Produit(String nom, String reference, String prix, String poids) {
		super();
		this.nom = nom;
		this.reference = reference;
		this.prix = prix;
		this.poids = poids;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getPoids() {
		return poids;
	}
	public void setPoids(String poids) {
		this.poids = poids;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", reference=" + reference + ", prix=" + prix + ", poids=" + poids
				+ "]";
	}

}
