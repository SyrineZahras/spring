package tn.esprit.spring.service;

import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.entity.DetailFacture;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public interface DetailFactureService {
	
    public List<DetailFacture> findAll();

    public DetailFacture getById(long id);
    
    public void add(DetailFacture df);
    
    public void delete(long id);
    
    public void update(DetailFacture df);

}
