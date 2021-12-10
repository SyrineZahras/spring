package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockControllers {

	@Autowired
	StockService ss;
	StockRepository sr;
	
	@ApiOperation(value="Ajouter un  stock")
	@PostMapping("/add-stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock s) {
		Stock stock = ss.addStock(s);
		return stock;
	}
	@GetMapping("/retrieve-all-stock")
	@ResponseBody
	public List<Stock> getStocks() {
		List<Stock> listStocks = ss.retrieveAllStocks();
		return listStocks;
	}
}
