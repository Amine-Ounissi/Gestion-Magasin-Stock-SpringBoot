package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.SecteurActivite;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.repository.SecteurActiviteRepository;

@Service
public class SecteurActiviteImpl implements ISecteurActiviteService  {

	@Autowired
	SecteurActiviteRepository secteurActiviteRepository; 
	@Autowired
	FournisseurRepository fournisseurRepository; 

	@Override
	public List<SecteurActivite> retrieveSecteurActivite() {
		return (List<SecteurActivite>) secteurActiviteRepository.findAll();
	}

	@Override
	public SecteurActivite retrieveById(Long id) {
		return (SecteurActivite) secteurActiviteRepository.findById(id).orElse(null);
	}

	@Override
	public SecteurActivite saveSecteurActivite(SecteurActivite sA) {
		return (SecteurActivite) secteurActiviteRepository.save(sA);
	}

	@Override
	public SecteurActivite updateSecteurActivite(SecteurActivite sA) {
		return (SecteurActivite) secteurActiviteRepository.save(sA);
	}

	@Override
	public void deleteSecteurActivite(Long id) {
		secteurActiviteRepository.deleteById(id);
		
	}

	@Override
	public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long secteurActiviteId) {
		
		Fournisseur f= fournisseurRepository.findById(fournisseurId).orElse(null);
		f.getSecteurActivites().add(secteurActiviteRepository.findById(secteurActiviteId).get());
		fournisseurRepository.save(f);
		
	}

}
