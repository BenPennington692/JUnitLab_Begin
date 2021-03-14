package csc131.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.Test;

class GiftCardTest {

	@Test
	public void testGetIssuingStore() {
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
	}
	
	@Test
	public void testGetBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	
	@Test
	public void deduct_RemainingBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		String s;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		s = "Remaining Balance: " + String.format("%6.2f", 90.00);
		assertEquals("deduct(10.00)", s, card.deduct(10.00));
	}
	
	@Test
	public void deductInvalidAmount() {
		double balance;
		GiftCard card;
		int issuingStore;
		String s;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		s = "Invalid Transaction";
		assertEquals("deduct(-10.00)", s, card.deduct(-10.00));
	}
	
	@Test
	public void deductInvalidBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		String s;
		
		issuingStore = 1337;
		balance = 10.00;
		card = new GiftCard(issuingStore, balance);
		
		s = "Amount Due: " + String.format("%6.2f", Math.abs(balance));
		assertEquals("deduct(20.00)", s, card.deduct(20.00));
	}
	
	@Test
	public void openingBalance_Low() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_Low() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_High() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000,100.00);});
	}

}
