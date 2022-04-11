package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.service.IProduitService;

@RestController 
@RequestMapping("produitController") 
public class ProduitController {
	
	@Autowired
	IProduitService produitService;
	
	@GetMapping("/afficherDetailProduits")
	@ResponseBody 
	List<Produit> afficherProduits(){
		return produitService.retrieveProduit();
	}
	
	
	@GetMapping("/afficherProduit/{id}")
	@ResponseBody 
	Produit afficherstock(@PathVariable("id")Long id) {
		return produitService.retrieveById(id);
	}
	
	
	@PostMapping("/ajouterProduit")
	@ResponseBody
	Produit ajouterStock(@RequestBody Produit p,@RequestBody Long idCP, @RequestBody Long idS) {
		return produitService.saveProduit(p,idCP, idS);
	}
	
	@PutMapping("/updateProduit")
	@ResponseBody
	Produit updateProduit(@RequestBody Produit p,@RequestBody Long idCP, @RequestBody Long idS){
		return produitService.updateProduit(p,idCP, idS);
	}
	
	@DeleteMapping("/deleteProduit/{id}")
	@ResponseBody
	void deleteProduit(@PathVariable("id") Long id) {
		produitService.deleteProduit(id);
	}
	
	@PostMapping("/retriveProduitByDate")
	@ResponseBody
	List<Produit> retriveProduitByDate(@RequestBody Date d1,@RequestBody Date d2) {
		return produitService.retriveProduitByDate(d1,d2);
	}
	
	@PostMapping("/assignProduitToStock")
	@ResponseBody
	void assignProduitToStock(@RequestBody Long idProduit,@RequestBody Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}

}
