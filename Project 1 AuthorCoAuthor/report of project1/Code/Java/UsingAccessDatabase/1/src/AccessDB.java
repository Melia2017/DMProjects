import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.sql.*;  
import java.util.Properties;  

public class AccessDB {
    public static final String db_driver="sun.jdbc.odbc.JdbcOdbcDriver";  
    public static final String db_url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:/Users/Dale/Desktop/dblp_xml/Data/AccessDatabase/dblp2.accdb";  
    public static Connection conn;
	
	public AccessDB(){
        try{  
            Class.forName(db_driver);  
            conn=DriverManager.getConnection(db_url,"","");  
            if(conn!=null){  
                System.out.println("连接成功");  
            }else{  
                System.out.println("连接失败！");  
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    } 
  
	public void insertArticle(String title,String key,String mdate, String type, String journal,
			String booktitle,String publisher,String isbn,String year,String month,String crossref,
			String volume,String pages,String ee,String url,String cdrom,String number,String address,
			String cite,String note,String series,String school,String chapter)  
    {   
        try {   
            String sql="INSERT into Articles(title,key,mdate,type,journal,booktitle,publisher,isbn,year_,month_,crossref,volume,pages,ee,url,cdrom,number_,address,cite,note_,series,school,chapter) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";//sql语句中末尾的分号可有可无  
//            String sql="INSERT into Articles(title,key,mdate,type,journal,booktitle,publisher,isbn,year_,month_,crossref,volume,pages,ee,url,cdrom,number_,address,cite,note_) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";//sql语句中末尾的分号可有可无  
            PreparedStatement ppst=conn.prepareStatement(sql);  
            ppst.setString(1, title);//对sql语句中的每个？按顺序赋值,赋值的方法取决于数据库的字段属性，我的字段属性都是字符串类型  
            ppst.setString(2, key);  
            ppst.setString(3, mdate); 
            ppst.setString(4, type);
            ppst.setString(5, journal);
            ppst.setString(6, booktitle);
            ppst.setString(7, publisher);
            ppst.setString(8, isbn);
            ppst.setString(9, year);
            ppst.setString(10, month);
            ppst.setString(11, crossref);
            ppst.setString(12, volume);
            ppst.setString(13, pages);
            ppst.setString(14, ee);
            ppst.setString(15, url);
            ppst.setString(16, cdrom);
            ppst.setString(17, number);
            ppst.setString(18, address);
            ppst.setString(19, cite);
            ppst.setString(20, note);
            ppst.setString(21, series);
            ppst.setString(22, school);
            ppst.setString(23, chapter);
              
            //System.out.println(sql); 
            ppst.executeUpdate();    
            ppst.close();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }            
    } 
	
	public void insertArticle_Author(String title, String Author){
		try {   
            String sql="INSERT into Article_Author(title,Author) values(?,?);";//sql语句中末尾的分号可有可无  
//            String sql="INSERT into Articles(title,key,mdate,type,journal,booktitle,publisher,isbn,year_,month_,crossref,volume,pages,ee,url,cdrom,number_,address,cite,note_) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";//sql语句中末尾的分号可有可无  
            PreparedStatement ppst=conn.prepareStatement(sql);  
            ppst.setString(1, title);//对sql语句中的每个？按顺序赋值,赋值的方法取决于数据库的字段属性，我的字段属性都是字符串类型  
            ppst.setString(2, Author);  
            
            //System.out.println(sql); 
            ppst.executeUpdate();    
            ppst.close();  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } 
	}
}
