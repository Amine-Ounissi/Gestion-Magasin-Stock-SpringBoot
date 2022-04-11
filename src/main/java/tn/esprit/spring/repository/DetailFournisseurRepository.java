package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.DetailFournisseur;

@Repository
public interface DetailFournisseurRepository extends JpaRepository<DetailFournisseur, Long>{

}
