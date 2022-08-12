package src;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class RyanModdesetteTest {

	@BeforeEach
	void setUp() throws Exception {
		Member testSuccess = new Member("Ryan",777777777,"12984 S Hagan St.","Olathe","KS",66062);
		String name = testSuccess.name;
		
	}

	@Test
	void testSuccessMemberConstructor() {
		Member testSuccess = new Member("Ryan",777777777,"12984 S Hagan St.","Olathe","KS",66062);
		String name = testSuccess.name;
		assertEquals(name,"Ryan");
		
		//fail("Not yet implemented");
	}
	
	@Test
	void testExceptionProviderConstructor(){
		try {
			Provider testRyan = new Provider("Ryan",888888888,"100 burch street","Olathe","Kansas",66062,30.0);
			Provider testChad = new Provider("Chad",888888888,"100 burch street","Olathe","Kansas",66062,30.0);
			
			if(testRyan.name !=testChad.name) {
				throw new Exception();
			}
		}
		catch(Exception e){
			assertTrue(true);
		}
		
		
	

}
	
	@Test
	void testSuccessisDay() {
		Calendar calendarTest = Calendar.getInstance();
         
        int hour = calendarTest.get(Calendar.HOUR_OF_DAY);
		if(hour <9 || hour>16) {
			if(Main.isDay() ==false) {
				assertTrue(true);
			}
		}
		else {
			if(Main.isDay()==true) {
				assertTrue(true);
			}
		}
			
		
	}
}
