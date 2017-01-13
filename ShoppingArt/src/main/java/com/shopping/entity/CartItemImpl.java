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
	@Override
	public String getTitle() {
		return cartItemType.getTitle();
	}

	/**
	 * @see com.shopping.entity.CartItem#getPrice()
	 */
	@Override
	public BigDecimal getPrice() {
		return cartItemType.getPrice();
	}

	/**
	 * 
	 * @see com.shopping.entity.CartItem#isType(com.shopping.entity.CartItemType)
	 */
	@Override
	public boolean isType(CartItemType cartItemType) {
		return this.cartItemType.equals(cartItemType);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartItemType == null) ? 0 : cartItemType.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemImpl other = (CartItemImpl) obj;
		if (cartItemType != other.cartItemType)
			return false;
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CartItemImpl [" + cartItemType + "]";
	}
	
	

}
