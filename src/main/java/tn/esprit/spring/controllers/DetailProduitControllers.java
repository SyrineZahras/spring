package tn.esprit.spring.controllers;

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
import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.exceptions.RessourceNotFoundException;
import tn.esprit.spring.service.DetailProduitService;

@RestController
@RequestMapping("/detailproduit")
public class DetailProduitControllers {
	
	@Autowired
	DetailProduitService dps;
	
	@PostMapping("/CreateProduit/{Id-Produit}")
	@ResponseBody
	public void AddDtailProduit(@RequestBody DetailProduit dp,@PathVariable("Id-Produit") Long idproduit ) {
		dps.AddDetailProduit(dp, idproduit);
	}
	
	@ApiOperation(value="Suuprimer un detail produit")
	@DeleteMapping("/remove-DetailProduct/{DetailProduit-id}")
	@ResponseBody
	public void removeRayon(@PathVariable("DetailProduit-id") Long iddetailProduit) throws RessourceNotFoundException{
		dps.DeleteDetailProduit(iddetailProduit);
	}

	@ApiOperation(value="Récuperer un detailproduit avec id")
	@GetMapping("/retrieve-DetailProduct/{DetailProduct-id}")
	@ResponseBody
	public ResponseEntity<DetailProduit> GetDetailProduitById(@PathVariable("DetailProduit-id") Long iddetailProduit) throws RessourceNotFoundException{
	return dps.GetDetailProduitById(iddetailProduit);

	}
	

}
