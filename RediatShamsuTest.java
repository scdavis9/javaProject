package src;


import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
public class RediatShamsuTest {

	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void testConstructorSanity() {
		Disk testDisk1 = new Disk();
		Disk testDisk2 = new Disk();
		assertEquals(testDisk1.dateMap,testDisk2.dateMap);
		assertEquals(testDisk1.diskMap,testDisk2.diskMap);
	}
	@Test 
	public void testSaveData() {
		Disk testDisk = new Disk();
		Integer serviceCode = 99;
		Integer memNum = 11;
		Integer provNum = 10;
		testDisk.saveData(new Date(), serviceCode, "Comment", memNum, provNum);
		Vector<String> latestEntry = testDisk.diskMap.get(serviceCode);
		assertEquals(Integer.parseInt(latestEntry.get(1)),serviceCode,0);
		assertEquals(Integer.parseInt(latestEntry.get(3)),memNum,0);
	}
	@Test
	public void testServiceMemberConstructorSanity() {
		ServiceMember testMem1 = new ServiceMember("03-12-2004","04-29-2022",456,"Jon"
				,12,53,"f","g");
		ServiceMember testMem2 = new ServiceMember("03-12-2004","04-29-2022",456,"Jon"
				,12,53,"f","g");		
		assertEquals(testMem1.dateOfService,testMem2.dateOfService);
		assertEquals(testMem1.currentDateAndTime,testMem2.currentDateAndTime);
		assertEquals(testMem1.comments,testMem2.comments);
	}
}
