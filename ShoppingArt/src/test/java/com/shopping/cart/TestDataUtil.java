/**
 * 
 */
package com.shopping.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.shopping.entity.CartItem;
import com.shopping.entity.CartItemFactory;
import com.shopping.offer.Offer;
import com.shopping.offer.OfferFactory;

/**
 * Setup some test data utilities
 *
 */
public class TestDataUtil {

	/**
	 * Create a list of CartItems of the required dimensions.
	 * 
	 * @param appleMax
	 * @param orangeMax
	 * @return
	 */
	public static List<CartItem> getItemList(int appleMax, int orangeMax) {
		CartItemFactory itemFactory = CartItemFactory.INSTANCE;
		List<CartItem> cartList = new ArrayList<>();

		for (int applesAdded = 0; applesAdded < appleMax; applesAdded++) {
			cartList.add(itemFactory.createApple());
		}

		for (int orangesAdded = 0; orangesAdded < orangeMax; orangesAdded++) {
			cartList.add(itemFactory.createOrange());
		}

		return cartList;
	}

	/**
	 * Get the expected price of cart items
	 * 
	 * @return
	 */
	public static Optional<BigDecimal> getItemListExpectedPrice(List<CartItem> itemList) {
		Optional<BigDecimal> result = Optional.empty();

		if (null != itemList && 0 < itemList.size()) {
			BigDecimal sum = BigDecimal.ZERO;
			for (CartItem item : itemList) {
				sum = sum.add(item.getPrice());
			}
			result = Optional.of(sum);
		}

		return result;
	}


	/**
	 * Create a list of Offers of the required dimensions.
	 * 
	 * @param appleMax
	 * @param orangeMax
	 * @return
	 */
	public static List<Offer> getOfferList(int appleMax, int orangeMax) {
		OfferFactory offerFactory = OfferFactory.INSTANCE;
		List<Offer> offerList = new ArrayList<>();

		for (int applesAdded = 0; applesAdded < appleMax; applesAdded++) {
			offerList.add(offerFactory.createAppleBuyOneGetOneFree());
		}

		for (int orangesAdded = 0; orangesAdded < orangeMax; orangesAdded++) {
			offerList.add(offerFactory.createOrangeThreeForTwo());
		}

		return offerList;
	}
}
