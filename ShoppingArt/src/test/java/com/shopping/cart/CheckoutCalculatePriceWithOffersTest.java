/**
 * 
 */
package com.shopping.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import org.junit.Test;

import com.shopping.entity.CartItem;
import com.shopping.entity.CartItemFactory;
import com.shopping.entity.CartItemType;
import com.shopping.offer.Offer;

/**
 * Tests for the Checkout class
 *
 */
public class CheckoutCalculatePriceWithOffersTest {

	private static final CartItemFactory itemFactory = CartItemFactory.INSTANCE;

	/**
	 * Test with null item list
	 */
	@Test
	public void calculatePriceWithOffersTestNullLists() {

		Checkout checkout = new Checkout();

		// setup test data
		List<CartItem> itemList = null;
		List<Offer> offerList = null;
		Optional<BigDecimal> priceExpected = TestDataUtil.getItemListExpectedPrice(itemList);

		// run test
		Optional<BigDecimal> priceActual = checkout.calculatePriceWithOffers(itemList, offerList);

		// check result
		assertEquals(priceExpected, priceActual);
	}

	/**
	 * Test with zero items
	 */
	@Test
	public void calculatePriceTestZeroItems() {

		Checkout checkout = new Checkout();

		// setup test data
		List<CartItem> itemList = new ArrayList<>();
		List<Offer> offerList = new ArrayList<>();
		Optional<BigDecimal> priceExpected = TestDataUtil.getItemListExpectedPrice(itemList);

		// run test
		Optional<BigDecimal> priceActual = checkout.calculatePriceWithOffers(itemList, offerList);

		// check result
		assertEquals(priceExpected, priceActual);
	}

	/**
	 * Test with One item
	 */
	@Test
	public void calculatePriceTestOneItem() {

		Checkout checkout = new Checkout();

		List<CartItem> itemList = null;
		List<Offer> offerList = new ArrayList<>();
		Optional<BigDecimal> priceExpected = null;
		Optional<BigDecimal> priceActual = null;

		// TEST for one APPLE
		// setup test data
		itemList = Arrays.asList(itemFactory.createApple());
		priceExpected = Optional.of(CartItemType.APPLE.getPrice());

		// execute test
		priceActual = checkout.calculatePriceWithOffers(itemList, offerList);

		// test result
		assertEquals(priceExpected, priceActual);

		// TEST for one ORANGE
		// setup test data
		itemList = Arrays.asList(itemFactory.createOrange());
		priceExpected = Optional.of(CartItemType.ORANGE.getPrice());

		// execute test
		priceActual = checkout.calculatePriceWithOffers(itemList, offerList);

		// test result
		assertEquals(priceExpected, priceActual);
	}

	/**
	 * Test with multiple items
	 */
	@Test
	public void calculatePriceTestMultipleItems() {

		Checkout checkout = new Checkout();

		List<CartItem> itemList = null;
		List<Offer> offerList = new ArrayList<>();
		Optional<BigDecimal> priceExpected = null;
		Optional<BigDecimal> priceActual = null;

		// TEST for one APPLE and one ORANGE
		// setup test data
		itemList = TestDataUtil.getItemList(1, 1);
		priceExpected = TestDataUtil.getItemListExpectedPrice(itemList);

		// execute test
		priceActual = checkout.calculatePriceWithOffers(itemList, offerList);

		// test result
		assertEquals(priceExpected, priceActual);

		// TEST for multiple APPLEs and ORANGEs
		// setup test data
		itemList = TestDataUtil.getItemList(3, 1);
		priceExpected = TestDataUtil.getItemListExpectedPrice(itemList);
		// 

		// execute test
		priceActual = checkout.calculatePriceWithOffers(itemList, offerList);

		// test result
		assertEquals(priceExpected, priceActual);
	}

	/**
	 * Test with multiple items
	 */
	@Test
	public void calculatePriceWithOffersTestMultipleItems() {

		Checkout checkout = new Checkout();

		List<CartItem> itemList = null;
		List<Offer> offerList = null;
		Optional<BigDecimal> priceExpected = null;
		Optional<BigDecimal> priceActual = null;

		// Add offer list
		offerList = TestDataUtil.getOfferList(1, 1);
		
		// TEST for one APPLE and one ORANGE
		// setup test data
		itemList = TestDataUtil.getItemList(1, 1);
		priceExpected = TestDataUtil.getItemListExpectedPrice(itemList);

		// execute test
		priceActual = checkout.calculatePriceWithOffers(itemList, offerList);

		// test result
		assertEquals(priceExpected, priceActual);

		// TEST for multiple APPLEs and ORANGEs
		// setup test data
		itemList = TestDataUtil.getItemList(3, 1);
		// apply discount due to offers
		priceExpected = Optional.of(new BigDecimal("1.45"));

		// execute test
		priceActual = checkout.calculatePriceWithOffers(itemList, offerList);

		// test result
		assertEquals(priceExpected, priceActual);
	}
}
