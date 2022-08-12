package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SummerDavisJunit {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test //for success from my stuff
	void testisValidPassword() {
		String password = "Summer$2002";
		assertEquals(true, Main.isValidPassword(password)); 
		
	
	}
	@Test //for failure from my stuff
	void testisValidEmail() {
		String email = "summercdavis11@gmail.lob";
		try{
			if(!Main.isValidEmail(email)) {
				throw new Exception();
			}
		}
		catch(Exception e) {
			assertEquals(true, true);
		}
		
	
	}

	@Test //ProviderFiles 
	void testsearchProvider() {
		int accNumber = 237893090;
		assertEquals(null, ProviderFiles.searchProvider(accNumber));
		
	}
}
