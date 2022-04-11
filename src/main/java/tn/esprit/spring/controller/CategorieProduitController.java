package tn.esprit.spring.controller;

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

import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.service.ICategorieProduitService;

@RestController 
@RequestMapping("categorieproduitcontroller") 
public class CategorieProduitController {
	
	@Autowired
	ICategorieProduitService categorieProduitService;  
	
	@GetMapping("/afficherCategorieProduit")
	@ResponseBody //pour afficher resultat
	List<CategorieProduit> afficherCategorieProduit(){
	return categorieProduitService.retrieveCategorieProduit();
	}
	
	
	@GetMapping("/afficherCategorieProduit/{id}")
	@ResponseBody //pour afficher resultat
	CategorieProduit afficherCategorieProduit(@PathVariable("id")Long idCategorieProduit) {
	return categorieProduitService.retrieveById(idCategorieProduit);
	}
	
	@PostMapping("/ajouterCategorieProduit")
	@ResponseBody
	CategorieProduit ajouterCategorieProduit(@RequestBody CategorieProduit c) { 
	return categorieProduitService.saveCategorieProduit(c);
	}
	
	@PutMapping("/updateCategorieProduit")
	@ResponseBody
	CategorieProduit updateCategorieProduit(@RequestBody CategorieProduit c) { 
	return categorieProduitService.updateCategorieProduit(c);
	}
	
	@DeleteMapping("/deleteCategorieProduit/{id}")
	@ResponseBody
	void supprimerCategorieProduit(@PathVariable("id") Long id) {
		categorieProduitService.deleteCategorieProduit(id);
	}
}
