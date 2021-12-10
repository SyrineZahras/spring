package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

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
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.detailFacture;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.entity.detailFacture;
import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.exceptions.RessourceNotFoundException;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.repository.detailfactureRepository;
import tn.esprit.spring.repository.detailproduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private StockRepository stockrepo;
	@Autowired
	private RayonRepository rayonrepo;
	@Autowired
	private FournisseurRepository fournisseurrepo;
	@Autowired
	private detailfactureRepository detailfacturerepo;
	@Autowired
	private detailproduitRepository detailproduitrepo;
	@Autowired
	private FactureRepository facturerepo;
	//--------- find all product---------//

	@Override
	public List<Produit> GetAllProduit(){
		return (List<Produit>) produitRepository.findAll();
	}

	//---------- create a product-------//
	@Override
	@Transactional
	public void CreateProduit(Produit p, Long idrayon, Long idstock, Long idfournisseur,
			Long iddetailfacture, Long iddetailproduit) {
		
		Rayon rayon = rayonrepo.getById(idrayon);
		Stock stock = stockrepo.getById(idstock);
		Fournisseur fournisseur = fournisseurrepo.getById(idfournisseur);
		detailFacture detailfac = detailfacturerepo.getById(iddetailfacture);
		DetailProduit detailpro = detailproduitrepo.getById(iddetailproduit);
		p.setRayons(rayon);
		p.setStock(stock);
		//Set<Fournisseur>  s = null ;
		//s.add(fournisseur);
		System.out.println("1111111111");
		p.setDetailFactures(detailfac);
		p.setProduitDetail(detailpro);
		produitRepository.save(p);
		System.out.println("produit ajouté");
	}

	//-----------find product by id -----//
	@Override
	@GetMapping("/Produit/{idProduit}")
	public ResponseEntity<Produit> GetProduitById(@PathVariable(value = "idProduit") long id) throws RessourceNotFoundException{
	Produit produit = produitRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Produit not found for this id ::" + id ));
	return ResponseEntity.ok().body(produit);
	} 

	//-------------- update a product---------//
	@Override
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
	@Override
	@DeleteMapping("/Produit/{idProduit}")
	public void DeleteProduct(@PathVariable(value = "idProduit")long id) throws RessourceNotFoundException {
		
		produitRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Produit not found for this id ::" + id ));

		produitRepository.deleteById(id);
		 

	}

	@Override
	public float GetRevenuBrut(Long IdProduit, Date DateDebut, Date DateFin) {
		float total = 0;
		Produit p = produitRepository.getById(IdProduit);
		List<Facture> factures= (List<Facture>) facturerepo.findAll();
		for(Facture facture : factures){
	          for(detailFacture df:facture.getDetailFactures()){
	              if(df.getProduits()==p){
	                  total+=df.getPrixTotal();
	              }
	          }
		}
		return total;
	}

}
