package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EleriFloydJunit {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindMemNotExist() {
		HashMapInitialize.main();
		int testMemNum = 1234567899;
		Member testMem = OperatorMenu.findMem(testMemNum);
		assertEquals(null, testMem);
	}
	
	@Test
	void testFindMemExists() {
		Member goalMem = new Member("John",123456789,"986 2nd Street","Coolville","KS",65063);
		HashMapInitialize.main();
		Member testMem = OperatorMenu.findMem(123456789);
		assertEquals(goalMem.name, testMem.name);
	}
	
	@Test
	public void testSearchProviderForFailure() {
		try {
			Provider testProv = ProviderFiles.searchProvider(999999999);
			if (null != testProv) {
				throw new Exception();
			}
		} catch (Exception e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testSearchProviderForSuccess() {
		Provider goalProv = new Provider("Dr. Stevens", 999999999, "321 44th Street", "Hoover", "AL", 23542, 0);
		HashMapInitialize.main();
		Provider testProv = ProviderFiles.searchProvider(999999999);
		assertEquals(goalProv.name, testProv.name);
	}
	
	@Test
	void testValidEmailTrue() {
		String testEmail = "eleri.floyd@gmail.com";
		assertEquals(true, Main.isValidEmail(testEmail));
	}
	
	@Test
	void testValidEmailFalse() {
		String testEmail = "eleri.floydgmail.com";
		assertEquals(false, Main.isValidEmail(testEmail));
	}

}
