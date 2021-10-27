package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Produit")
public class Produit implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private Long idProduit;
	
	
	@Column(name="code")
	private String code;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="prixUnitaire")
	private Float prixUnitaire;
	
	@OneToOne
	private DetailProduit produitDetail;
	
	@ManyToOne
	Stock stock;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseurs;
	
	@ManyToOne
	Rayon rayons;
	
	@ManyToOne
	detailFacture detailFactures;

	public Produit() {
		super();
	} 

	public Produit(Long idProduit, String code, String libelle, Float prixUnitaire, DetailProduit produitDetail,
			Stock stock, Set<Fournisseur> fournisseurs, Rayon rayons, detailFacture detailFactures) {
		super();
		this.idProduit = idProduit;
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.produitDetail = produitDetail;
		this.stock = stock;
		this.fournisseurs = fournisseurs;
		this.rayons = rayons;
		this.detailFactures = detailFactures;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
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

	public Float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public DetailProduit getProduitDetail() {
		return produitDetail;
	}

	public void setProduitDetail(DetailProduit produitDetail) {
		this.produitDetail = produitDetail;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Set<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}

	public void setFournisseurs(Set<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public Rayon getRayons() {
		return rayons;
	}

	public void setRayons(Rayon rayons) {
		this.rayons = rayons;
	}

	public detailFacture getDetailFactures() {
		return detailFactures;
	}

	public void setDetailFactures(detailFacture detailFactures) {
		this.detailFactures = detailFactures;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
