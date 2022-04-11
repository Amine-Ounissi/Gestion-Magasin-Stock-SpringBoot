package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Produit;

public interface IProduitService {
	
	
	List<Produit> retrieveProduit();
	Produit retrieveById(Long id);
	Produit saveProduit(Produit p, Long idCategorieProduit, Long idStock);
	Produit updateProduit(Produit p, Long idCategorieProduit, Long idStock);
	void deleteProduit(Long id);
	List<Produit> findByDateCreationBetween(Date d1, Date d2);
	List<Produit> retriveProduitByDate(Date d1, Date d2);
	void assignProduitToStock(Long idProduit, Long idStock);

}
