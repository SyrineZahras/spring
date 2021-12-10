package tn.esprit.spring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.detailproduitRepository;

@Service
public class DetailProduitServiceImpl implements DetailProduitService {
	@Autowired
	private ProduitRepository pr;
	@Autowired 
	private detailproduitRepository dpr;

	@Override
	@Transactional
	public void AddDetailProduit(DetailProduit dp, Long IdProduit) {
		dp.setProduit(pr.getById(IdProduit));
		dpr.save(dp);
		System.out.println("detail produit ajouté");

	}
	
	

	@Override
	@GetMapping("/Produit/{DetailProduit-id}")
	public ResponseEntity<DetailProduit> GetDetailProduitById(@PathVariable(value = "DetailProduit-id")Long IdDetailProduit) {
	DetailProduit dp = dpr.getById(IdDetailProduit);
	return ResponseEntity.ok().body(dp);
	
	}



	@Override
	@DeleteMapping("/Produit/{DetailProduit-id}")
	public void DeleteDetailProduit(@PathVariable(value = "DetailProduit-id") Long IdDetailProduit) {
		dpr.deleteById(IdDetailProduit);
	}
	
	

}
