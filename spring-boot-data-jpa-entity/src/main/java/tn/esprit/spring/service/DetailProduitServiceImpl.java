package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.repository.DetailProduitRepository;

@Service
public class DetailProduitServiceImpl implements DetailProduitSerivce {
    @Autowired
    private DetailProduitRepository detailProduitRepository;
    
    public List<DetailProduit> findAll() {

        Iterable<DetailProduit> it = detailProduitRepository.findAll();

        ArrayList<DetailProduit> dps = new ArrayList<DetailProduit>();
        it.forEach(e -> dps.add(e));

        return dps;
    }

    public DetailProduit getById(long id)   
    {  
    	return detailProduitRepository.findById(id).get();  
    }  
 
    public void add(DetailProduit dp)   
    {  
    	detailProduitRepository.save(dp);  
    }  

    public void delete(long id)   
    {  
    	detailProduitRepository.deleteById(id);  
    }  

    public void update(DetailProduit dp)   
    {  
    	detailProduitRepository.save(dp);  
    }  
}
