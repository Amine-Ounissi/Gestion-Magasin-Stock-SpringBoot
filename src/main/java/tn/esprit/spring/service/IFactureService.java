package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Reglement;

public interface IFactureService {
	
	List<Facture> retrieveAllFactures();
	Facture retrieveFacture(Long id);
	void cancelFacture(Long id);
	List<Facture> getFacturesByFournisseur(Long idFournisseur);
	public List<Reglement> retrieveReglementByFacture(Long idFacture);
	Facture addFacture(Facture f, Long idFournisseur);
	Reglement addReglement(Reglement r, Long idFacture);
	public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
	float pourcentageRecouvrement(Date startDate, Date endDate);

}
