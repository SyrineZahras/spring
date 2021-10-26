package tn.esprit.spring.service;

import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.entity.DetailFacture;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailFactureServiceImpl implements DetailFactureService {
	
    @Autowired
    private DetailFactureRepository detailFactureRepository;
    
    public List<DetailFacture> findAll() {

        Iterable<DetailFacture> it = detailFactureRepository.findAll();

        ArrayList<DetailFacture> dfs = new ArrayList<DetailFacture>();
        it.forEach(e -> dfs.add(e));

        return dfs;
    }

    public DetailFacture getById(long id)   
    {  
    	return detailFactureRepository.findById(id).get();  
    }  
 
    public void add(DetailFacture df)   
    {  
    	detailFactureRepository.save(df);  
    }  

    public void delete(long id)   
    {  
    	detailFactureRepository.deleteById(id);  
    }  

    public void update(DetailFacture df)   
    {  
    	detailFactureRepository.save(df);  
    }  

}
