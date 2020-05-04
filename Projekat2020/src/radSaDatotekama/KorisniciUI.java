package radSaDatotekama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import model.automobili.Automobil;
import model.enumeracije.Gorivo;
import model.enumeracije.MarkaModelDeo;
import model.enumeracije.Pol;
import model.enumeracije.Specijalizacija;
import model.enumeracije.Statusi;
import model.korisnici.Admin;
import model.korisnici.Musterija;
import model.korisnici.Serviser;
import model.servis.Deo;
import model.servis.Servis;

public class KorisniciUI {
	private ArrayList<Musterija> musterije;
	private ArrayList<Serviser> serviseri;
	private ArrayList<Admin> admini;
	private ArrayList<Automobil> automobili;
	//ocitavanje fajlova
	private ArrayList<Deo> delovi;
	private ArrayList<Servis> servisi;
	
	
	
	public KorisniciUI() {
		this.musterije = new ArrayList<Musterija>();
		this.serviseri = new ArrayList<Serviser>();
		this.admini = new ArrayList<Admin>();
		this.automobili = new ArrayList<Automobil>();
		this.delovi = new ArrayList<Deo>();
		this.servisi = new ArrayList<Servis>();
	}
	
//-----------------------------------------------------------------------------	
	public ArrayList<Musterija> getMusterija(){
		return musterije;
		
	}
	public void dodajMusteriju(Musterija musterija) {
		this.musterije.add(musterija);
	}

	
	public Musterija nadjiMusteriju(int IDOznaka) {
		for (Musterija musterija : musterije) {
			if (musterija.getIDOznaka()==(IDOznaka)) {
				return musterija;
			}
		}
		return null;
	}
//-------------------------------------------------------------------------------------------

	
	
	public void dodajServisera(Serviser serviser) {
		this.serviseri.add(serviser);
	}
	
	public Serviser nadjiServisera(int IDOznaka) {
		for (Serviser serviser : serviseri) {
			if (serviser.getIDOznaka()==(IDOznaka)) {
				return serviser;
			}
		}
		return null;
	}
	
//--------------------------------------------------------------------------------------------------------	
	
	public ArrayList<Automobil> getAutomobil(){
		return automobili;
	}
	
