package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{
	
	//m1
	List<Produit> findByDateCreationBetween(Date d1 , Date d2);
	
	//m2
	@Query("Select p from Produit p where p.dateCreation > dFrom and p.dateCreation < dTo ")
	List<Produit> retriveProduitByDate(Date d1, Date d2 );

}
