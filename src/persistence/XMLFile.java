package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class XMLFile implements IFiles {
	private Document document;
	private ArrayList<Object> dataList;

	@Override
	public ArrayList<Object> readFile(String path) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			document = docBuilder.parse(new File(path));
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
		dataList = new ArrayList<>();
		NodeList nodeListList = document.getElementsByTagName("Persona");
		for (int i = 0; i < nodeListList.getLength(); i++) {
			Element elment = (Element) nodeListList.item(i);
			dataList.add(elment);
		}
	}

	@Override
	public void writeFile(String path, Object[][] data) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null,"Institutos", null);
			document.setXmlVersion("1.0");
			Element raiz = document.getDocumentElement();
		for (int i = 0; i < data.length; i++) {
			Element itemNode = document.createElement("Instituto"); 
			for (int j = 0; j < data[i].length; j++) {
				Element keyNode = document.createElement("NameDepartame"); 
				Text nodeKeyValue =  document.createTextNode(""+data[i][0]);
				keyNode.appendChild(nodeKeyValue);   

				Element keyNode1 = document.createElement("NameInstitute"); 
				Text nodeKeyValue1 =  document.createTextNode(""+data[i][1]);
				keyNode1.appendChild(nodeKeyValue1); 
				
				Element keyNode2 = document.createElement("NumberMembers"); 
				Text nodeKeyValue2 =  document.createTextNode(""+data[i][2]);
				keyNode2.appendChild(nodeKeyValue2); 
				
				Element keyNode3 = document.createElement("NumberCups"); 
				Text nodeKeyValue3 =  document.createTextNode(""+data[i][3]);
				keyNode3.appendChild(nodeKeyValue3); 
				
				Element keyNode4 = document.createElement("NameDirector"); 
				Text nodeKeyValue4 =  document.createTextNode(""+data[i][4]);
				keyNode4.appendChild(nodeKeyValue4); 
				
				Element keyNode5 = document.createElement("DateFundation"); 
				Text nodeKeyValue5 =  document.createTextNode(""+data[i][5]);
				keyNode5.appendChild(nodeKeyValue5); 
				
				itemNode.appendChild(keyNode);
				itemNode.appendChild(keyNode1);
				itemNode.appendChild(keyNode2);
				itemNode.appendChild(keyNode3);
				itemNode.appendChild(keyNode4);
				itemNode.appendChild(keyNode5);
			}
			raiz.appendChild(itemNode); 
			}
			Source source = new DOMSource(document);
			StreamResult result = new StreamResult(new java.io.File(path + ".xml"));
			Transformer transformer;
			transformer = TransformerFactory.newInstance().newTransformer();

			transformer.transform(source, result);
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			} catch (TransformerFactoryConfigurationError e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
