package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Produit")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="idProduit")
public class Produit implements Serializable {
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
	
	@OneToOne(cascade = CascadeType.ALL)
	private DetailProduit produitDetail;
	
	@ManyToOne
	Stock stock;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseurs;
	
	@ManyToOne
	Rayon rayons;
	
	@ManyToOne
	detailFacture detailFactures;

	

	public Produit( String code, String libelle, Float prixUnitaire, DetailProduit produitDetail,
			Stock stock, Set<Fournisseur> fournisseurs, Rayon rayons, detailFacture detailFactures) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.prixUnitaire = prixUnitaire;
		this.produitDetail = produitDetail;
		this.stock = stock;
		this.fournisseurs = fournisseurs;
		this.rayons = rayons;
		this.detailFactures = detailFactures;
	}
	


	

}
