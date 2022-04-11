package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	//CrudRepository feha crud
	//PagingAndSortingRepository feha curd basic + pagination w trie
	//JpaRepository feha curd de base w pagination w trie w m3aha aka fazet kima findByAttribuGraterThan...
	List<Stock> findByQteMinGreaterThan(Integer qt);
	
	
	
	
	// zouz loulanin jpquery
	@Query("Select s from Stock s where s.libelleStock =: libelle and s.qte =: qtt")// ya3ni lmethode hedhi bech tetsa3mel methode
	List<Stock> retrieveStockByLibelleEtQte(@Param("libelle") String libelle, @Param("qtt") Integer qteTes);//hedhi ahna bech namlou requette mahyech predefinie
	//@Param("qtt") yemchi yfarkss ala qtt fel requet
	
	//methode 2
	@Query("Select s from Stock s where s.libelleStock = ?1 and s.qte = ?2")
	List<Stock> retrieveStockByLibelleEtQte2(String libelle, Integer qteTes);
	
	// hedhi native query elmanipulation des donne tssir 7asseb esm eltable felbase or que jpquery temchi haseb esm les entités
	//methode 3
	@Query(value="Select * from stock where s.libelle_stock =?1 and s.qte =?2", nativeQuery=true)
	List<Stock> retrieveStockByLibelleEtQte3(String libelle, Integer qteTes);
}



