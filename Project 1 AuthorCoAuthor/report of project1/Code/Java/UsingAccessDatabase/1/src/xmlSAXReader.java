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
import org.xml.sax.XMLReader; 
import org.dom4j.io.SAXReader; 
import org.dom4j.Document; 
import org.dom4j.DocumentException; 
import org.dom4j.DocumentFactory;
import org.dom4j.Element; 
import org.dom4j.Node; 
import org.dom4j.ElementHandler;  
import org.dom4j.ElementPath;  

import java.text.DecimalFormat;
import java.util.Iterator; 
import java.util.LinkedList;
import java.util.List; 
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream; 
import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException; 

public class xmlSAXReader {

	///////////////////////////////////////////////////////////////////////////
	//成员对象
	///////////////////////////////////////////////////////////////////////////
	static SAXReader reader = new SAXReader();
	static AuthorElementHandler authorElementHandler;
	AccessDB adb=new AccessDB();
	
	static int cnt=0;
	
	///////////////////////////////////////////////////////////////////////////
	//辅助类
	///////////////////////////////////////////////////////////////////////////
	public class AuthorElementHandler implements ElementHandler {
	
		public AuthorElementHandler(){  
		
		}  
		
		@Override
		public void onEnd(ElementPath arg0) {			
//			if(cnt+1662022>=1662022){
			if(cnt>=0){
				try{				
					// TODO Auto-generated method stub
					Element article = arg0.getCurrent();
					List<Element> elements=article.elements();
					List<Element> authors=new LinkedList<Element>();
					List<String> elementsName=new LinkedList<String>();
					
					authors=article.elements("author");
					authors.addAll(article.elements("editor"));
					
					for(int i=0;i<elements.size();i++){
						elementsName.add(elements.get(i).getName());
						//System.out.println(elementsName.get(i)+"\t"+elements.get(i).getText());
					}
					
					
					String title="";		String key=""; 			String mdate=""; 		String type=""; 
					String journal=""; 		String booktitle="";	String publisher="";	String isbn="";
					String year="";			String month="";		String crossref="";		String volume="";
					String pages="";		String ee="";			String url="";			String cdrom="";
					String number="";		String address="";		String cite="";			String note="";
					String series="";		String school="";		String chapter="";
					
					
					type=article.getName();
					key=article.attributeValue("key");
					mdate=article.attributeValue("mdate");
					if(elementsName.contains("title"))
						title=article.element("title").getText();
					if(elementsName.contains("journal"))
						journal=article.element("journal").getText();
					if(elementsName.contains("booktitle"))
						booktitle=article.element("booktitle").getText();
					if(elementsName.contains("publisher"))
						publisher=article.element("publisher").getText();
					if(elementsName.contains("isbn"))
						isbn=article.element("isbn").getText();
					if(elementsName.contains("year"))
						year=article.element("year").getText();
					if(elementsName.contains("month"))
						month=article.element("month").getText();
					if(elementsName.contains("crossref"))
						crossref=article.element("crossref").getText();
					if(elementsName.contains("volume"))
						volume=article.element("volume").getText();
					if(elementsName.contains("pages"))
						pages=article.element("pages").getText();
					if(elementsName.contains("ee"))
						ee=article.element("ee").getText();
					if(elementsName.contains("url"))
						url=article.element("url").getText();
					if(elementsName.contains("cdrom"))
						cdrom=article.element("cdrom").getText();
					if(elementsName.contains("number"))
						number=article.element("number").getText();
					if(elementsName.contains("address"))
						address=article.element("address").getText();
					if(elementsName.contains("cite"))
						cite=article.element("cite").getText();
					if(elementsName.contains("note"))
						note=article.element("note").getText();
					if(elementsName.contains("series"))
						series=article.element("series").getText();
					if(elementsName.contains("school"))
						school=article.element("school").getText();
					if(elementsName.contains("chapter"))
						chapter=article.element("chapter").getText();
					//System.out.println(title+"\t"+ key+"\t"+ mdate+"\t"+ type+"\t"+ journal+"\t"+ booktitle+"\t"+ publisher+"\t"+ isbn+"\t"+ year+"\t"+ month+"\t"+ crossref+"\t"+ volume+"\t"+ pages+"\t"+ ee+"\t"+ url+"\t"+ cdrom+"\t"+ number+"\t"+ address+"\t"+ cite+"\t"+ note+"\t"+ series+"\t"+ school+"\t"+ chapter);
					
					adb.insertArticle(title, key, mdate, type, journal, booktitle, publisher, isbn, year, month, crossref, volume, pages, ee, url, cdrom, number, address, cite, note, series, school, chapter);
					//adb.insertArticle(title, key, mdate, type, journal, booktitle, publisher, isbn, year, month, crossref, volume, pages, ee, url, cdrom, number, address, cite, note, series, school, chapter);
						
						
					if(elementsName.contains("title")){
						for(int i=0;i<authors.size();i++){
							adb.insertArticle_Author(title,authors.get(i).getText());
						}
					}
								
					
					// prune the tree  
					article.detach();
					elements.clear();
					authors.clear();
					elementsName.clear();
					
		            if(cnt>=3245445-1662022){
		    			//不知道为什么最后一条没法写入，只有再加一条，才能将最后一条写入
		            	adb.insertArticle("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","","","","","");
		            	adb.insertArticle_Author("", "");
		            	
		            }
				}			
				catch(Exception e){
					System.out.println(e.getMessage());
					System.out.println("num:"+cnt+"!!!");
	//				System.out.println(article.asXML());
//					System.exit(0);
				}			
			}
			
			
            DecimalFormat formatter=new DecimalFormat("#.00");
//            System.out.println("Finished:"+(++cnt)+"/3245445 ("+formatter.format((double)cnt/3245445.0*100)+"%)");
//            System.out.println("Finished:"+(++cnt+1662022)+"/3245445 ("+formatter.format(((double)cnt+1662022)/3245445.0*100)+"%)");
            System.out.println("Finished:"+(++cnt)+"/19746 ("+formatter.format((double)cnt/19746.0*100)+"%)");
		}


		@Override
		public void onStart(ElementPath arg0) {
		// TODO Auto-generated method stub		
		}	
	}
	
	///////////////////////////////////////////////////////////////////////////
	//成员函数
	///////////////////////////////////////////////////////////////////////////
	public xmlSAXReader(){  
		authorElementHandler=new AuthorElementHandler();
		reader.addHandler("/dblp/article",authorElementHandler);
		reader.addHandler("/dblp/inproceedings",authorElementHandler);
		reader.addHandler("/dblp/proceedings",authorElementHandler);
		reader.addHandler("/dblp/book",authorElementHandler);
		reader.addHandler("/dblp/incollection",authorElementHandler);
		reader.addHandler("/dblp/phdthesis",authorElementHandler);
		reader.addHandler("/dblp/mastersthesis",authorElementHandler);
		reader.addHandler("/dblp/www",authorElementHandler);
		reader.setEncoding("ISO-8859-1");
		
	}
	
	public void readXMLfile(String xmlFilePath){
		  try {
//			  System.out.println(readFilePath);
			  FileInputStream readFile=new FileInputStream(xmlFilePath);
//			  File readFile = new File(readFilePath);
		      reader.read(readFile);  
		  } catch (Exception e) {  
		   System.out.println(e.getMessage());
//		   System.exit(0);
		  }  
	}
	

}
