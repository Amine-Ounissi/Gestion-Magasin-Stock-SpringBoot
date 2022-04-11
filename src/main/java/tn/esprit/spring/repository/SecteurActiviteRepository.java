package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.SecteurActivite;

@Repository
public interface SecteurActiviteRepository extends JpaRepository<SecteurActivite, Long>{

}
