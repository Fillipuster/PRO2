package opgave01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BilforsikringTest {

	Bilforsikring bf = new Bilforsikring();
	
	@Before
	public void setUp() throws Exception {
		bf.setGrundpræmie(1000);
	}

	@Test
	public void tc1() {
		assertEquals(1187.5d, bf.beregnPræmie(20, true, 2), 0.1d);
	}
	
	@Test
	public void tc2() {
		assertEquals(850d, bf.beregnPræmie(25, false, 3), 0.1d);
	}
	
	@Test
	public void tc3() {
		assertEquals(850d, bf.beregnPræmie(45, false, 5), 0.1d);
	}
	
	@Ignore("Exception not considered.")
	public void tc4() {
		assertEquals(890.625d, bf.beregnPræmie(18, true, 6), 0.1d);
	}
	
	@Ignore("Exception not considered.")
	public void tc5() {
		assertEquals(890.625d, bf.beregnPræmie(24, true, 8), 0.1d);
	}
	
	@Test
	public void tc6() {
		assertEquals(650d, bf.beregnPræmie(30, false, 9), 0.1d);
	}
	
	@Test
	public void tc7() {
		try {
			bf.beregnPræmie(8, true, 0);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Du er for ung til at tegne en forsikring", e.getMessage());
		}
	}
	
	@Test
	public void tc8() {
		try {
			bf.beregnPræmie(19, false, -9001);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Antal skade frie år skal være positiv", e.getMessage());
		}
	}

}
