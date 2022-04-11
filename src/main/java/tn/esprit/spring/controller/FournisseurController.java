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

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.service.IFournisseurService;

@RestController 
@RequestMapping("fournisseurcontroller") 
public class FournisseurController {
	
	@Autowired
	IFournisseurService fournisseurService;
	
	@GetMapping("/afficherDetailFournisseurs")
	@ResponseBody 
	List<Fournisseur> afficherFournisseurs(){
	return fournisseurService.retrieveFournisseur();
	}
	
	
	@GetMapping("/afficherFournisseur/{id}")
	@ResponseBody 
	Fournisseur afficherstock(@PathVariable("id")Long id) {
	return fournisseurService.retrieveById(id);
	}
	
	
	@PostMapping("/ajouterFournisseur")
	@ResponseBody
	Fournisseur ajouterStock(@RequestBody Fournisseur f) { 
	return fournisseurService.saveFournisseur(f);
	}
	
	@PutMapping("/updateFournisseur")
	@ResponseBody
	Fournisseur updateFournisseur(@RequestBody Fournisseur f) { 
	return fournisseurService.updateFournisseur(f);
	}
	
	@DeleteMapping("/deleteFournisseur/{id}")
	@ResponseBody
	void deleteFournisseur(@PathVariable("id") Long id) {
		fournisseurService.deleteFournisseur(id);
	}

}
