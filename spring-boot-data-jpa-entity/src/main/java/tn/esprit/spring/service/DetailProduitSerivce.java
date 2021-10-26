package tn.esprit.spring.service;

import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.DetailProduitRepository;
import tn.esprit.spring.entity.DetailProduit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public interface DetailProduitSerivce {
    
    public List<DetailProduit> findAll();

    public DetailProduit getById(long id);
 
    public void add(DetailProduit dp);

    public void delete(long id);
    
    public void update(DetailProduit dp);
}
