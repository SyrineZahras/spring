package tn.esprit.spring.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.entity.CategorieProduit;
import tn.esprit.spring.entity.Produit;


@Entity
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor(force = true)
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

	

	

	
}

