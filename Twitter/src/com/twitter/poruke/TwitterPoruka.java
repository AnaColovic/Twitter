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
	 * Meotda koja postavlja vrednost atributa korisnik na prosledjenu vrednost
	 * @param korisnik predstavlja vrednost na koju koju zelimo da postavimo atribut korisnik
	 * @throws java.lang.RuntimeException ako je prosledjeni korisnik: 
	 * <ul>
	 * <li> null vrednost
	 * <li> prazan String
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
	if (korisnik==null || korisnik.isEmpty())
	throw new RuntimeException("Ime korisnika mora biti uneto");
	this.korisnik = korisnik;
	}
	/**
	 * Metoda koja vraca vrednost atributa poruka
	 * @return vrednost poruke kao String
	 */
	public String getPoruka() {
	return poruka;
	}
	/**
	 * Metoda koja postavlja vrednost atributa poruka na prosledjenu vrednost
	 * @param poruka predstavlja vrednost na koju zelimo da postavimo atribut poruka
	 * @throws java.lang.RuntimeException ako je prosledjena poruka: 
	 * <ul>
	 * <li> null vrednost
	 * <li> prazan String
	 * <li> String duzi od 140 znakova
	 * </ul>
	 */
	public void setPoruka(String poruka) {
	if (poruka==null || poruka.isEmpty() || poruka.length()>140)
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
