package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.SecteurActivite;

public interface ISecteurActiviteService {
	
	List<SecteurActivite> retrieveSecteurActivite();
	SecteurActivite retrieveById(Long id);
	SecteurActivite saveSecteurActivite(SecteurActivite sA);
	SecteurActivite updateSecteurActivite(SecteurActivite sA);
	void deleteSecteurActivite(Long id);
	public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId);


}
