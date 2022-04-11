package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Fournisseur implements Serializable {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Long idFournisseur;
	
	String codeFournisseur;
	String libelleFournisseur;
	
	@Enumerated(EnumType.STRING)
	CategorieFournisseur categorieFournisseur;
	
	@OneToOne
	public DetailFournisseur detailFournisseur;
	
	@ManyToMany()
	public Set<SecteurActivite> secteurActivites;
	
	@OneToMany(mappedBy = "fournisseur")
	public Set<Facture> factures; 
	

	
	

}
