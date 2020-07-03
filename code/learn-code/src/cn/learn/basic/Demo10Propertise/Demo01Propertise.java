package cn.learn.basic.Demo10Propertise;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
    ���϶���Properties�࣬�̳�Hashtable��ʵ��Map�ӿ�
    ���Ժ�IO������ʹ�ã�ʵ�����ݵĳ־ô洢
*/
public class Demo01Propertise {
    public static void main(String[] args) throws IOException{
        demo01();
        demo02();
        demo03();
    }
    /*
        store(OutputStream out)
        store(Writer w)
        �������е��ֽڻ����ַ�����������������еļ�ֵ�ԣ�д���ļ��б���
    */
    private static void demo03() throws IOException{
        Properties pro = new Properties();

        pro.setProperty("name", "zhangsan");
        pro.setProperty("age", "31");
        pro.setProperty("Email", "123456@163.com");

        FileWriter fw = new FileWriter("c:\\demo\\pro.properties");
        //��ֵ�ԣ�����ļ���ʹ�ü��ϵķ���store�����ַ������
        pro.store(fw,"abc");

        fw.close();
    }

    /*
        Properties�������з���load
        load(InputStream in)
        load(Reader r)
        ���������ֽڻ����ַ�������
        �������ȡ�ļ��еļ�ֵ�ԣ����浽����
    */
    private static void demo02() throws IOException {
        Properties pro = new Properties();
        FileReader fr = new FileReader("c:\\demo\\pro.properties");
        //���ü��Ϸ���load������������
        pro.load(fr);
        fr.close();
        System.out.println(pro);
    }

    /*
        ʹ��Properties���ϣ��洢��ֵ��
        setProperty������Map�ӿ��е�put
        setProperty(String key, String value)
        ͨ������ȡֵ��getProperty(String key)
    */
    private static void demo01() {
        Properties pro = new Properties();

        pro.setProperty("a", "4");
        pro.setProperty("b", "5");
        pro.setProperty("c", "6");
        System.out.println(pro);

        String value = pro.getProperty("c");
        System.out.println(value);
        value = pro.getProperty("f");//û�У�����null
        System.out.println(value);

        //����stringPropertyNames, �������еļ��洢��Set���ϣ�������Map�ӿڵķ���keySet
        Set<String> set = pro.stringPropertyNames();
        for (String s : set) {
            System.out.println(s + "..." + pro.getProperty(s));
        }
    }
}
