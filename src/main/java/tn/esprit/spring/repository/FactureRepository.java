package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long>{
	
		List<Facture> findByDataCreationFactureBetween(Date d1 , Date d2);

}
