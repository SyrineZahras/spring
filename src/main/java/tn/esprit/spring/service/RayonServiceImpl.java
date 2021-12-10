package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.repository.RayonRepository;

@Service
public class RayonServiceImpl implements RayonService {
@Autowired
RayonRepository rp;
	@Override
	public List<Rayon> retrieveAllRayons() {
		return  (List<Rayon>) rp.findAll();
		
	}

	@Override
	public Rayon addRayon(Rayon r) {
		return rp.save(r);
	}

	@Override
	public void deleteRayon(Long id) {
		rp.deleteById(id);
		
	}

	@Override
	public Rayon updateRayon(Rayon r) {
		rp.save(r);
		return r ;
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		Rayon r= rp.findById(id).get();
		 return r ;
	}

}
