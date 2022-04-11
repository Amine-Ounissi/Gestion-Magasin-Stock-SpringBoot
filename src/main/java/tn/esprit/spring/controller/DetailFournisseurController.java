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

import tn.esprit.spring.entities.DetailFournisseur;
import tn.esprit.spring.service.IDetailFournisseurService;

@RestController 
@RequestMapping("detailfournisseurcontroller") 
public class DetailFournisseurController {
	@Autowired
	IDetailFournisseurService detailFournisseurService;
	
	@GetMapping("/afficherDetailFournisseurs")
	@ResponseBody 
	List<DetailFournisseur> afficherDetailFournisseurs(){
	return detailFournisseurService.retrieveDetailFournisseurs();
	}
	
	
	@GetMapping("/afficherDetailFournisseur/{id}")
	@ResponseBody 
	DetailFournisseur afficherstock(@PathVariable("id")Long iddf) {
	return detailFournisseurService.retrieveById(iddf);
	}
	
	
	@PostMapping("/ajouterDetailFournisseur")
	@ResponseBody
	DetailFournisseur ajouterStock(@RequestBody DetailFournisseur df) {
	return detailFournisseurService.saveDetailFournisseur(df);
	}
	
	@PutMapping("/updateDetailFournisseur")
	@ResponseBody
	DetailFournisseur updateDetailFournisseur(@RequestBody DetailFournisseur df) { 
	return detailFournisseurService.updateDetailFournisseur(df);
	}
	
	@DeleteMapping("/deleteDetailFournisseur/{id}")
	@ResponseBody
	void deleteDetailFournisseur(@PathVariable("id") Long id) {
		detailFournisseurService.deleteDetailFournisseur(id);
	}

	
}