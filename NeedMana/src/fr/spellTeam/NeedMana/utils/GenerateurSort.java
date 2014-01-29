package fr.spellTeam.NeedMana.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.badlogic.gdx.math.Vector2;

import fr.spellTeam.NeedMana.entities.Attaque;
import fr.spellTeam.NeedMana.entities.Bonus;
import fr.spellTeam.NeedMana.entities.Element;
import fr.spellTeam.NeedMana.entities.Malus;
import fr.spellTeam.NeedMana.entities.Spell;

public class GenerateurSort {
	private ArrayList<Bonus> listeBonus = new ArrayList<Bonus>();
	private ArrayList<Malus> listeMalus = new ArrayList<Malus>();
	private ArrayList<Attaque> listeAttaque = new ArrayList<Attaque>();
	int id;
	
	public GenerateurSort() {
		fillBonusLibrary();
		fillMalusLibrary();
		fillAttaqueLibrary();
	}
	
	public Spell createSpell(Element [] composants) {
		id = 0;
		
		for(int i=0;i<composants.length;i++) {
			if(i==0) id += composants[i].getId();
			else  id += ((composants[i].getId() * i) * 2);
		}
		
		return checkLibraries(id);
	}
	
	public void fillBonusLibrary() {
		File fichierXml = new File("xml/bonus.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(fichierXml);

			NodeList noeuds = doc.getDocumentElement().getElementsByTagName("sort");
			
			for(int i=0;i<noeuds.getLength();i++) {
				int id = Integer.parseInt(noeuds.item(i).getChildNodes().item(1).getTextContent());
				String nom = noeuds.item(i).getChildNodes().item(3).getTextContent();
				String description = noeuds.item(i).getChildNodes().item(5).getTextContent();
				int degats = Integer.parseInt(noeuds.item(i).getChildNodes().item(7).getTextContent());
				int effetMax = Integer.parseInt(noeuds.item(i).getChildNodes().item(9).getTextContent());
				String sprite = noeuds.item(i).getChildNodes().item(11).getTextContent();
				String icone = noeuds.item(i).getChildNodes().item(13).getTextContent();
				String [] xy = noeuds.item(i).getChildNodes().item(15).getTextContent().split(";");
				Vector2 position = new Vector2(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
				
				Bonus sort = new Bonus(id, nom, description, degats, effetMax, sprite, icone, position);
				
				listeBonus.add(sort);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fillMalusLibrary() {
		File fichierXml = new File("xml/malus.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(fichierXml);

			NodeList noeuds = doc.getDocumentElement().getElementsByTagName("sort");
			
			for(int i=0;i<noeuds.getLength();i++) {
				int id = Integer.parseInt(noeuds.item(i).getChildNodes().item(1).getTextContent());
				String nom = noeuds.item(i).getChildNodes().item(3).getTextContent();
				String description = noeuds.item(i).getChildNodes().item(5).getTextContent();
				int degats = Integer.parseInt(noeuds.item(i).getChildNodes().item(7).getTextContent());
				int effetMax = Integer.parseInt(noeuds.item(i).getChildNodes().item(9).getTextContent());
				String sprite = noeuds.item(i).getChildNodes().item(11).getTextContent();
				String icone = noeuds.item(i).getChildNodes().item(13).getTextContent();
				String [] xy = noeuds.item(i).getChildNodes().item(15).getTextContent().split(";");
				Vector2 position = new Vector2(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
				
				Malus sort = new Malus(id, nom, description, degats, effetMax, sprite, icone, position);
				
				listeMalus.add(sort);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fillAttaqueLibrary() {
		File fichierXml = new File("xml/attaque.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(fichierXml);

			NodeList noeuds = doc.getDocumentElement().getElementsByTagName("sort");
			
			for(int i=0;i<noeuds.getLength();i++) {
				int id = Integer.parseInt(noeuds.item(i).getChildNodes().item(1).getTextContent());
				String nom = noeuds.item(i).getChildNodes().item(3).getTextContent();
				String description = noeuds.item(i).getChildNodes().item(5).getTextContent();
				int degats = Integer.parseInt(noeuds.item(i).getChildNodes().item(7).getTextContent());
				int effetMax = Integer.parseInt(noeuds.item(i).getChildNodes().item(9).getTextContent());
				String sprite = noeuds.item(i).getChildNodes().item(11).getTextContent();
				String icone = noeuds.item(i).getChildNodes().item(13).getTextContent();
				String [] xy = noeuds.item(i).getChildNodes().item(15).getTextContent().split(";");
				Vector2 position = new Vector2(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
				
				Attaque sort = new Attaque(id, nom, description, degats, effetMax, sprite, icone, position);
				
				listeAttaque.add(sort);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Spell checkLibraries(int id) {
		for(int i =0;i<listeAttaque.size();i++) if(listeAttaque.get(i).getId() == id) return listeAttaque.get(i);
		for(int i =0;i<listeBonus.size();i++) if(listeBonus.get(i).getId() == id) return listeBonus.get(i);
		
		int randomMalus = (int)(Math.random() * (listeMalus.size()-0)) + 0;

		for(int i=0;i<=randomMalus;i++) if(i == randomMalus) return listeMalus.get(i);
		
		return null;
	}
}
