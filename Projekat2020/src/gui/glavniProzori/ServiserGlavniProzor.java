package gui.glavniProzori;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.FormeZaPrikaz.PrikazAdmin.DeloviProzorPrikaz;
import gui.FormeZaPrikaz.PrikazAdmin.MusterijaProzorPrikaz;
import gui.FormeZaPrikazServiser.AutoPrikazInfo;
import gui.FormeZaPrikazServiser.DeoPrikazInfo;
import gui.FormeZaPrikazServiser.MusterijaPrikazInfo;
import gui.FormeZaPrikazServiser.ServiserPrikazInfo;
import gui.FormeZaPrikazServiser.ServisiPrikazInfo;
import model.korisnici.Korisnik;
import radSaDatotekama.Datoteke;

public class ServiserGlavniProzor extends JFrame {
	private JMenuBar mainMenu  = new JMenuBar();
	private JMenu korisniciMenu = new JMenu("Korisnici");
	private JMenuItem musterijeItem = new JMenuItem("Musterije");
	private JMenuItem serviseriItem = new JMenuItem("Moje informacije");

	private JMenu servisMenu = new JMenu("Servis");
	private JMenuItem servisItem = new JMenuItem("Servisi");;
	private JMenuItem deoItem = new JMenuItem("Delovi");
	private JMenu automobilMeni = new JMenu("Automobili");
	private JMenuItem automobilItem = new JMenuItem("Svi automobili");
	JLabel lblLogo = new JLabel(new ImageIcon("src/slike/serviser.png"));


	private Datoteke podaci;
	private Korisnik prijavljenKorisnik;
	
	
	public ServiserGlavniProzor(Datoteke podaci, Korisnik prijavljenKorisnik) {
		this.podaci = podaci;
		this.prijavljenKorisnik = prijavljenKorisnik;
		setTitle("Serviser: " + prijavljenKorisnik.getUsername());
		setSize(500, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
	}
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		add(lblLogo);
		mainMenu.add(korisniciMenu);
		korisniciMenu.add(serviseriItem);
		korisniciMenu.add(musterijeItem);
		
		mainMenu.add(servisMenu);
		servisMenu.add(servisItem);
		servisMenu.add(deoItem);
		
		mainMenu.add(automobilMeni);
		automobilMeni.add(automobilItem);
		
	}
	
	private void initActions() {
		
		serviseriItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServiserPrikazInfo ssi = new ServiserPrikazInfo(podaci,prijavljenKorisnik);
				ssi.setVisible(true);
				
			}
			
		});
		
		musterijeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MusterijaPrikazInfo mpp = new MusterijaPrikazInfo(podaci);
				mpp.setVisible(true);
				
			}
		});
		
		automobilItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AutoPrikazInfo api = new AutoPrikazInfo(podaci);
				api.setVisible(true);
				
			}
		});
		
		deoItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeoPrikazInfo dpp = new DeoPrikazInfo(podaci);
				dpp.setVisible(true);
				
			}
		});
		
		servisItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServisiPrikazInfo spi = new ServisiPrikazInfo(podaci, prijavljenKorisnik);
				spi.setVisible(true);
				
			}
		});
		
		
		
	}

}
