package com.inditex.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.dao.PriceRepository;
import com.inditex.dto.Brand;
import com.inditex.dto.Price;

@Service
public class PriceService {

	@Autowired
	PriceRepository dao;
	
	public Price save(Price price) {
		return dao.save(price);
		//return dao.saveAndFlush(price);
	}
	
	public Optional<Price> getById(Long id) {
		return dao.findById(id);
	}
	
	public List<Price> getPrices(){
		return (List<Price>) dao.findAll();
	}
	
	public Optional<Price> getPriceById( long priceList){
		return dao.findById(priceList);
	}
	
	public Price getByDates(LocalDateTime date, int productId, long brandId){
		List<Price> priceList = getPrices();
		List<Price> auxList = new ArrayList<Price>();
		
		for(int i = 0; i < priceList.size(); i++) {
			
			if(priceList.get(i).getProductId() == productId && priceList.get(i).getBrandId().getBrandId() == brandId && 
					((date.isBefore(priceList.get(i).getEndDate()) && date.isAfter(priceList.get(i).getStartDate())) || ( 
							date.isEqual(priceList.get(i).getStartDate()) || date.isEqual(priceList.get(i).getEndDate())))){
				auxList.add(priceList.get(i));
			}
		}
		
		Price auxPrice = null;
		
		if(!auxList.isEmpty()) {
			auxPrice = auxList.get(0);
			for(int i = 0; i < auxList.size(); i++) {
				if(auxList.get(i).getPriority() > auxPrice.getPriority()) {
					auxPrice = auxList.get(i);
				}
			}
		}
		
		
		return auxPrice;
	}
}
