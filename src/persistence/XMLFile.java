package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLFile {
	private Document document;
	private ArrayList<Object> dataList;
	public ArrayList<Object> readFile() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			document = docBuilder.parse(new File("resources/Personas.xml"));
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		document.getDocumentElement().normalize();
		parseDocument();
		return dataList;
	}
	public void parseDocument() {
		dataList=new ArrayList<>();
		NodeList nodeListList=document.getElementsByTagName("Persona");
		for (int i = 0; i < nodeListList.getLength(); i++) {
			Element elment=(Element) nodeListList.item(i);
			dataList.add(elment);
		}
	}
}
