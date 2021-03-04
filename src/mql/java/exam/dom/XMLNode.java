package mql.java.exam.dom;





import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLNode {
	private Node node;

	public XMLNode(Node source) {
		node = source;
	}

	public XMLNode(String source) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(source);
			node = doc.getDocumentElement();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean isElementNode(Node node) {
		return node.getNodeType() == Node.ELEMENT_NODE;
	}

	public XMLNode[] extractChildren() {
		NodeList nodes = node.getChildNodes();
		Vector<XMLNode> v = new Vector<>();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node item = nodes.item(i);
			if (isElementNode(item))
				v.add(new XMLNode(item));
		}
		XMLNode[] xmlNodes = new XMLNode[v.size()];
		return v.toArray(xmlNodes);
	}

	public XMLNode extractChild(String name) {
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node item = nodeList.item(i);
			if (item.getNodeName().equals(name)) {
				return new XMLNode(item);
			}
		}
		return null;
	}

	public String extractAttribute(String name) {
		NamedNodeMap attributes = node.getAttributes();
		Node att = attributes.getNamedItem(name);
		if (att != null)
			return att.getNodeValue();
		return null;

	}

	public int extractIntAttribute(String name) {
		String value = extractAttribute(name);
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

	public String textValue() {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			return node.getFirstChild().getNodeValue();
		}

		return node.getNodeValue();
	}

	public int intValue() {
		String value = textValue();

		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public double doubleValue() {
		String value = textValue();
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

}
