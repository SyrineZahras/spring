package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;

public class StockServiceImpl implements StockService {
	
	StockRepository repo;

	@Override
	public List<Stock> retrieveAllStocks() {
		return (List<Stock>) repo.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		return repo.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock retrieveStock(Long id) {
		return repo.findById(id).orElse(null);
	}

}
