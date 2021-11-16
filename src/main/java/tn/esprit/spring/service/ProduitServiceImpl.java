package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.exceptions.RessourceNotFoundException;
import tn.esprit.spring.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	
	private ProduitRepository produitRepository;

	//--------- find all product---------//

	@GetMapping("/Produit")
	public List<Produit> GetAllProduit(){
		return (List<Produit>) produitRepository.findAll();
	}

	//---------- create a product-------//
	@PostMapping("/Produit")
	public Produit CreateProduit(@RequestBody Produit produit) {
		return produitRepository.save(produit);
	}

	//-----------find product by id -----//

	@GetMapping("/Produit/{idProduit}")
	public ResponseEntity<Produit> GetProduitById(@PathVariable(value = "idProduit") long id) throws RessourceNotFoundException{
	Produit produit = produitRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Produit not found for this id ::" + id ));
	return ResponseEntity.ok().body(produit);
	} 

	//-------------- update a product---------//

	@PutMapping("/Prouit/{idProduit}")
	public ResponseEntity<Produit> UpdateProduit(@PathVariable(value = "idProduit") long id
			, @RequestBody Produit produitDetails)throws RessourceNotFoundException{
		Produit produit = produitRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Produit not found for this id ::" + id ));
	produit.setIdProduit(produitDetails.getIdProduit());
	produit.setCode(produitDetails.getCode());
	produit.setLibelle(produitDetails.getLibelle());
	produit.setPrixUnitaire(produitDetails.getPrixUnitaire());
	produit.setProduitDetail(produitDetails.getProduitDetail());
	produit.setStock(produitDetails.getStock());
	produit.setRayons(produitDetails.getRayons());
	produitRepository.save(produit);
	return ResponseEntity.ok().body(produit);

	}

	//-----------delete product by id -----//

	@DeleteMapping("/Produit/{idProduit}")
	public void DeleteProduct(@PathVariable(value = "idProduit")long id) throws RessourceNotFoundException {
		
		produitRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Produit not found for this id ::" + id ));

		produitRepository.deleteById(id);
		 

	}

}
