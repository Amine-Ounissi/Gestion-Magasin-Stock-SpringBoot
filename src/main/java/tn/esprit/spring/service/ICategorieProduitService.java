package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.CategorieProduit;

public interface ICategorieProduitService {

	List<CategorieProduit> retrieveCategorieProduit();
	CategorieProduit retrieveById(Long id);
	CategorieProduit saveCategorieProduit(CategorieProduit cP);
	CategorieProduit updateCategorieProduit(CategorieProduit cP);
	void deleteCategorieProduit(Long id);
}
