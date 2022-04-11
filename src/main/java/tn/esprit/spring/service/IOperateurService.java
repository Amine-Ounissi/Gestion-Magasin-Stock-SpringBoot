package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Operateur;

public interface IOperateurService {
	
	List<Operateur> retrieveOperateur();
	Operateur retrieveById(Long id);
	Operateur saveOperateur(Operateur o);
	Operateur updateOperateur(Operateur o);
	void deleteOperateur(Long id);
	public void assignOperateurToFacture(Long idOperateur, Long idFacture);
}