	public void dodajAutomobil(Automobil automobil) {
		this.automobili.add(automobil);
	}
	public Automobil nadjiAutomobil(int idOznaka) {
		for (Automobil automobil : automobili) {
			if (automobil.getIdOznaka()==(idOznaka)) {
				return automobil;
			}
		}
		return null;
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------
	
	
	public ArrayList<Admin> getAdmin(){
		return admini;		
	}
	public void dodajAdmina(Admin admin) {
		this.admini.add(admin);
	}
	
	
	
	
	public ArrayList<Deo> getDeo(){
		return delovi;
	}
	public void dodajDeo(Deo deo) {
		this.delovi.add(deo);
	}

	
	public Deo nadjiDeo(String naziv) {
		for (Deo deo : delovi) {
			if (deo.getNaziv().equals(naziv)) {
				return deo;
			}
		}
		return null;
	}
	
	
	public ArrayList<Servis> getServis(){
		return servisi;
	}
	

	
	
	
	
//---------------------------------------------------RAD SA MUSTERIJAMA----------------------------------------------------------------------------	

	public void ucitajMusteriju() {
		try {
			File musterijeFile = new File("src/txt/musterija.txt");
			BufferedReader reader = new BufferedReader(new FileReader(musterijeFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				int brojSakupljenihBodova = Integer.parseInt(split[9]);
				int IDOznaka = Integer.parseInt(split[0]);
				String ime = split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String indeksPol =split[4];
				Pol pol  = Pol.valueOf(indeksPol);
				String adresa = split[5];
				String brojTelefona = split[6];
				String username = split[7];
				String lozinka = split[8];
				Musterija musterija = new Musterija(ime, prezime, jmbg, pol, brojTelefona, adresa, username, lozinka, IDOznaka, brojSakupljenihBodova);
				musterije.add(musterija);
				System.out.println(musterija);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}

	public void snimiMusteriju() {
		try {
			File file = new File("src/txt/musterija.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Musterija musterija : musterije) {
				
				sadrzaj += musterija.toString() +"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	//-------------------------RAD SA SERVISERIMA----------------------------------------------------------------------------------------*

	public void ucitajServisera() {
		try {
			File serviserFile = new File("src/txt/serviser.txt");
			BufferedReader reader = new BufferedReader(new FileReader(serviserFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				int IDOznaka = Integer.parseInt(split[0]);
				String ime = split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String polInt = split[4];
				Pol pol  = Pol.valueOf(polInt);
				String adresa = split[5];
				String brojTelefona = split[6];
				String username = split[7];
				String lozinka = split[8];
				double plata = Double.parseDouble(split[9]);
				String indeksSpec = split[10];
				
				Specijalizacija specijalizacija = Specijalizacija.valueOf(indeksSpec);
				Serviser serviser = new Serviser(ime, prezime, jmbg, pol, brojTelefona, adresa, username, lozinka, IDOznaka, plata, specijalizacija);
				serviseri.add(serviser);
				System.out.println(serviser);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}
	
	public void snimiServisera() {
		try {
			File file = new File("src/txt/serviser.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Serviser serviser : serviseri) {
				
				sadrzaj += serviser.toString() +"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//---------------------RAD SA ADMINIMA--------------------------------------------------------------------
	
	public void ucitajAdmina() {
		try {
			File adminFile = new File("src/txt/admini.txt");
			BufferedReader reader = new BufferedReader(new FileReader(adminFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				int IDOznaka = Integer.parseInt(split[0]);
				String ime = split[1];
				String prezime = split[2];
				String jmbg = split[3];
				String indeksPol = split[4];
				Pol pol  = Pol.valueOf(indeksPol);
				String adresa = split[5];
				String brojTelefona = split[6];
				String username = split[7];
				String lozinka = split[8];
				double plata = Double.parseDouble(split[9]);
				Admin admin = new Admin(ime, prezime, jmbg, pol, brojTelefona, adresa, username, lozinka, IDOznaka, plata);
				admini.add(admin);
				System.out.println(admin);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}

	public void snimiAdmina() {
		try {
			File file = new File("src/txt/admini.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Admin admin : admini) {
				
				sadrzaj += admin.toString() +"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
// ----------------------------------- OCITAVANJE AUTOMOBILA---------------------------------------------------------------------------------------------------
	public void ucitajAutomobil() {
		try {
			File autoFile = new File("src/txt/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(autoFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				int id1 = Integer.parseInt(split[0]);

				Musterija IDOznaka = nadjiMusteriju(id1);
				String indeksMarka = split[1];
				MarkaModelDeo markaModel = MarkaModelDeo.valueOf(indeksMarka);
				int godinaProizvodnje = Integer.parseInt(split[2]);
				String zapreminaMotora = split[3];
				String snaga = split[4];
				String indeksGorivo = split[5];
				Gorivo vrstaGoriva = Gorivo.valueOf(indeksGorivo);
				int id = Integer.parseInt(split[6]);
				Automobil automobil = new Automobil(IDOznaka, markaModel, godinaProizvodnje, zapreminaMotora, snaga, vrstaGoriva, id);
				automobili.add(automobil);
				System.out.println(automobil);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}
	
	public void snimiAutomobil() {
		try {
			File file = new File("src/txt/automobili.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Automobil automobil : automobili) {
				
				sadrzaj += automobil.getVlasnikId() +"|"+ automobil.toString() +"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
	
//    -------------              OCITAVANJE SERVISA	---------------------------------------------------------------------------------------------
	
	
	
	public void ucitajDeo() {
		try {
			File deoFile = new File("src/txt/deo.txt");
			BufferedReader reader = new BufferedReader(new FileReader(deoFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				String markaindex = split[0];
				MarkaModelDeo markamodel = MarkaModelDeo.valueOf(markaindex);
				String naziv = split[1];
				double cena = Double.parseDouble(split[2]);
				int id = Integer.parseInt(split[3]);	
				Deo deo = new Deo(markamodel, naziv, cena, id);
				delovi.add(deo);
				System.out.println(deo);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}
	
	
	
	public void snimiDeo() {
		try {
			File file = new File("src/txt/deo.txt");
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Deo deo : delovi) {
				
				sadrzaj += deo.toString() +"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static ArrayList<Deo> getIdDela(String[] delovi){
		ArrayList<Deo> delovi1 = new ArrayList<Deo>();
		
		for (int i = 0; i < delovi.length; i++) {
			String idStr = delovi[i];
			for (Deo deo : delovi1) {
				if(idStr.equals(deo.getIdDela())) {
					delovi1.add(deo);
				}
			}
			
		}
		return delovi1;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void ucitajServis() {
		try {
			File servisFile = new File("src/txt/servis.txt");
			BufferedReader reader = new BufferedReader(new FileReader(servisFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				int id1 = Integer.parseInt(split[0]);
				Automobil idOznaka = nadjiAutomobil(id1);
				int idserv = Integer.parseInt(split[1]);
				Serviser idServisera = nadjiServisera(idserv);
				String datum = split[2];
				String opis = split[3];
				ArrayList<Deo> delovi = new ArrayList<Deo>();
				int deo1 = Integer.parseInt(split[4]);
				//Deo deo12 = getIdDela(deo1);
				String statusIndex = split[5];
				Statusi statusi = Statusi.valueOf(statusIndex);
				int idoznaka = Integer.parseInt(split[6]);
				Servis servis = new Servis(idOznaka, idServisera, datum, opis, delovi, statusi, idoznaka);
				servisi.add(servis);
				System.out.println(servis);
				
			}
			reader.close();
			
									
		}catch(IOException e) {
			System.out.println("Problem sa ocitavanjem");
		}
	}	

	
	
	
	

	
}

