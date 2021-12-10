package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{
@Autowired 
StockRepository sr;
	@Override
	public List<Stock> retrieveAllStocks() {
		return (List<Stock>)sr.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		sr.save(s);
		return s;
	}

	@Override
	public Stock updateStock(Stock u) {
		sr.save(u);
		return u;
	}

	@Override
	public Stock retrieveStock(Long id) {
		Stock s= sr.findById(id).get();
		return s;
	}

	@Override
	public void deleteStock(Long id) {
		sr.deleteById(id);
	}


	

}
