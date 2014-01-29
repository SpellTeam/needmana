package fr.spellTeam.NeedMana.entities;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Element {
	private String name;
	private String icone;
	private int id;
	private boolean isVisible = false;
	
	public Element(String name, String icone, int id) {
		this.name = name;
		this.icone = icone;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String getIcone() {
		return icone;
	}


	public int getId() {
		return id;
	}


	public boolean isVisible() {
		return isVisible;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setIcone(String icone) {
		this.icone = icone;
	}


	public void setValeur(int id) {
		this.id = id;
	}
	
	public void setVisible (boolean b){
		this.isVisible = b;
	}
	
	public static Element[] getAllElements() {
		Element [] liste = new Element[8];
		
		File fichierXml = new File("xml/element.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(fichierXml);

			NodeList noeuds = doc.getDocumentElement().getElementsByTagName("element");
			
			for(int i=0;i<noeuds.getLength();i++) {
				String nomElem = noeuds.item(i).getChildNodes().item(1).getTextContent();
				String iconeElem = noeuds.item(i).getChildNodes().item(3).getTextContent();
				int id = Integer.parseInt(noeuds.item(i).getChildNodes().item(5).getTextContent());
				
				Element element = new Element(nomElem, iconeElem, id);
				
				liste[i] = element;
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
		
		return liste;
	}
}
