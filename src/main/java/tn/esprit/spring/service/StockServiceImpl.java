package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.service.IStockService;
import tn.esprit.spring.service.StockServiceImpl;


@Service
@Slf4j
public class StockServiceImpl implements IStockService{

	@Autowired
	StockRepository stockRepository;
	
	@Override
	public List<Stock> retrieveStock() {
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock retrieveById(Long id) {
		return stockRepository.findById(id).orElse(null);
		//return stockRepository.findById(id).get(); traja3lk objet soit eli l9ah soit fera8
	}

	@Override
	public Stock saveStock(Stock s) {
		//System.out.println("in methode");
		log.info("in methode");

		Stock st= stockRepository.save(s);
		//System.out.println("out methode");
		log.info("out methode");
		return st;
	}

	@Override
	public Stock updateStock(Stock s) {
		return stockRepository.save(s);
	}

	/* @Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);		
	}*/

	@Override
	public List<Stock> testQte(Integer qt) {
		return stockRepository.findByQteMinGreaterThan(qt);
	}
	@Override
	public void deleteStock(Long id) {
		Optional<Stock> stock = stockRepository.findById(id);

		if (stock.isPresent()) {
			stockRepository.deleteById(id);
		} else {
			log.info("No stock record exist for given id");
		}

	}
	@Override
	@Scheduled(cron = "*/15 * * * * *" )
	public void retrieveStatusStock() {
		List<Stock> ss=(List<Stock>) stockRepository.findAll();
		for (Stock stock : ss) {
			if(stock.getQteMin()<stock.getQte()){
				//System.out.println(stock.toString());
				log.info("stock :"+"Libelle :"+stock.getLibelleStock()+ stock.getQteMin());

			}
		}
	}

}
