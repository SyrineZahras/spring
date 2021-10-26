package tn.esprit.spring.repository;

import tn.esprit.spring.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface DetailProduitRepository extends CrudRepository<DetailProduit, Long> { 

}
