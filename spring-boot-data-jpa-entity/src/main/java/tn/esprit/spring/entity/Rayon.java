package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "Rayon")
public class Rayon implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idRayon")
	private Long idRayon;
	
	@Column(name="code")
	private String code;
	
	@Column(name="libelle")
	private String libelle;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayons")
	private Set<Produit> produits;

	public Rayon() {
		super();
	}

	public Rayon(Long idRayon, String code, String libelle, Set<Produit> produits) {
		super();
		this.idRayon = idRayon;
		this.code = code;
		this.libelle = libelle;
		this.produits = produits;
	}

	public Long getIdRayon() {
		return idRayon;
	}

	public void setIdRayon(Long idRayon) {
		this.idRayon = idRayon;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
