package com.shopping.entity;

import java.math.BigDecimal;

/**
 * Enum of kinds of Cart Items
 *
 */
public enum CartItemType {
	
	APPLE("Apple",new BigDecimal("0.60"))
	,ORANGE("Orange",new BigDecimal("0.25"));
	
	private String title ;
	private BigDecimal price;
	
	CartItemType(String title, BigDecimal price){
		this.title=title;
		this.price=price;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	
}
