/**
 * 
 */
package com.shopping.offer;

import java.math.BigDecimal;
import java.util.List;

import com.shopping.entity.CartItem;

/**
 * 
 *
 */
public interface Offer {

	/**
	 * Calculate the discount amount that this offer applies to the supplied
	 * items.
	 * 
	 * @param cartList
	 * @return
	 */
	BigDecimal getDiscount(List<CartItem> cartList);

}
