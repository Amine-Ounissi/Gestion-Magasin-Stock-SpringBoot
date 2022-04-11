package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Stock;

public interface IStockService {
	

	List<Stock> retrieveStock();
	Stock retrieveById(Long id);
	Stock saveStock(Stock s);
	Stock updateStock(Stock s);
	void deleteStock(Long id);
	List<Stock> testQte(Integer qt);
	void retrieveStatusStock();

}
