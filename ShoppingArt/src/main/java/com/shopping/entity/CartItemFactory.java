/**
 * 
 */
package com.shopping.entity;

/**
 * A factory for creating CartItems.
 * 
 * Uses the Singleton pattern.
 * 
 * Example of use:
 * 
 * CartItem apple = CartItemFactory.INSTANCE.createApple();
 *
 */
public enum CartItemFactory {

	INSTANCE;

	/**
	 * Creates a CartItem instance with the supplied type.
	 * 
	 * @param cartItemType
	 * @return
	 */
	public CartItem createCartItem(CartItemType cartItemType) {
		return new CartItemImpl(cartItemType);
	}

	/**
	 * Convenience method to create a CartItem instance of type APPLE
	 * 
	 * @return
	 */
	public CartItem createApple() {
		return createCartItem(CartItemType.APPLE);
	}

	/**
	 * Convenience method to create a CartItem instance of type ORANGE
	 * 
	 * @return
	 */
	public CartItem createOrange() {
		return createCartItem(CartItemType.ORANGE);
	}

}
