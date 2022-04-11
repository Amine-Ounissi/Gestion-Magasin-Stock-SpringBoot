package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repository.CategorieProduitRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.StockRepository;

@Service
public class ProduitImpl implements IProduitService{

	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	CategorieProduitRepository categorieProduitService;
	
	@Autowired
	StockRepository stockRepository;
	
	@Override
	public List<Produit> retrieveProduit() {
		return ( List<Produit>)  produitRepository.findAll();
	}

	@Override
	public Produit retrieveById(Long id) {
		return (Produit ) produitRepository.findById(id).orElse(null);
	}

	@Override
	public Produit saveProduit(Produit p, Long idCategorieProduit, Long idStock) {
	
		p.setCategorieProduit(categorieProduitService.getById(idCategorieProduit));
		p.setStock(stockRepository.getById(idStock));
		return (Produit) produitRepository.save(p);
	}

	@Override
	public Produit updateProduit(Produit p, Long idCategorieProduit, Long idStock) {
		return (Produit) produitRepository.save(p);
	}

	@Override
	public void deleteProduit(Long id) {
		produitRepository.deleteById(id);
		
	}

	@Override
	public List<Produit> findByDateCreationBetween(Date d1, Date d2) {
		return (List<Produit>)produitRepository.findByDateCreationBetween(d1,d2);
	}

	@Override
	public List<Produit> retriveProduitByDate(Date d1, Date d2) {
		return (List<Produit>)produitRepository.retriveProduitByDate(d1,d2);
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit p= produitRepository.findById(idProduit).orElse(null);
		p.setStock(stockRepository.findById(idStock).orElse(null));
		produitRepository.save(p);
		
	}

}
