package com.inditex.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="PRICES")
public class Price implements Serializable{

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "fk_brand", nullable = false)
	@ManyToOne
	private Brand brandId;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd-HH.mm.ss")
	private LocalDateTime startDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd-HH.mm.ss")
	private LocalDateTime endDate;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long priceList;
	private int productId;
	private int priority;
	private double price;
	private String curr;
	
	
	public Price(Brand brandId, LocalDateTime startDate, LocalDateTime endDate, long priceList, int productId, int priority, double price,
			String curr) {
		super();
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	public Price() {
		
	}

	public Brand getBrandId() {
		return brandId;
	}
	
	public void setBrandId(Brand brandId) {
		this.brandId = brandId;
	}
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	public LocalDateTime getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	public Long getPriceList() {
		return priceList;
	}
	
	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCurr() {
		return curr;
	}
	
	public void setCurr(String curr) {
		this.curr = curr;
	}

	@Override
	public String toString() {
		return "Price [brandId=" + brandId + ", startDate=" + startDate + ", endDate=" + endDate + ", priceList="
				+ priceList + ", productId=" + productId + ", priority=" + priority + ", price=" + price + ", curr="
				+ curr + "]";
	}
	
}
