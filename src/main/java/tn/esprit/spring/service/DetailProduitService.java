package tn.esprit.spring.service;
import org.springframework.http.ResponseEntity;

import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Produit;

public interface DetailProduitService {
	
	public void AddDetailProduit(DetailProduit dp, Long IdProduit);
	
	public void DeleteDetailProduit(Long IdDetailProduit);
	
	public ResponseEntity<DetailProduit> GetDetailProduitById(Long IdDetailProduit);

}
