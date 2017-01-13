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

/**
 * Tests for the Checkout class, method calculatePrice
 *
 */
public class CheckoutCalculatePriceTest {

	private static final CartItemFactory itemFactory = CartItemFactory.INSTANCE;

	/**
	 * Test with null item list
	 */
	@Test
	public void calculatePriceTestNullItemList() {

		Checkout checkout = new Checkout();

		// setup test data
		List<CartItem> itemList = null;
		Optional<BigDecimal> priceExpected = TestDataUtil.getItemListExpectedPrice(itemList);

		// run test
		Optional<BigDecimal> priceActual = checkout.calculatePrice(itemList);

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
		Optional<BigDecimal> priceExpected = TestDataUtil.getItemListExpectedPrice(itemList);

		// run test
		Optional<BigDecimal> priceActual = checkout.calculatePrice(itemList);

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
		Optional<BigDecimal> priceExpected = null;
		Optional<BigDecimal> priceActual = null;

		// TEST for one APPLE
		// setup test data 
		itemList = Arrays.asList(itemFactory.createApple());
		priceExpected = Optional.of(CartItemType.APPLE.getPrice());

		// execute test 
		priceActual = checkout.calculatePrice(itemList);

		// test result 
		assertEquals(priceExpected, priceActual);

		// TEST for one ORANGE
		// setup test data 
		itemList = Arrays.asList(itemFactory.createOrange());
		priceExpected = Optional.of(CartItemType.ORANGE.getPrice());

		// execute test 
		priceActual = checkout.calculatePrice(itemList);

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
		Optional<BigDecimal> priceExpected = null;
		Optional<BigDecimal> priceActual = null;

		// TEST for one APPLE and one ORANGE
		// setup test data 
		itemList = TestDataUtil.getItemList(1, 1);
		priceExpected = TestDataUtil.getItemListExpectedPrice(itemList);
		
		// execute test 
		priceActual = checkout.calculatePrice(itemList);

		// test result 
		assertEquals(priceExpected, priceActual);

		// TEST for multiple APPLEs and  ORANGEs
		// setup test data 
		itemList = TestDataUtil.getItemList(3, 1);
		priceExpected = TestDataUtil.getItemListExpectedPrice(itemList);

		// execute test 
		priceActual = checkout.calculatePrice(itemList);

		// test result 
		assertEquals(priceExpected, priceActual);
	}
}
