package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.DetailFournisseur;
import tn.esprit.spring.repository.DetailFournisseurRepository;

@Service
public class DetailFournisseurImpl implements IDetailFournisseurService {
	@Autowired
	DetailFournisseurRepository detailFournisseurRepository;

	@Override
	public DetailFournisseur saveDetailFournisseur(DetailFournisseur dF) {
		return (DetailFournisseur) detailFournisseurRepository.save(dF);
	}

	@Override
	public List<DetailFournisseur> retrieveDetailFournisseurs() {
		return (List<DetailFournisseur>) detailFournisseurRepository.findAll();
	}

	@Override
	public DetailFournisseur retrieveById(Long id) {
		return (DetailFournisseur) detailFournisseurRepository.findById(id).orElse(null);
	}

	@Override
	public DetailFournisseur updateDetailFournisseur(DetailFournisseur s) {
		return (DetailFournisseur) detailFournisseurRepository.save(s);
	}

	@Override
	public void deleteDetailFournisseur(Long id) {
		detailFournisseurRepository.deleteById(id);
		
	}
	
	
	
	

}
