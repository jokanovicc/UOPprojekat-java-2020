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
import model.enumeracije.AutoMarka;
import model.enumeracije.AutoModel;
import model.enumeracije.Gorivo;
import model.enumeracije.MarkaModelDeo;
import model.enumeracije.Pol;
import model.enumeracije.Specijalizacija;
import model.korisnici.Admin;
import model.korisnici.Musterija;
import model.korisnici.Serviser;
import model.servis.Servis;

public class KorisniciUI {
	private ArrayList<Musterija> musterije;
	private ArrayList<Serviser> serviseri;
	private ArrayList<Admin> admini;
	private ArrayList<Automobil> automobili;
	//ocitavanje fajlova
	
	
	public KorisniciUI() {
		this.musterije = new ArrayList<Musterija>();
		this.serviseri = new ArrayList<Serviser>();
		this.admini = new ArrayList<Admin>();
		this.automobili = new ArrayList<Automobil>();
	}
	
//-----------------------------------------------------------------------------	
	public ArrayList<Musterija> getMusterija(){
		return musterije;
		
	}
	public void dodajMusteriju(Musterija musterija) {
		this.musterije.add(musterija);
	}

	

	//public void dodajMusteriju(Musterija musterija) {
		//this.musterije.add(musterija);
	//}
	//public void obrisiProdavca(Musterija musterija) {
		//this.musterije.remove(musterija);
	//}
	
	public Musterija nadjiMusteriju(String username) {
		for (Musterija musterija : musterije) {
			if (musterija.getUsername().equals(username)) {
				return musterija;
			}
		}
		return null;
	}
//-------------------------------------------------------------------------------------------

	public ArrayList<Serviser> getServis(){
		return serviseri;		
	}
	
	
	public void dodajServisera(Serviser serviser) {
		this.serviseri.add(serviser);
	}
	
	public ArrayList<Automobil> getAutomobil(){
		return automobili;
	}
	
	//public void dodajServisera(Serviser serviser) {
		//this.serviseri.add(serviser);
	//}	
	//public void obrisiServisera(Serviser serviser) {
		//this.serviseri.remove(serviser);
	//}
	
	//public Serviser nadjiServisera(String username) {
		//for (Serviser serviser : serviseri) {
			//if (serviser.getUsername().equals(username)) {
				//return serviser;
			//}
		//}
		//return null;
	//}
	
	
//------------------------------------------------------------------------------------------------------------------------------------
	
	
	public ArrayList<Admin> getAdmin(){
		return admini;		
	}
	public void dodajAdmina(Admin admin) {
		this.admini.add(admin);
	}
	
	//public void dodajAdmina(Admin admin) {
		//this.admini.add(admin);
	//}	
	//public void obrisiAdmina(Admin admin) {
		//this.admini.remove(admin);
	//}
	
	//public Admin nadjiAdmina(String username) {
		//for (Admin admin : admini) {
			//if (admin.getUsername().equals(username)) {
				//return admin;
			//}
		//}
		//return null;
	//}
	
	

	public void ucitajMusteriju() {
		try {
			File musterijeFile = new File("src/txt/musterija.txt");
			BufferedReader reader = new BufferedReader(new FileReader(musterijeFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				int brojSakupljenihBodova = Integer.parseInt(split[8]);
				String ime = split[0];
				String prezime = split[1];
				String jmbg = split[2];
				int indeksPol =0;
				Pol pol  = Pol.values()[indeksPol];
				String adresa = split[4];
				String brojTelefona = split[5];
				String username = split[6];
				String lozinka = split[7];
				Musterija musterija = new Musterija(ime, prezime, jmbg, pol, brojTelefona, adresa, username, lozinka, brojSakupljenihBodova);
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
	
	
	
	
	
	
	
	
	
	
	
	

	public void ucitajServisera() {
		try {
			File serviserFile = new File("src/txt/serviser.txt");
			BufferedReader reader = new BufferedReader(new FileReader(serviserFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				String ime = split[0];
				String prezime = split[1];
				String jmbg = split[2];
				int indeksPol = Integer.parseInt(split[3]);
				Pol pol  = Pol.values()[indeksPol];
				String adresa = split[4];
				String brojTelefona = split[5];
				String username = split[6];
				String lozinka = split[7];
				double plata = Double.parseDouble(split[8]);
				int indeksSpec = Integer.parseInt(split[9]);
				Specijalizacija specijalizacija = Specijalizacija.values()[indeksSpec];
				Serviser serviser = new Serviser(ime, prezime, jmbg, pol, brojTelefona, adresa, username, lozinka, plata, specijalizacija);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void ucitajAdmina() {
		try {
			File adminFile = new File("src/txt/admini.txt");
			BufferedReader reader = new BufferedReader(new FileReader(adminFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				String ime = split[0];
				String prezime = split[1];
				String jmbg = split[2];
				int indeksPol = 0;
				Pol pol  = Pol.values()[indeksPol];
				String adresa = split[4];
				String brojTelefona = split[5];
				String username = split[6];
				String lozinka = split[7];
				double plata = Double.parseDouble(split[8]);
				Admin admin = new Admin(ime, prezime, jmbg, pol, brojTelefona, adresa, username, lozinka, plata);
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
	

	public void ucitajAutomobil() {
		try {
			File autoFile = new File("src/txt/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(autoFile));
			String line = null;
			while((line = reader.readLine()) != null){
				String[] split = line.split("\\|");
				Musterija username = nadjiMusteriju(split[0]);
				int indeksMarka = Integer.parseInt(split[1]);
				MarkaModelDeo markaModel = MarkaModelDeo.values()[indeksMarka];
				int godinaProizvodnje = Integer.parseInt(split[2]);
				String zapreminaMotora = split[3];
				String snaga = split[4];
				int indeksGorivo = Integer.parseInt(split[5]);
				Gorivo vrstaGoriva = Gorivo.values()[indeksGorivo];
				String id = split[6];
				Automobil automobil = new Automobil(username, markaModel, godinaProizvodnje, zapreminaMotora, snaga, vrstaGoriva, id);
				automobili.add(automobil);
				System.out.println("\n");
				System.out.println(automobili);
				
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
				
				sadrzaj += automobil.toString() +"\n";
			}
			br.write(sadrzaj);
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

	
}

