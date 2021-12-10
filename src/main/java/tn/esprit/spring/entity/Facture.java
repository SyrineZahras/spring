package tn.esprit.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name= "Facture")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="idFacture")
public class Facture implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idFacture")
	private Long idFacture;
	
	@Column(name="montantRemise")
	private Float montantRemise;
	
	@Column(name="montantFacture")
	private Float montantFacture;
	
	@Column(name="dateFacture")
	private Date dateFacture;
	
	@Column(name="active")
	private Boolean active;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="factures")
	private Set<detailFacture> detailFactures;
	
	@ManyToOne 
	Client clients;

	public Facture() {
		super();
	}

	public Facture( Float montantRemise, Float montantFacture, Date dateFacture, Boolean active,
			Set<detailFacture> detailFactures, Client clients) {
		super();
		
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.dateFacture = dateFacture;
		this.active = active;
		this.detailFactures = detailFactures;
		this.clients = clients;
	}

	public Long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}

	public Float getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(Float montantRemise) {
		this.montantRemise = montantRemise;
	}

	public Float getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(Float montantFacture) {
		this.montantFacture = montantFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<detailFacture> getDetailFactures() {
		return detailFactures;
	}

	public void setDetailFactures(Set<detailFacture> detailFactures) {
		this.detailFactures = detailFactures;
	}

	public Client getClients() {
		return clients;
	}

	public void setClients(Client clients) {
		this.clients = clients;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
