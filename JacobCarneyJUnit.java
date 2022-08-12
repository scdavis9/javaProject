package src;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JacobCarneyJUnit {

	@BeforeEach
	void setUpProvider() throws Exception {
		ProviderFiles.insertProvider("Dr. Joe", 898989898, "1 Lose Street", "Lose", "MD", 11111);
	}
	
	@BeforeEach
	void setUpMember() throws Exception{
		MemberFiles.insertMember("Joe", 123456788, "1 Win Street", "Win", "MD", 11111);
	}
	
	
	@Test
	void test() {
		Member testMem = new Member("Shawn",423567890,"Hippo drive","FOE","KY",10234);
		String nameTest = "Shawn";
		//Member.name=nameUse;
		assertEquals(nameTest, testMem.getName());
	}

	@Test
	void testForFailure() {
		try {
			final ByteArrayOutputStream out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));
			ProviderReport.printProviderReport(898989898);
			final String written = out.toString();
			String thing = "----------------MEMBER REPORT---------------------"+"\n" +
					"Name: Joe" + "\n" +
					"Member number: 123456788"+"\n" +
					"Address: 1 Win Street"+"\n" +
					"City: Win"+"\n" +
					"State: MD"+"\n" +
					"Zip Code: 11111"+"\n" +
					"--------------END MEMBER REPORT-------------------";
			if(thing != written) {
				throw new Exception();
			}
		}
		catch (Exception e){
			assertTrue(true);
		}
		
	}
	
	@Test
	void testForSuccess() {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		MemberReport.printMemberReport(123456788);
		final String written = out.toString();
		assertEquals(
				"----------------MEMBER REPORT---------------------"+"\n" +
				"Name: Joe" + "\n" +
				"Member number: 123456788"+"\n" +
				"Address: 1 Win Street"+"\n" +
				"City: Win"+"\n" +
				"State: MD"+"\n" +
				"Zip Code: 11111"+"\n" +
				"--------------END MEMBER REPORT-------------------", written);
	}

}
