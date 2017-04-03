package com.twitter;

import java.util.LinkedList;

import com.twitter.poruke.TwitterPoruka;
/**
 * Ova klasa predstavlja Twitter koji sadrzi listu twitter poruka
 * @author Ana Colovic 87/15
 * @version 0.2
 */
public class Twitter {
	/**
	 * Lista twitter poruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * Ova metoda vraca listu sa svim twitter porukama
	 * @return listu koja sadrzi TwitterPoruke
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
	return poruke;
		}
			
	/**
	 * Ova metoda pravi novu TwitterPoruku, puni je prosledjenim podacima i unosi je na kraj liste poruke
	 * @param korisnik predstavlja ime korisnika koji unosi novu poruku
	 * @param poruka predstavlja tekst nove poruke koju korisnik unosi
	 */
	public void unesi(String korisnik, String poruka) {
	
	TwitterPoruka tp = new TwitterPoruka();
	tp.setKorisnik(korisnik);
	tp.setPoruka(poruka);
	
	poruke.addLast(tp);
		}
			
	/**
	 * Ova metoda pretrazuje listu poruke kako bi pronasla sve TwitterPoruke koje sadrze prosledjeni tag, unosi ih u pomocan niz rezultat, ciji je kapacitet prosledjeni maxBroj i nakon pretrage vraca niz rezultat
	 * @param maxBroj predstavlja kapacitet pomocnog niza rezultat, odnosno maksimalni broj poruka koje mozemo pronaci
	 * @param tag predstavlja naziv taga za koji zelimo da pronadjemo sve TwitterPoruke u kojima je upotrebljen
	 * @return pomocni niz rezultat u kojem se nalaze sve TwitterPoruke koje sadrze zadati tag
	 * @throws java.lang.RuntimeException ako je vrednost promenljive tag:
	 * <ul>
	 * <li> null vrednost
	 * <li> prazan String
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
	if (tag==null || tag.isEmpty())
	throw new RuntimeException("Morate uneti tag");
	if (maxBroj<=0)
	maxBroj = 100;
	int brojac = 0;
	TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];				
	for (int i = 0; i < poruke.size(); i++){
	if (poruke.get(i).getPoruka().indexOf(tag)!=-1){
	if (brojac < maxBroj){
	rezultat[brojac]=poruke.get(i);
	brojac++;
		}
	else break;
	}
	}
	return rezultat;
	} 			
}
