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

import tn.esprit.spring.entities.Operateur;
import tn.esprit.spring.service.IOperateurService;

@RestController 
@RequestMapping("operateurController") 
public class OperateurController {
	
	@Autowired
	IOperateurService operateurService;
	
	@GetMapping("/afficherDetailOperateurs")
	@ResponseBody 
	List<Operateur> afficherOperateurs(){
	return operateurService.retrieveOperateur();
	}
	
	
	@GetMapping("/afficherOperateur/{id}")
	@ResponseBody 
	Operateur afficherstock(@PathVariable("id")Long id) {
	return operateurService.retrieveById(id);
	}
	
	
	@PostMapping("/ajouterOperateur")
	@ResponseBody
	Operateur ajouterStock(@RequestBody Operateur d) {
	return operateurService.saveOperateur(d);
	}
	
	@PutMapping("/updateOperateur")
	@ResponseBody
	Operateur updateOperateur(@RequestBody Operateur d) {
	return operateurService.updateOperateur(d);
	}
	
	@DeleteMapping("/deleteOperateur/{id}")
	@ResponseBody
	void deleteOperateur(@PathVariable("id") Long id) {
		operateurService.deleteOperateur(id);
	}

}
