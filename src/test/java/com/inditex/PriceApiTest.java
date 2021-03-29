package com.inditex;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inditex.dto.Brand;
import com.inditex.dto.Price;
import com.inditex.service.PriceService;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceApiTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private PriceService priceService;
	
	@Test
	void test1() throws Exception {
		Price result = new Price();
		result.setProductId(35455);
		result.setBrandId(new Brand("ZARA"));
		result.setPriceList((long) 1);
		result.setStartDate(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
		result.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		result.setPrice(35.50);
		
		Mockito.when(priceService.getByDates(LocalDateTime.of(2020, 06, 14, 10, 00, 00), 35455, 1)).thenReturn(result);
		
		mvc.perform(get("/priceByDate/date/{date}/product/{productId}/brand/{brandId}", "2020-06-14-10.00.00", 35455, 1)
	            .contentType("application/json"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.price", is(result.getPrice())));

	}
	
	@Test
	void test2() throws Exception {
		Price result = new Price();
		result.setProductId(35455);
		result.setBrandId(new Brand("ZARA"));
		result.setPriceList((long) 2);
		result.setStartDate(LocalDateTime.of(2020, 06, 14, 15, 00, 00));
		result.setEndDate(LocalDateTime.of(2020, 06, 14, 18, 30, 00));
		result.setPrice(25.45);
		
		Mockito.when(priceService.getByDates(LocalDateTime.of(2020, 06, 14, 16, 00, 00), 35455, 1)).thenReturn(result);
		
		mvc.perform(get("/priceByDate/date/{date}/product/{productId}/brand/{brandId}", "2020-06-14-16.00.00", 35455, 1)
	            .contentType("application/json"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.price", is(result.getPrice())));

	}
	
	@Test
	void test3() throws Exception {
		Price result = new Price();
		result.setProductId(35455);
		result.setBrandId(new Brand("ZARA"));
		result.setPriceList((long) 1);
		result.setStartDate(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
		result.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		result.setPrice(35.50);
		
		Mockito.when(priceService.getByDates(LocalDateTime.of(2020, 06, 14, 21, 00, 00), 35455, 1)).thenReturn(result);
		
		mvc.perform(get("/priceByDate/date/{date}/product/{productId}/brand/{brandId}", "2020-06-14-21.00.00", 35455, 1)
	            .contentType("application/json"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.price", is(result.getPrice())));

	}
	
	@Test
	void test4() throws Exception {
		Price result = new Price();
		result.setProductId(35455);
		result.setBrandId(new Brand("ZARA"));
		result.setPriceList((long) 3);
		result.setStartDate(LocalDateTime.of(2020, 06, 15, 00, 00, 00));
		result.setEndDate(LocalDateTime.of(2020, 06, 15, 11, 00, 00));
		result.setPrice(30.50);
		
		Mockito.when(priceService.getByDates(LocalDateTime.of(2020, 06, 15, 10, 00, 00), 35455, 1)).thenReturn(result);
		
		mvc.perform(get("/priceByDate/date/{date}/product/{productId}/brand/{brandId}", "2020-06-15-10.00.00", 35455, 1)
	            .contentType("application/json"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.price", is(result.getPrice())));

	}
	
	@Test
	void test5() throws Exception {
		Price result = new Price();
		result.setProductId(35455);
		result.setBrandId(new Brand("ZARA"));
		result.setPriceList((long) 4);
		result.setStartDate(LocalDateTime.of(2020, 06, 15, 16, 00, 00));
		result.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		result.setPrice(38.95);
		
		Mockito.when(priceService.getByDates(LocalDateTime.of(2020, 06, 16, 21, 00, 00), 35455, 1)).thenReturn(result);
		
		mvc.perform(get("/priceByDate/date/{date}/product/{productId}/brand/{brandId}", "2020-06-16-21.00.00", 35455, 1)
	            .contentType("application/json"))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.price", is(result.getPrice())));

	}

}
