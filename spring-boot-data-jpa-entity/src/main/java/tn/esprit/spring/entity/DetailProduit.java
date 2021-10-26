package tn.esprit.spring.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetailProduit")
public class DetailProduit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailProduit")
	private Long idDetailProduit;
	
	@Column(name="dateCreation")
	private Date dateCreation;
	
	@Column(name="dateDernièreModification")
	private Date dateDernièreModification;
	
	@Column(name="categorieProduit")
	private CategorieProduit categorieProduit;
	
	@OneToOne(mappedBy="produitDetail")
	private Produit produit;

	public DetailProduit() {
		super();
	}

	public DetailProduit(Long idDetailProduit, Date dateCreation, Date dateDernièreModification,
			CategorieProduit categorieProduit, Produit produit) {
		super();
		this.idDetailProduit = idDetailProduit;
		this.dateCreation = dateCreation;
		this.dateDernièreModification = dateDernièreModification;
		this.categorieProduit = categorieProduit;
		this.produit = produit;
	}

	public Long getIdDetailProduit() {
		return idDetailProduit;
	}

	public void setIdDetailProduit(Long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateDernièreModification() {
		return dateDernièreModification;
	}

	public void setDateDernièreModification(Date dateDernièreModification) {
		this.dateDernièreModification = dateDernièreModification;
	}

	public CategorieProduit getCategorieProduit() {
		return categorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		this.categorieProduit = categorieProduit;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}