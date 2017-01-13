/**
 * 
 */
package com.shopping.entity;

import java.math.BigDecimal;

/**
 * Concrete implementation of a Cart Item
 *
 */
public class CartItemImpl implements CartItem {

	private CartItemType cartItemType;

	/**
	 * Constructor
	 * 
	 * Set to protected so that only classes in same package can call. This
	 * makes the CartItemFactory the preferred method to create CartItems.
	 * 
	 * @param cartItemType
	 */
	protected CartItemImpl(CartItemType cartItemType) {
		if (null == cartItemType) {
			throw new RuntimeException("No cartItem supplied with constructor");
		}
		this.cartItemType = cartItemType;
	}

	/**
	 * @see com.shopping.entity.CartItem#getTitle()
	 */
	public String getTitle() {
		return cartItemType.getTitle();
	}

	/**
	 * @see com.shopping.entity.CartItem#getPrice()
	 */
	public BigDecimal getPrice() {
		return cartItemType.getPrice();
	}

}
