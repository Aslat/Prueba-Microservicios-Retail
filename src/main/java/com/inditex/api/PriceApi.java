package com.inditex.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.service.PriceService;
import com.inditex.dto.Brand;
import com.inditex.dto.Price;

@RestController
public class PriceApi {
	
	@Autowired
	PriceService priceService;
	
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public Optional<Price> getById(@RequestBody Long id){
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
//		LocalDateTime startDate = new Date();
//		LocalDate endDate = new Date();
//		
//		
//		try {
//			startDate = sdf.parse("2020-06-14-00.00.00");
//			endDate = sdf.parse("2020-12-31-23.59.59");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
        //return new Price(1L, 1, LocalDateTime.of(2020, 06, 14, 00, 00, 00), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 35455, 0, 35.50, "EUR");
		return priceService.getById(id);
	}
	
	@RequestMapping(value="/price", method=RequestMethod.POST)
	public Price updateOrSave(@RequestBody Price price) {
		return priceService.save(price);
	}
	
	@RequestMapping(value="/prices", method=RequestMethod.GET)
	public List<Price> getPrices() {
		return priceService.getPrices();
	}
	
	@RequestMapping(value="/price/id/{priceList}", method=RequestMethod.GET)
	public Optional<Price> getPriceById(@PathVariable long priceList) {
		return priceService.getPriceById(priceList);
	}
	
	@RequestMapping(value="/priceByDate/date/{date}/product/{productId}/brand/{brandId}", method=RequestMethod.GET)
	public Price getPrices(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime date, @PathVariable int productId, @PathVariable long brandId) {
		return priceService.getByDates(date, productId, brandId);
	}

	

}
