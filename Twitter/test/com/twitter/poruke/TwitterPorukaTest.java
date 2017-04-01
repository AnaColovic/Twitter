package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {
	private TwitterPoruka t;
	
	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		t.setKorisnik(null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazan() {
		t.setKorisnik("");
	}
	
	@Test
	public void testSetKorisnik() {
		t.setKorisnik("Ana Colovic");
		assertEquals("Ana Colovic", t.getKorisnik());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		t.setPoruka(null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazan() {
		t.setPoruka("");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzina() {
		t.setPoruka("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@Test
	public void testSetPoruka() {
		t.setPoruka("Cao cao");
		assertEquals("Cao cao", t.getPoruka());
	}
	
	@Test
	public void testToString() {
		t.setKorisnik("Ana Colovic");
		t.setPoruka("Poruka");
		assertEquals("KORISNIK:Ana Colovic PORUKA:Poruka", t.toString());
	}

}
