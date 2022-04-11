package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.OneToMany;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Facture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Long idFacture;
	float montantRemise;
	float montantFacture;
	Date dataCreationFacture;
	Date dataDerniereModification;
	boolean archivee;
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Fournisseur fournisseur;
	
	@OneToMany(mappedBy = "facture")
	public Set<Reglement> reglements;
	
	@OneToMany(mappedBy = "facture")
	public Set<DetailFacture> detailFactures;

	public boolean isArchivee() {
		return archivee;
	}
    
}