package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.service.RayonService;

@RestController
@RequestMapping("/rayon")
public class RayonControllers {
	@Autowired
	RayonService rs;
	
	@ApiOperation(value="Ajouter un  Rayon")
	@PostMapping("/add-rayon")
	@ResponseBody
	public Rayon addRayon(@RequestBody Rayon r) {
		Rayon rayon = rs.addRayon(r);
		return rayon;
	}
	
	@ApiOperation(value="Récuperer tous les rayons")
	@GetMapping("/retrieve-all-rayons")
	public List<Rayon> getRayons(){
		List<Rayon> listRayons=  rs.retrieveAllRayons();
		return listRayons;
	}
	@ApiOperation(value="Récuperer Rayon avec id")
	@GetMapping("/retrieve-rayon/{rayon-id}")
	@ResponseBody
	public Rayon retrieveRayon(@PathVariable("rayon-id") Long rayonId) {
	return  rs.retrieveRayon(rayonId);

	}
	@ApiOperation(value="Suuprimer un  rayon")
	@DeleteMapping("/remove-rayon/{rayon-id}")
	@ResponseBody
	public void removeRayon(@PathVariable("rayon-id") Long rayonId) {
		rs.deleteRayon(rayonId);
	}

}
