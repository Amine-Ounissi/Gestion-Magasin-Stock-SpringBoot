package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailFournisseur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Long idDetailFournisseur;
	
	@Temporal(TemporalType.DATE)
	Date dateDebutCollaboration;
	String adresse;
	String matricule;
	String test;
	
	@OneToOne(mappedBy = "detailFournisseur",cascade = CascadeType.ALL)
	public Fournisseur fournisseur;

	
	

}
