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
	 * Returns true if this instance is of the supplied type.
	 * 
	 * @param cartItemType
	 * @return
	 */
	boolean isType(CartItemType cartItemType);
	
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
