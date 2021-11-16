package tn.esprit.spring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.exceptions.RessourceNotFoundException;

public interface ProduitService {

	public List<Produit> GetAllProduit();
	public Produit CreateProduit(@RequestBody Produit produit);
	public ResponseEntity<Produit> GetProduitById(@PathVariable(value = "idProduit") long id)throws RessourceNotFoundException;
	public ResponseEntity<Produit> UpdateProduit(@PathVariable(value = "idProduit") long id, @RequestBody Produit produitDetails)throws RessourceNotFoundException;
	public void DeleteProduct(@PathVariable(value = "idProduit")long id)throws RessourceNotFoundException;
	
}
