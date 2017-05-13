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
			//��ȡ�ı��ļ�
            @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Dale\\Desktop\\TMP.txt"));
            String s;
            StringBuffer sb = new StringBuffer();
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            
            //����һ����ϣ�������洢�ʺͼ���
            Map<String,Integer> map = new HashMap<String, Integer>();
            StringTokenizer st = new StringTokenizer(sb.toString(),",.!�� \n/\\()?:;\"{}$&#");
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
            
            //����һ��WordEntity�ļ��ϣ��ѹ�ϣ���еĴʺͼ������WordEntity���󣬴��뼯����
            Set<WordEntity> set = new TreeSet<WordEntity>();
            for (String key : map.keySet()) {
                set.add(new WordEntity(key,map.get(key)));
            }
            
            
            ////////////////
            //////���///////
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
            // �Լ�ƴ���ַ��������������Ҫ���ַ�����ʽ
            System.out.println("�����ʽһ��");
            for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
                WordEntity w = it.next();
                System.out.println("����:" + w.getKey() + " ���ֵĴ���Ϊ�� " + w.getCount());
            }
            // ֱ�Ӵ�ӡ WordEntity ����ʵ��������Ҫ�����Ч����ֻ����WordEntity������дtoString()����
            System.out.println("�����ʽ����");
            for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
                WordEntity w = it.next();
                System.out.println(w);
            }
            // ���ǿ��Կ���ֻ���ǰ������
            System.out.println("�����ʽ����");
            int count = 1;
            for (Iterator<WordEntity> it = set.iterator(); it.hasNext(); ) {
                WordEntity w = it.next();
                System.out.println("��" + count + "��Ϊ����:" + w.getKey() + " ���ֵĴ���Ϊ�� "
                        + w.getCount());
                if (count == 3)// �����3��������ѭ��
                    break;
                count++;
            }
        }
		catch (FileNotFoundException e) {
            System.out.println("�ļ�δ�ҵ�~��");
        }
		catch (IOException e) {
            System.out.println("�ļ����쳣~��");
        }
    }
}