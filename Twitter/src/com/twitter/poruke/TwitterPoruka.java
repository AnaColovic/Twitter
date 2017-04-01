package com.twitter.poruke;
/**
 * Klasa koja predstavlja twitter poruku
 * @author Ana Colovic 87/15
 * @version 0.1
 */
public class TwitterPoruka {
	/**
	 * Ime korisnika twitter-a
	 */
	private String korisnik;
	/**
	 * Poruka koju korisnik salje na twitter-u
	 */
	private String poruka;
	/**
	 * Metoda koja vraca vrednost atributa korisnik
	 * @return vrednost atributa korisnika kao String
	 */
	public String getKorisnik() {
	return korisnik;
	}
	/**
	 * Meotda koja postavlja vrednost atributa korisnik na prosledjenu vrednost samo ako:
	 * <ul>
	 * <li> korisnik nije null vrednost
	 * <li> korisnik nije prazan String
	 * </ul>
	 * U suprotnom:
	 * @throws java.lang.RuntimeException
	 * @param korisnik predstavlja vrednost na koju koju zelimo da postavimo atribut korisnik
	 */
	public void setKorisnik(String korisnik) {
	if (korisnik==null || !korisnik.isEmpty())
	throw new RuntimeException("Ime korisnika mora biti uneto");
	this.korisnik = korisnik;
	}
	/**
	 * Metoda koja vraca vrednost atributa poruka
	 * @return vrednost poruke kao String
	 */
	public String getPoruka() {
	return "poruka";
	}
	/**
	 * Metoda koja postavlja vrednost atributa poruka na prosledjenu vrednost samo ako:
	 * <ul>
	 * <li> poruka nije null vrednost
	 * <li> poruka nije prazan String
	 * <li> poruka nije String duzi od 140 znakova
	 * </ul>
	 * U suprotnom:
	 * @throws java.lang.RuntimeException
	 * @param poruka predstavlja vrednost na koju zelimo da postavimo atribut poruka
	 */
	public void setPoruka(String poruka) {
	if (this.poruka==null || this.poruka == new String("") || this.poruka.length()>140)
	throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
	this.poruka = poruka;
	}
	/**
	 * Vraca String sa podacima o twitter poruci
	 * @return podatke o korisniku i poruci uz odgovarajuci tekst
	 */
	public String toString(){
	return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	} 
	
}
