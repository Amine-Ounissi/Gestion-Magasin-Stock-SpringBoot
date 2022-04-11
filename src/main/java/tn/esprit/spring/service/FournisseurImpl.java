package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.DetailFournisseur;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.repository.DetailFournisseurRepository;
import tn.esprit.spring.repository.FournisseurRepository;


@Service
public class FournisseurImpl implements IFournisseurService{
	@Autowired
	FournisseurRepository fournisseurRepository; 
	@Autowired
	DetailFournisseurRepository detailFournisseurRepository;
	
	@Override
	public List<Fournisseur> retrieveFournisseur() {
		return (List<Fournisseur>) fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur retrieveById(Long id) {
		return (Fournisseur) fournisseurRepository.findById(id).orElse(null);
	}

	@Override
	public Fournisseur saveFournisseur(Fournisseur f) {
		
		DetailFournisseur df = addDetailFournisseur(f);
		f.setDetailFournisseur(df);
		return fournisseurRepository.save(f);
		
	}

	private DetailFournisseur addDetailFournisseur(Fournisseur f) {
		DetailFournisseur df= f.getDetailFournisseur();
		return detailFournisseurRepository.save(df);
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		return (Fournisseur) fournisseurRepository.save(f);
	}

	@Override
	public void deleteFournisseur(Long id) {
		fournisseurRepository.deleteById(id);
		
	}

}