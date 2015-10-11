/**
 * XmlLanguage.java
 * 
 * Copyright (c) 2015 Kenji Sasaki
 * Released under the MIT license.
 * https://github.com/npedotnet/npe-base/blob/master/LICENSE
 * 
 * This file is a part of npe-base.
 * https://github.com/npedotnet/npe-base
 *
 * For more details, see npe-base wiki.
 * https://github.com/npedotnet/npe-base/wiki
 * 
 */

package net.npe.i18n.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.npe.i18n.Language;
import net.npe.util.StringNestedLinkedHashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlLanguage implements Language {
	
	public XmlLanguage() {
		super();
	}
	
	public void read(String path) {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(new File(path));
			Node rootNode = document.getDocumentElement();
			if(rootNode.getNodeName().equals("language")) {
				name = rootNode.getAttributes().getNamedItem("name").getFirstChild().getNodeValue();
				locale = rootNode.getAttributes().getNamedItem("locale").getFirstChild().getNodeValue();
				System.out.println("name:"+name+", locale:"+locale);
				root = new StringNestedLinkedHashMap();
				for(int i=0; i<rootNode.getChildNodes().getLength(); i++) {
					read(rootNode.getChildNodes().item(i), root);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void read(Node node, StringNestedLinkedHashMap parent) {
		String name = node.getNodeName();
		NodeList children = node.getChildNodes();
		int childCount = children.getLength();
		if(!name.startsWith("#")) {
			if(childCount == 1) {
				// Leaf
				String value = node.getFirstChild().getNodeValue();
				System.out.println("Leaf: "+name+", "+value);
				parent.put(name, value);
			}
			else if(1 < childCount) {
				System.out.println("Category: "+name);
				StringNestedLinkedHashMap map = new StringNestedLinkedHashMap();
				for(int i=0; i<childCount; i++) {
					Node child = children.item(i);
					read(child, map);
				}
				root.put(name, map);
			}
		}
	}
	
	public StringNestedLinkedHashMap getCategory(String key) {
		return (StringNestedLinkedHashMap)root.get(key);
	}
	
	@Override
	public String getValue(String key) {
		return root.getString(key);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getLocale() {
		return locale;
	}
	
	private String name;
	private String locale;
	private StringNestedLinkedHashMap root;

}
