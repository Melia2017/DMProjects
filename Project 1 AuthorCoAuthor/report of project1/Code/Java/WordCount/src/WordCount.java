import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
 
public class WordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//读取文本文件
            @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Dale\\Desktop\\TMP.txt"));
            String s;
            StringBuffer sb = new StringBuffer();
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            
            //创建一个哈希表，用来存储词和计数
            Map<String,Integer> map = new HashMap<String, Integer>();
            StringTokenizer st = new StringTokenizer(sb.toString(),",.!！ \n/\\()?:;\"{}$&#");
            while (st.hasMoreTokens()) {
                String letter = st.nextToken().toLowerCase();
                int count;
                if (map.get(letter) == null) {
                    count = 1;
                }
                else {
                    count = map.get(letter).intValue() + 1;
                }
                map.put(letter,count);
            }
            
            //创建一个WordEntity的集合，把哈希表中的词和计数组成WordEntity对象，存入集合中
            Set<WordEntity> set = new TreeSet<WordEntity>();
            for (String key : map.keySet()) {
                set.add(new WordEntity(key,map.get(key)));
            }
            
            
            ////////////////
            //////输出///////
            ////////////////
            
            FileWriter writer= new FileWriter("C:\\Users\\Dale\\Desktop\\out.txt");;
            for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
                WordEntity w = it.next();
                
                if(w.getKey().length()<2 || 
                   w.getCount()<10 || 
                   w.getKey().compareTo("for")==0 || 
                   w.getKey().compareTo("of")==0 || 
                   w.getKey().compareTo("in")==0 || 
                   w.getKey().compareTo("using")==0 || 
                   w.getKey().compareTo("on")==0 || 
                   w.getKey().compareTo("an")==0 ||  
                   w.getKey().compareTo("the")==0 || 
                   w.getKey().compareTo("with")==0 || 
                   w.getKey().compareTo("to")==0 || 
                   w.getKey().compareTo("by")==0 || 
                   w.getKey().compareTo("from")==0 || 
                   w.getKey().compareTo("over")==0 || 
                   w.getKey().compareTo("its")==0 || 
                   w.getKey().compareTo("at")==0 || 
                   w.getKey().compareTo("under")==0 || 
                   w.getKey().compareTo("is")==0 || 
                   w.getKey().compareTo("or")==0 || 
                   w.getKey().compareTo("how")==0 || 
                   w.getKey().compareTo("what")==0 || 
                   w.getKey().compareTo("it")==0 || 
                   w.getKey().compareTo("and")==0 || 
                   w.getKey().compareTo("new")==0 ) 
                	continue;
                
                writer.write(w.getKey());
                writer.write("  ");
                writer.write(w.getCount().toString());
                writer.write("\r\n");
            }
            writer.write("\r\n");
            // 自己拼接字符串，输出我们想要的字符串格式
            System.out.println("输出形式一：");
            for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
                WordEntity w = it.next();
                System.out.println("单词:" + w.getKey() + " 出现的次数为： " + w.getCount());
            }
            // 直接打印 WordEntity 对象，实现我们想要的输出效果，只需在WordEntity类中重写toString()方法
            System.out.println("输出形式二：");
            for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
                WordEntity w = it.next();
                System.out.println(w);
            }
            // 我们可以控制只输出前三名来
            System.out.println("输出形式三：");
            int count = 1;
            for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
                WordEntity w = it.next();
                System.out.println("第" + count + "名为单词:" + w.getKey() + " 出现的次数为： "
                        + w.getCount());
                if (count == 3)// 当输出3个后跳出循环
                    break;
                count++;
            }
        }
		catch (FileNotFoundException e) {
            System.out.println("文件未找到~！");
        }
		catch (IOException e) {
            System.out.println("文件读异常~！");
        }
    }
}