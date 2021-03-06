package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	Twitter t;
	
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testUnesi() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Ana");
		tp.setPoruka("Poruka");
		t.unesi(tp.getKorisnik(), tp.getPoruka());
		assertEquals(t.vratiSvePoruke().getLast(), tp);
	}
	
	@Test
	public void testUnesi1() {
		int brojEl=t.vratiSvePoruke().size();
		t.unesi("Ana", "Cao cao");
		assertEquals(brojEl+1, t.vratiSvePoruke().size());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		t.vratiPoruke(100, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazan() {
		t.vratiPoruke(100, "");
	}
	
	@Test
	public void testVratiPoruke0() {
		assertEquals(t.vratiPoruke(0, "Cao").length, 100);
	}
	
	@Test 
	public void testVratiPoruke() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Ana");
		tp.setPoruka("Cao cao");
		t.unesi(tp.getKorisnik(), tp.getPoruka());
		assertEquals(tp, t.vratiPoruke(1, "cao")[0]);
	}
	
	@Test
	public void testVratiPorukePrekoracenjeMax() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Ana");
		tp.setPoruka("Cao cao");
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("Milos");
		tp1.setPoruka("Cao cao");
		t.unesi(tp.getKorisnik(), tp.getPoruka());
		t.unesi(tp1.getKorisnik(), tp1.getPoruka());
		assertEquals(tp, t.vratiPoruke(1, "cao")[0]);
	}
	
	@Test 
	public void testVratiPorukeVise() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Ana");
		tp.setPoruka("Cao cao");
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("Milos");
		tp1.setPoruka("Cao cao");
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("Milos");
		tp2.setPoruka("Poruka");
		t.unesi(tp.getKorisnik(), tp.getPoruka());
		t.unesi(tp1.getKorisnik(), tp1.getPoruka());
		t.unesi(tp2.getKorisnik(), tp2.getPoruka());
		TwitterPoruka[] niz = new TwitterPoruka[10];
		niz[0]=tp;
		niz[1]=tp1;
		assertArrayEquals(niz, t.vratiPoruke(10, "cao"));
	}

}
