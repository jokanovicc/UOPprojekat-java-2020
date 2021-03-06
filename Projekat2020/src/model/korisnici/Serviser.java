package model.korisnici;

import model.enumeracije.Pol;
import model.enumeracije.Specijalizacija;

public class Serviser extends Korisnik {
	
	private double plata;
	private Specijalizacija specijalizacija;
	
	
	public Serviser() {
		super();
		this.plata = 0;
		this.specijalizacija = Specijalizacija.AUTOELEKTRICAR;
	}

	




	public Serviser(String ime, String prezime, String jmbg, Pol pol, String brojTelefona, String adresa,
			String username, String lozinka, String iDOznaka, boolean obrisan, double plata,
			Specijalizacija specijalizacija) {
		super(ime, prezime, jmbg, pol, brojTelefona, adresa, username, lozinka, iDOznaka, obrisan);
		this.plata = plata;
		this.specijalizacija = specijalizacija;
	}






	public double getPlata() {
		return plata;
	}


	public void setPlata(double plata) {
		this.plata = plata;
	}


	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}


	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}


	@Override
	public String toString() {
		return IDOznaka + "|" + ime + "|" + prezime
				+ "|" + jmbg + "|" + pol + "|" + brojTelefona + "|" + adresa
				+ "|" + username + "|" + lozinka + "|" + plata + "|" + specijalizacija +"|" + isObrisan();
	}
	
	public String toString2() {
		return IDOznaka + "|" + ime + "|" + prezime
				+ "|" + jmbg + "|" + pol.ordinal() + "|" + brojTelefona + "|" + adresa
				+ "|" + username + "|" + lozinka + "|" + plata + "|" + specijalizacija.ordinal() +"|" + isObrisan();
	}
	
	





}

