/**
 * 
 */
package com.shopping.offer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.shopping.entity.CartItem;
import com.shopping.entity.CartItemType;

/**
 * 
 *
 */
public class OfferOrangeThreeForTwo implements Offer {

	/**
	 * @see com.shopping.offer.Offer#getDiscount(java.util.List)
	 */
	@Override
	public BigDecimal getDiscount(List<CartItem> cartList) {

		BigDecimal discountedPrice = BigDecimal.ZERO;

		if (null != cartList && 0 < cartList.size()) {

			// get list of qualifying items
			List<CartItem> qualifyingItems = cartList.stream()
					.filter(item -> item.isType(CartItemType.ORANGE))
					.collect(Collectors.toList());

			// find the number of items to give as a discount
			List<CartItem> discountItems = new ArrayList<>();
			for (int i = 0; i < qualifyingItems.size(); i++) {
				if (i % 3 == 2) {
					discountItems.add(qualifyingItems.get(i));
				}
			}
			
			// find sum of discount
			Optional<BigDecimal> discountToApply = discountItems.stream()
					.map(CartItem::getPrice)
					.reduce((p1,p2)->p1.add(p2));
			
			// set discount
			if(discountToApply.isPresent()){
				discountedPrice = discountToApply.get();
			}
		}
		return discountedPrice;
	}

}
