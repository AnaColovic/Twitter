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
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
	if (tag==null || tag.isEmpty())
	throw new RuntimeException("Morate uneti tag");
	//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
	if (maxBroj<=0)
	maxBroj = 100;
	//Pomocna promenljiva koja predstavlja brojac upisanih poruka
	int brojac = 0;
	//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
	//sve poruke koje u sebi imaju zadati tag
	TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
	//Pretrazuju se poruke i traze se one koje sadrze tag.
	//Ako se nadje neka takva, i ako nije prekoracen maxBroj
	//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
	//se prekida.				
	for (int i = 0; i < poruke.size(); i++)
	if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
	if (brojac < maxBroj){
	rezultat[brojac]=poruke.get(i);
	brojac++;
		}
	else break;
	return rezultat;
	} 			
}
