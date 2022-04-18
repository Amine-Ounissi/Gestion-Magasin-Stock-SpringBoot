package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.service.IStockService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	
		@Autowired
		IStockService stockService;

		@Test
		public void testsaveStock() {
						
				List<Stock> stocks = stockService.retrieveStock();
				int expected=stocks.size();
				Stock s = new Stock();
				s.setLibelleStock("stock test");
				s.setQte(10);
				s.setQteMin(100);
				Stock savedStock= stockService.saveStock(s);
				assertEquals(expected+1, stockService.retrieveStock().size());
				assertNotNull(savedStock.getLibelleStock());
				stockService.deleteStock(savedStock.getIdStock());
		}
	 
		@Test
		public void testdeleteStock() {
			List<Stock> stocks = stockService.retrieveStock();
			int expected=stocks.size();
			Stock s = new Stock();
					s.setLibelleStock("stock test 2");
					s.setQte(30);
					s.setQteMin(120);
					Stock savedStock= stockService.saveStock(s);
					stockService.deleteStock(savedStock.getIdStock());
					assertNotEquals(expected+1, stockService.retrieveStock().size());
			
		}

}
