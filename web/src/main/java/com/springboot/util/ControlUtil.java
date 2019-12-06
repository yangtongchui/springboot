package com.springboot.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.ibatis.annotations.Case;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.thymeleaf.util.ArrayUtils;
import org.thymeleaf.util.StringUtils;

public class ControlUtil {
	
	public static Map<String,List<Map<String,String>>> controlMap = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	public static void init(String controlPath) {
		if ((controlPath == null) || (controlPath.trim().equals(""))) {
			controlPath = "config/control.xml";
		}
		try {
		     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		     DocumentBuilder db = dbf.newDocumentBuilder();
			 org.w3c.dom.Document domDocument = db.parse(ControlUtil.class.getClassLoader().getResourceAsStream(controlPath));
			 DOMReader reader = new DOMReader();
			 org.dom4j.Document document = reader.read(domDocument);
			 Element root = document.getRootElement();
			 List<Element> rchilds = root.elements();
			 for (Element e : rchilds) {
				Attribute attr = e.attribute(0);
				domDocument = db.parse(ControlUtil.class.getClassLoader().getResourceAsStream(attr.getValue()));
				document = reader.read(domDocument);
				root = document.getRootElement();
				List<Element> rchildsX = root.elements();
				for (Element ex : rchildsX) {
					Attribute attrX = ex.attribute(0);
					List<Element> echilds = ex.elements();
					List<Map<String,String>> list = new ArrayList<Map<String,String>>();
					for (Element e2 : echilds) {
						int count = e2.attributeCount();
						for(int i = 0; i<count; i++) {
							Attribute attrXx = e2.attribute(i);
							Map<String,String> map = new HashMap<>();
							map.put(attrXx.getName(), attrXx.getValue());
							list.add(map);
						}
					}
					controlMap.put(attrX.getValue(), list);
				}
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String validate(String path,Map<String, String[]> paramMap) {
		List<Map<String,String>> list = ControlUtil.controlMap.get(path);
		String value = ""; 
		String regex = ""; 
		String desc = ""; 
		StringBuilder result = new StringBuilder();
		int count = 0;
		for(Map<String,String> map : list){
			count++;
			if(map.containsKey("key") && paramMap.containsKey(map.get("key"))) {
				String[] ss = paramMap.get(map.get("key"));
				StringBuilder sub = new StringBuilder();
				for(String s : ss) {
					sub.append(s);
				}
				value = sub.toString();
			}else if(map.containsKey("regex")) {
				regex = map.get("regex");
			}else if(map.containsKey("desc")) {
				desc = map.get("desc");
			}
			if(count%4 == 0 && !StringUtils.isEmpty(regex) && !value.matches(regex)){
				result.append(desc);
				result.append("格式不正确！");
				return result.toString();
			}
		}
		return result.toString();
	}
    
}
