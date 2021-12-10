package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Rayon;

public interface RayonService {
	List<Rayon> retrieveAllRayons();

	tn.esprit.spring.entity.Rayon addRayon(Rayon r);

	void deleteRayon(Long id);
	Rayon updateRayon(Rayon r);

	Rayon retrieveRayon(Long id);

}
