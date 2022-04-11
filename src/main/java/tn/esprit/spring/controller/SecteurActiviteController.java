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

import tn.esprit.spring.entities.SecteurActivite;
import tn.esprit.spring.service.ISecteurActiviteService;

@RestController 
@RequestMapping("secteuractivitecontroller") 
public class SecteurActiviteController {
	
	@Autowired
	ISecteurActiviteService secteurActiviteService;
	
	@GetMapping("/afficherDetailSecteurActivites")
	@ResponseBody 
	List<SecteurActivite> afficherSecteurActivites(){
		return secteurActiviteService.retrieveSecteurActivite();
	}
	
	
	@GetMapping("/afficherSecteurActivite/{id}")
	@ResponseBody 
	SecteurActivite afficherstock(@PathVariable("id")Long id) {
		return secteurActiviteService.retrieveById(id);
	}
	
	
	@PostMapping("/ajouterSecteurActivite")
	@ResponseBody
	SecteurActivite ajouterStock(@RequestBody SecteurActivite p) {
		return secteurActiviteService.saveSecteurActivite(p);
	}
	
	@PutMapping("/updateSecteurActivite")
	@ResponseBody
	SecteurActivite updateSecteurActivite(@RequestBody SecteurActivite p) {
		return secteurActiviteService.updateSecteurActivite(p);
	}
	
	@DeleteMapping("/deleteSecteurActivite/{id}")
	@ResponseBody
	void deleteSecteurActivite(@PathVariable("id") Long id) {
		secteurActiviteService.deleteSecteurActivite(id);
	}
	
	@PostMapping("/assignSecteurActiviteToFournisseur")
	@ResponseBody
	void assignSecteurActiviteToFournisseur(@RequestBody Long fournisseurId,@RequestBody Long
			secteurActiviteId) {
		secteurActiviteService.assignSecteurActiviteToFournisseur(fournisseurId, secteurActiviteId);
	}

}
