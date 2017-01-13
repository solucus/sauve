/**
 * 
 */
package com.shopping.cart;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.shopping.entity.CartItem;

/**
 * Represents a checkout system for Cart Items
 *
 */
public class Checkout {
	
	/**
	 * Given a list of CartItems, calculate the price.
	 * 
	 * @param itemList
	 * @return
	 */
	public Optional<BigDecimal> calculatePrice(List<CartItem> itemList) {
		
		Optional<BigDecimal> result = Optional.empty();
		
		if(null != itemList){
			result = itemList.stream()
					.map(CartItem::getPrice)
					.reduce((price1,price2) -> price1.add(price2));
		}
		
		return result;
	}
	
}
