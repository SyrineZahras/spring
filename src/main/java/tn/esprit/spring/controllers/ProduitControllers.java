package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.exceptions.RessourceNotFoundException;
import tn.esprit.spring.service.ProduitService;

@RestController
@RequestMapping("/produit")
public class ProduitControllers {
	
	@Autowired
	private ProduitService ps;
	
	@PostMapping("/CreateProduit/{id-rayon}/{id-stock}/{id-fournisseur}/{id-detailfacture}/{id-detailproduit}")
	@ResponseBody
	public void CreateProduit(@RequestBody Produit p,@PathVariable("id-rayon") Long idRayon,@PathVariable("id-stock") Long idStock,
			@PathVariable("id-fournisseur") Long idfournisseur,@PathVariable("id-detailfacture") Long iddetailfacture,@PathVariable("id-detailproduit") Long iddetailproduit) {
		
		
			
			ps.CreateProduit(p,idRayon,idStock,idfournisseur,iddetailfacture,iddetailproduit);
			
		
		
	}
	@ApiOperation(value="Récuperer tous les produits")
	@GetMapping("/retrieve-all-produits")
	public List<Produit> getProduits(){
		List<Produit> listProduits= ps.GetAllProduit();
		return listProduits;
	}
	@ApiOperation(value="Suuprimer un  produit")
	@DeleteMapping("/remove-product/{produit-id}")
	@ResponseBody
	public void removeRayon(@PathVariable("produit-id") Long idProduit) throws RessourceNotFoundException{
		ps.DeleteProduct(idProduit);
	}

	@ApiOperation(value="Récuperer produit avec id")
	@GetMapping("/retrieve-product/{product-id}")
	@ResponseBody
	public ResponseEntity<Produit> GetProduitById(@PathVariable("product-id") Long ProduitId) throws RessourceNotFoundException{
	return ps.GetProduitById(ProduitId);

	}
	
	@ApiOperation(value = "affecter un fournisseur au produit.")
	@GetMapping("/assign-fournisseur/{produit}/{Datestart}/{Dateend}")
    @ResponseBody
    public float getRevenuBrutProduit(@PathVariable("produit") Long productId,@PathVariable("Datestart") Date startDate , @PathVariable("Dateend") Date endDate ) 
	{
		return ps.GetRevenuBrut(productId, startDate, endDate);
	}
	
	
	
	
	
}
