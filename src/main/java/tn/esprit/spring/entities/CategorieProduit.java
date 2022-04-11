package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Builder   
public class CategorieProduit implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Long idCategorieProduit;
	String codeProduit;
	
	@NonNull  
	String libelleCategorieProduit;
	
	@OneToMany(mappedBy = "categorieProduit" , cascade = CascadeType.ALL)
	public Set<Produit> produits;
}

	    

