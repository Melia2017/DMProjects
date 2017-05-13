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
	
	static XMLWriter writer; 
	static String writeFilePathRoot="C:/Users/Dale/Desktop/dblp_xml/Data/clean_data/coauthors/SeparateCoauthors/";
	
	static int cnt=0;
	///////////////////////////////////////////////////////////////////////////
	//辅助类
	///////////////////////////////////////////////////////////////////////////
	public class AuthorElementHandler implements ElementHandler {
	
		public AuthorElementHandler(){  
		
		}  
		
		@Override
		public void onEnd(ElementPath arg0) {
			// TODO Auto-generated method stub
			Element author = arg0.getCurrent();
			
				try{
					String AuthorName=author.attributeValue("Name");
					writeXMLfile(writeFilePathRoot+AuthorName+"_co.xml",author);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			
			
			// prune the tree  
				author.detach();
				
				DecimalFormat formatter=new DecimalFormat("#.00");
				System.out.println("Finished:"+(++cnt)+"/56337("+formatter.format((double)cnt/56337.0*100)+"%)");
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
		reader.addHandler("/dblp/author",authorElementHandler);
		reader.setEncoding("ISO-8859-1");
		
	}
	
	public void readXMLfile(String readFilePath){
		  try {
			  FileInputStream readFile=new FileInputStream(readFilePath);
		      reader.read(readFile);  
		  } catch (Exception e) {  
		   System.out.println(e.getMessage());
		  }  
	}
	
	public void writeXMLfile(String writeFilePath,Element node){ 
		SAXReader tmpReader = new SAXReader(); 
		tmpReader.setStripWhitespaceText(true); 
		
		File writeFile = new File(writeFilePath); 
        if (!writeFile.exists()) {  
        	createOutXML(writeFilePath);
        } 
		
		  try {
			  tmpReader.setEncoding("ISO-8859-1");
			  Document document = tmpReader.read(writeFile); 
			  			    
			   Element root = document.getRootElement();  			   
			   ///////////////////////////////////////////////////
			   Element newNode=node.createCopy();        	
			   root.add(newNode);
			   ///////////////////////////////////////////////////
			   
			   
			   OutputFormat outputFormat = OutputFormat.createPrettyPrint();  
			   outputFormat.setEncoding("ISO-8859-1");  
	           FileWriter fw = new FileWriter(writeFilePath);  
	           writer = new XMLWriter(fw,outputFormat);  
	           writer.write(document);  
	           fw.close(); 
			   newNode.detach();
			   root.detach();
 
			  } catch (Exception e) {
				  System.out.println(e.toString());  
				  //System.exit(0);
			  }
			  
	}
	
	private void createOutXML(String writeFilePath) {  
    	// 创建输出文件
        // 如果文件存在则删除原来的xml文件  
    	File writeFile = new File(writeFilePath);  
        if (writeFile.exists()) {  
            //return;  
        	writeFile.delete();
        }  
        DocumentFactory factory = new DocumentFactory();  
        Document document = factory.createDocument();  
          
        //document.addDocType("dblp", null, "C:\\Users\\Dale\\Desktop\\dblp_xml\\data\\dblp.dtd");
        //document.addDocType("dblp", null, "C:\\data\\dblp.dtd");
        //document.addDocType("dblp", null, "dblp.dtd");
        
        // 建立根节点  
        document.addElement("dblp");  
          
		OutputFormat outputFormat = OutputFormat.createPrettyPrint();  
		outputFormat.setEncoding("ISO-8859-1");  
		   
        // 建立一个xml文件，将Dom4j树写入xml文件  
        try {  
            FileWriter fw = new FileWriter(writeFilePath);  
            XMLWriter writer = new XMLWriter(fw,outputFormat);  
            writer.write(document);  
            fw.close();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }
}
