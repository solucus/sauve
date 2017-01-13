/**
 * 
 */
package com.shopping.cart;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.shopping.entity.CartItem;
import com.shopping.offer.Offer;

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

		if (null != itemList) {
			result = itemList.stream().map(CartItem::getPrice).reduce((price1, price2) -> price1.add(price2));
		}

		return result;
	}

	/**
	 * Given a list of CartItems and list of Offers, calculate the price.
	 * 
	 * @param itemList
	 * @return
	 */
	public Optional<BigDecimal> calculatePriceWithOffers(List<CartItem> itemList, List<Offer> offerList) {

		Optional<BigDecimal> result = calculatePrice(itemList);

		// ensure there are some offers
		if (result.isPresent() && null != offerList && 0 < offerList.size()) {

			// ensure only one instance of an offer is applied
			List<Offer> uniqueOfferList = offerList.stream().distinct().collect(toList());

			// find total discount
			Optional<BigDecimal> discount = uniqueOfferList.stream()
					.map(offer -> offer.getDiscount(itemList))
					.reduce((price1, price2) -> price1.add(price2));
			
			// apply discount to total price
			if(discount.isPresent()){
				result = Optional.of(result.get().subtract(discount.get()));
			}
		}

		return result;
	}

}
