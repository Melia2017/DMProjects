import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  

import org.dom4j.Document;  
import org.dom4j.DocumentException;  
import org.dom4j.DocumentHelper;  
import org.dom4j.Element;  
import org.dom4j.io.OutputFormat;  
import org.dom4j.io.SAXReader;  
import org.dom4j.io.XMLWriter;  
import org.xml.sax.SAXException;  
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader; 
import org.dom4j.io.SAXReader; 
import org.dom4j.Document; 
import org.dom4j.DocumentException; 
import org.dom4j.Element; 
import org.dom4j.Node; 
import org.dom4j.ElementHandler;  
import org.dom4j.ElementPath;  

import java.text.DecimalFormat;
import java.util.Iterator; 
import java.util.List; 
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream; 
import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException; 

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("entityExpansionLimit",  "1000000000");
		
		DecimalFormat formatter=new DecimalFormat("#.00");
		
		long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
		String xmlFilePath="C:/Users/Dale/Desktop/dblp_xml/Data/raw_data/dblp4.xml";
		

		xmlSAXReader test=new xmlSAXReader();
		test.readXMLfile(xmlFilePath);
//			System.out.println(files.getPath())
		
//		AccessDB adb=new AccessDB();
////		adb.insertArticle("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
////		adb.insertArticle("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "", "12", "13", "14", "15", "16", "");
//		adb.insertArticle("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17","18","19","20","21","22","23");
//		adb.insertArticle("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17","18","19","20","21","22","23");
		
		
		long endMili=System.currentTimeMillis();// 当前时间对应的毫秒数
		System.out.println(((double)(endMili-startMili))/60000+"min");
	}

}
