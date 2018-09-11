package opgave02;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class BødeRegnerTest {

	BødeRegner br = new BødeRegner();
	LocalDate beregnetDato = LocalDate.of(2000, 1, 1);
	
	@Test
	public void tc1() {
		assertEquals(10, br.beregnBøde(beregnetDato, LocalDate.of(2000, 1, 2), false));
	}
	
	@Test
	public void tc2() {
		assertEquals(20, br.beregnBøde(beregnetDato, LocalDate.of(2000, 1, 7), true));
	}
	
	@Test
	public void tc3() {
		assertEquals(30, br.beregnBøde(beregnetDato, LocalDate.of(2000, 1, 9), false));
	}
	
	@Test
	public void tc4() {
		assertEquals(60, br.beregnBøde(beregnetDato, LocalDate.of(2000, 1, 14), true));
	}
	
	@Test
	public void tc5() {
		assertEquals(45, br.beregnBøde(beregnetDato, LocalDate.of(2000, 1, 16), false));
	}
	
	@Test
	public void tc6() {
		assertEquals(90, br.beregnBøde(beregnetDato, LocalDate.of(2000, 1, 17), true));
	}
	
	@Test
	public void tc7() {
		try {
			br.beregnBøde(beregnetDato, LocalDate.of(1999, 12, 31), false);
			fail();
		} catch (RuntimeException e) {
			assertEquals("Bog ikke afleveret for sent.", e.getMessage());
		}
	}
	
	@Test(expected=RuntimeException.class)
	public void tc7b() {
		br.beregnBøde(beregnetDato, LocalDate.of(1999, 12, 31), false);
		fail();
	}

}
