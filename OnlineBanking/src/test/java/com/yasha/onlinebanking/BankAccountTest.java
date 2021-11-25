package com.yasha.onlinebanking;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
 
public class BankAccountTest {
@Test
	public void testIdIsAutomaticallyAssignedAsPositiveNumber() {
		// setup
		BankAccount bankAccount = new BankAccount();
		// verify
		assertTrue("Id should be positive", bankAccount.getId() > 0);
	}

	@Test
	public void testIdsAreIncremental() {
		BankAccount firstAccount = new BankAccount();
		BankAccount secondAccount = new BankAccount();
		assertTrue("Ids should be incremental",
			firstAccount.getId() < secondAccount.getId());
	}

	// WRONG VERSION!
	// Works only if this is the first executed test
//	@Test
//	public void testIdsAreIncrementalWrong() {
//		BankAccount firstAccount = new BankAccount();
//		BankAccount secondAccount = new BankAccount();
//		assertEquals(1, firstAccount.getId());
//		assertEquals(2, secondAccount.getId());
//	}

	@Test
	public void testDepositWhenAmountIsCorrectShouldIncreaseBalance() {
		// setup
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(INITIAL_BALANCE);
		// exercise
		bankAccount.deposit(AMOUNT);
		// verify
		assertEquals(INITIAL_BALANCE+AMOUNT, bankAccount.getBalance(), 0);
	}

	@Test
	public void testDepositWhenAmountIsNegativeShouldThrow() {
		// setup
		BankAccount bankAccount = new BankAccount();
		try {
			// exercise
			bankAccount.deposit(-1);
			fail("Expected an IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			// verify
			assertEquals("Negative amount: -1.0", e.getMessage());
			assertEquals(0, bankAccount.getBalance(), 0);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDepositWhenAmountIsNegativeShouldThrowWithExpected() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.deposit(-1);
	}

	@Test
	public void testDepositWhenAmountIsNegativeShouldThrowWithExpectedException() {
		BankAccount bankAccount = new BankAccount();
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Negative amount: -1.0");
		bankAccount.deposit(-1);
		// but we can't perform further assertions...
	}

	@Test
	public void testDepositWhenAmountIsNegativeShouldThrowWithAssertThrows() {
		BankAccount bankAccount = new BankAccount();
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
			() -> bankAccount.deposit(-1));
		// perform assertions on the thrown exception
		assertEquals("Negative amount: -1.0", e.getMessage());
		// and we can perform further assertions...
		assertEquals(0, bankAccount.getBalance(), 0);
	}

	@Test
	public void testWithdrawWhenAmountIsNegativeShouldThrow() {
		BankAccount bankAccount = new BankAccount();
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
			() -> bankAccount.withdraw(-1));
		assertEquals("Negative amount: -1.0", e.getMessage());
		assertEquals(0, bankAccount.getBalance(), 0);
	}

	@Test
	public void testWithdrawWhenBalanceIsUnsufficientShouldThrow() {
		BankAccount bankAccount = new BankAccount();
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
			() -> bankAccount.withdraw(10));
		assertEquals("Cannot withdraw 10.0 from 0.0", e.getMessage());
		assertEquals(0, bankAccount.getBalance(), 0);
	}

	@Test
	public void testWithdrawWhenBalanceIsSufficientShouldDecreaseBalance() {
		// setup
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(INITIAL_BALANCE);
		// exercise
		bankAccount.withdraw(AMOUNT); // the method we want to test
		// verify
		assertEquals(INITIAL_BALANCE-AMOUNT, bankAccount.getBalance(), 0);
	}
}
