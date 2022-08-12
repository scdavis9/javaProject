package src;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShelbyDeermanJUnit {

	@BeforeEach
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSetServiceCode() {
		int code = 138469;
		BillingInfo.setServiceCode(code);
		assertEquals(BillingInfo.serviceCode, code);
	}
	
	@Test 
	public void testCheckServiceCode() {
		final String name;
		int code = 138469;
		name = ProviderDirectory.checkServiceCode(code);
		try {
			if (name != "Therapy Session") {
				throw new Exception();
			}
		}
		catch(Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testIsValidPassword() {
		String psswd = "lkjdfslkjfsdI*";
		Main.isValidPassword(psswd);
	}

}
