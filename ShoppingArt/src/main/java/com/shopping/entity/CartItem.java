/**
 * 
 */
package com.shopping.entity;

import java.math.BigDecimal;

/**
 * Represents an item on a shopping cart.
 *
 */
public interface CartItem {

	/**
	 * Return the short title of the cart item, 
	 * 
	 * @return
	 */
	String getTitle();
	
	/**
	 * Return the price of the cart item.
	 * 
	 * @return
	 */
	BigDecimal getPrice();
	
}
