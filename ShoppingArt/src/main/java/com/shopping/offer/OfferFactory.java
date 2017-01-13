/**
 * 
 */
package com.shopping.offer;

/**
 * A factory for creating Offers
 * 
 * Uses the Singleton pattern.
 * 
 * Example of use:
 * 
 * Offer appleBOGOF = OfferFactory.INSTANCE.createAppleBuyOneGetOneFree();
 *
 */
public enum OfferFactory {

	INSTANCE;
	
	public Offer createAppleBuyOneGetOneFree(){
		return new OfferAppleBuyOneGetOneFree();
	}
	
	public Offer createOrangeThreeForTwo(){
		return new OfferOrangeThreeForTwo();
	}

}
