package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.exceptions.RessourceNotFoundException;

public interface ProduitService {

	public List<Produit> GetAllProduit();
	
	public void CreateProduit(Produit p, Long idrayon, Long idstock, Long idfournisseur,
			Long iddetailfacture, Long iddetailproduit);
	
	public ResponseEntity<Produit> GetProduitById(@PathVariable(value = "idProduit") long id)throws RessourceNotFoundException;
	
	public ResponseEntity<Produit> UpdateProduit(@PathVariable(value = "idProduit") long id, @RequestBody Produit produitDetails)throws RessourceNotFoundException;
	
	public void DeleteProduct(@PathVariable(value = "idProduit")long id)throws RessourceNotFoundException;
	
	public float GetRevenuBrut(Long IdProdui, Date DateDebut, Date DateFin);
	
}
