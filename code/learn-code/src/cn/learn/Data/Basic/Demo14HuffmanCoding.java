package cn.learn.Data.Basic;
/*
    �շ���������һ�ֳ����㷨���ǹ��������ڵ�Ѷͨ���еľ���Ӧ��֮һ���㷺�����������ļ�ѹ��
    �ǿɱ��ֳ������һ��
    �䳤���룺
        ���ո����ַ����ֵĴ������б��룬ԭ���ǳ��ִ���Խ��ģ������ԽС
        ���磺i like like like java do you like a java  ��40���ַ��������ո�
        d:1; y:1; u:1; j:2; v:2; o:2; l:4; k:4; e:4; i:5; a:5; �ո�:9
        0=�ո�; 1=a; 10=i; 11=e; 100=k; 101=l; 110=o; 111=v; 1000=j; 1001=u; 1010=y; 1011=d
       ���������ַ��涨�ı��룬���Ҵ��� i like like like java do you like a java����ʱ���������
       10 0 101 10 100...
       �ַ����붼�����������ַ������ǰ׺������Ҫ��ı������ǰ׺���룬������ƥ�䵽�ظ��ı���
    �շ������룺
         ���磺
              1��"i like like like java do you like a java"  ��40���ַ��������ո�
              2��d:1; y:1; u:1; j:2; v:2; o:2; l:4; k:4; e:4; i:5; a:5; �ո�:9 //ͳ�Ƹ����ַ��ĸ���
              3�����������ַ����ֵĴ���������һ�úշ�������������ΪȨֵ
              4�����ݺշ��������������ַ����涨����(ǰ׺����)������·��Ϊ�㣬����·��Ϊ1
                 �������£�
                    o:1000; u:10010; d:100110; y:100111; i:101
                    a:110; k:1110; e:1111; j:0000; v:0001; l:001 �ո�:01
              5�������������룬�ַ�������Ӧ�ı���Ӧ��Ϊ����������ʹ������ѹ����
                101 01 00110111101111 01 00110111101111 01 00110111101111 01 00001100001110 01 1001101000
                01 100111100010010 01 00110111101111 01 110 01 00001100001110(�ո���Ϊ�����֣�����Ϊ133
             ˵����
                1��ԭ����359��ѹ����(359-133)/359 = 62.9%
                2���˱�������ǰ׺���룬�������ƥ��Ķ�����
                3���շ�����������������

             ���ܣ����ݺշ�������ѹ�����ݵ�ԭ����Ҫ����"i like like like java do you like a java"��Ӧ�շ�����
                ˼·��
                    1��Node{ data(�������), weight(Ȩֵ), left��right }
                    2���õ�"i like like like java do you like a java"��Ӧ��byte[] ����
                    3����дһ����������׼�������ĺշ�������Node���ŵ�List��
                        ��ʽ[Node[data=97,weight=5],Node[data=32,weight=9],...],
                        �ø���������d:1; y:1; u:1; j:2; v:2; o:2; l:4; k:4; e:4; i:5; a:5; �ո�:9
                    4������ͨ��List������Ӧ�ĺշ�����

*/

import java.io.*;
import java.util.*;

public class Demo14HuffmanCoding {

    public static void main(String[] args) {

        /*String content = "i like like like java do you like a java love";
        byte[] contentByte = content.getBytes();

        //�ֲ�����
        *//*System.out.println(contentByte.length);//40
        List<Node1> node = getNode(contentByte);
        System.out.println(node);

        System.out.println("�շ�����");
        Node1 huffmanTree = createHuffmanTree(node);
        preOrder(huffmanTree);

        //�����Ƿ������˶�Ӧ�ĺշ�������
        Map<Byte, String> codes = getCodes(huffmanTree);
        System.out.println(codes);

        byte[] huffmanCodeBytes = zip(contentByte, codes);
        System.out.println("huffmanCodeBytes = " + Arrays.toString(huffmanCodeBytes));*//*
        //ѹ�������룩

        byte[] huffmanZip = huffmanZip(contentByte);
        System.out.println("�����������" + huffmanCodes);
        System.out.println("ѹ����Ľ����" + Arrays.toString(huffmanZip));

        //��ѹ�����룩
        //System.out.println(byteToBitString(true,(byte)-128));
        byte[] bytes = deCode(huffmanCodes, huffmanZip);
        System.out.println(new String(bytes));*/

        zipFile("F:\\ͼƬ\\a.txt", "F:\\ͼƬ\\image.zip");
        unZipFile("F:\\ͼƬ\\image.zip","F:\\ͼƬ\\b.txt");

    }

    //��дһ����ѹ�ļ��ķ���
    //                            ����ѹ�ļ�·����  ��ѹ���ļ����·��
    public static void unZipFile(String zipFile, String detFile) {
        //�����ļ�������
        InputStream is = null;
        //����һ������������
        ObjectInputStream ois = null;
        //�����ļ��������
        OutputStream os = null;
        try {
            //�����ļ�������
            is = new FileInputStream(zipFile);
            //����һ����is���������������
            ois = new ObjectInputStream(is);
            //��ȡbyte���飬huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //��ȡ�շ��������
            Map<Byte,String> huffmanCodes = (Map<Byte,String>) ois.readObject();

            //����
            byte[] bytes = deCode(huffmanCodes, huffmanBytes);
            //��bytesд�뵽Ŀ���ļ�
            os = new FileOutputStream(detFile);
            os.write(bytes);

        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //��д��������һ���ļ�����ѹ��
    //                       ��ѹ��Դ�ļ�·��  ѹ������Ŀ���ļ�·��
    public static void zipFile(String srcFile, String dsFile) {
        //���������
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //�����ļ���������
        FileInputStream is = null;
        try {
            is = new FileInputStream(srcFile);
            //����һ����Դ�ļ���Сһ����byte����
            byte[] b = new byte[is.available()];

            //��ȡ�ļ�
            is.read(b);
            //System.out.println(new String(b));
            //��ȡ�ļ���Ӧ�ĺշ��������,ֱ�Ӷ�Դ�ļ�ѹ��
            byte[] huffmanZip = huffmanZip(b);

            //�����ļ�����������ѹ���ļ�
            os = new FileOutputStream(dsFile);
            //����һ�����ļ������������ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //�����Զ������ķ�ʽд��շ������룬Ϊ���Ժ��ѹʱʹ��
            oos.writeObject(huffmanZip);
            //�Ѻշ����������ֽ�����д��ѹ���ļ�

            //ע��һ���Ѻշ������룬д��ѹ���ļ�
            oos.writeObject(huffmanCodes);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //������ݵĽ�ѹ
    /*
        1����ѹ����Ľ����[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
            �ָ�Ϊ�ַ���"101010011011110111101001101111011110100110..."
        2���շ��������Ӧ�Ķ������ַ���"101010011011110111101001101111011110100110..." => ���պշ�������
            => "i like like like java do you like a java"
    */

    /**
     *
     * @param huffmanCodes �շ��������map
     * @param huffmanBytes �շ�������õ����ֽ�����
     * @return ����ԭ�����ַ�����Ӧ������
    */
    private static byte[] deCode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //�ȵõ�huffmanBytes ��Ӧ�Ķ������ַ�������ʽ"1010100010111111110010001..."
        StringBuilder stringBuilder = new StringBuilder();
        //��byte����ת�ɶ����Ƶ��ַ���
        for (byte huffmanByte : huffmanBytes) {
            stringBuilder.append(byteToBitString(huffmanByte));
        }
        //System.out.println("�շ����ֽ������Ӧ = " + stringBuilder.toString());

        //���ַ�����װָ���ĺշ���������н���
        //�Ѻշ���������е�������Ϊ�����ѯa->100, 100->a
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //System.out.println(map);

        //�������ϴ��byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length();i++) {
            int count = 1;//С�ļ�����
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //������ȡ�� ȡ��һ�� 1 ��0
                if (i+count > stringBuilder.length()) {
                    break;
                }
                String key = stringBuilder.substring(i, i+count); //i ��������count�ƶ���ָ��ƥ�䵽һ���ַ�
                b = map.get(key);
                if (b == null) {//δƥ�䵽
                    count++;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                list.add(b);
                i += count-1;
            }else {
                break;
            }

        }
        //��forѭ�����������еĵ����ַ��Ѿ����ȥ��
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * ��byteת��һ�������Ƶ��ַ���
     * @param b �����byte
     *
     * @return  �Ǹ�b ��Ӧ�Ķ����Ƶ��ַ�������ע���ǰ����뷵�أ�
    */
    private static String byteToBitString(byte b) {
        int temp = b;

        //��������������ǻ����ڲ���λ
        temp |= 256;//��λ��256 1 0000 0000 | 0000 0001 => 1 0000 0001



        String string = Integer.toBinaryString(temp);//���ص��Ƕ����ƵĲ���
        return string.substring(string.length() - 8);//�������ݵĺ��λ
    }


    //��װѹ�����̣����ڵ���
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node1> node = getNode(bytes);
        Node1 huffmanTreeRoot = createHuffmanTree(node);

        Map<Byte, String> codes = getCodes(huffmanTreeRoot);
        //System.out.println(new String(bytes));
        byte[] zip = zip(bytes, codes);

        return zip;
    }

    //��дһ�����������ַ�����Ӧ��byte���飬ͨ�����ɵĺշ������������һ���շ�������ѹ�����byte[]
    /**
     *
     * @param bytes ����ԭʼ���ַ�����Ӧ��byte[]
     * @param huffmanCodes ���ɵĺշ�������map
     * @return ���غշ������봦����byte[]
     * ������ String content = "i like like like java do you like a java";
     *        ==> byte[] contentByte = content.getBytes();
     *        ==>���ص��� �ַ���"1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100"
     *        ==> ��Ӧ��byte[] huffmanCodeBytes  ��8λ��Ӧһ��byte�����뵽huffmanCodeBytes
     *            huffmanCodeBytes[0] = 10101000(���룩 => byte[�Ƶ� 10101000 => 10101000 -1 => 10100111(����)
     *            => 11011000 = -88]
     *            huffmanCodeBytes[1] = -88
    */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {

        //1������huffmanCodes ��byte ת�� �շ��������Ӧ���ַ���
        StringBuilder stringBuilder = new StringBuilder();
        //����byte����
        for (byte b : bytes) {
            //System.out.print(b + " ");
            stringBuilder.append(huffmanCodes.get(b));
        }
        //System.out.println();
        //System.out.println(new String(bytes));
        //System.out.println("����stringBuilder = " + stringBuilder.toString());
        //System.out.println(huffmanCodes);

        //��1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
        //תΪbyte[]
        //ͳ�Ʒ��� byte[] huffmanCodeBytes ����
        int len;
        if (stringBuilder.length() %8 == 0) {
            len = stringBuilder.length()/8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //��һ��д�� int len = (stringBuilder.length() + 7)/8;
        //�����洢ѹ�����byte����
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//��¼�ڼ���byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
                for (int j = 0; j < i+8-stringBuilder.length(); j++) {
                    strByte  = strByte + "0";
                }
                //System.out.println(strByte);
            }else {
                strByte = stringBuilder.substring(i,i+8);
            }

            //��strByte ת��һ��byte�����뵽huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }

        return huffmanCodeBytes;
    }

    /*���ɺշ�������Ӧ�ĺշ�������
    ˼·��
        1�����շ������������Map<Byte,String> ��ʽ
            32 -> 01  97 -> 100 100 -> 11000 �ȵ���ʽ
        2�������ɺշ��������ʾ����Ҫȥƴ��·��������һ��StringBuilder �洢ĳ��Ҷ�ӽ���·��
     */
    static Map<Byte,String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    //Ϊ�˵��÷��㣬������getCodes
    private static Map<Byte, String> getCodes(Node1 root) {
        if (root == null) {
            return null;
        }
        //����������
        getCodes(root.left, "0", stringBuilder);
        //������
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }
    /**
     * ���ܣ��������node��������Ҷ�ӽ��ĺշ�������õ��������뵽huffmanCode����
     * @param node ������
     * @param code ·�������ӽ����0�����ӽ����1
     * @param stringBuilder ����ƴ��·��
    */
    private static void getCodes(Node1 node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder((stringBuilder));
        //��code���뵽stringBuilder
        stringBuilder1.append(code);
        if (node != null) {//���node==null������
            //�жϵ�ǰnode��Ҷ�ӽ�㻹�Ƿ�Ҷ�ӽ��
            if (node.data == null) {
                //�ݹ鴦��
                //����
                getCodes(node.left, "0", stringBuilder1);
                //���ҵݹ�
                getCodes(node.right, "1", stringBuilder1);
            } else {
                //�ͱ�ʾ�ҵ�ĳ��Ҷ�ӽ������
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }
    }


    //ǰ������ķ���
    private static void preOrder(Node1 root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("��Ϊ��");
        }
    }

    /**
     *
     * @param bytes �����ֽ�����
     * @return ���صľ���List��ʽ[Node[data=97,weight=5],Node[data=32,weight=9],...]
    */
    private static List<Node1> getNode(byte[] bytes) {
        //����һ��ArrayList
        ArrayList<Node1> nodes = new ArrayList<>();

        //����bytes��ͳ��ÿ��byte���ֵĴ��� -> map[key,value]
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b,1);
            } else {
                counts.put(b,count+1);
            }
        }

        //��ÿ����ֵ��ת��һ��Node���󣬲����뵽nodes����
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()) {
            nodes.add(new Node1(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    //ͨ��List ������Ӧ�ĺշ�����
    private static Node1 createHuffmanTree(List<Node1> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node1 left = nodes.remove(0);
            Node1 right = nodes.remove(0);

            Node1 parent = new Node1(left.weight + right.weight);

            parent.left = left;
            parent.right = right;

            nodes.add(parent);
        }
        //���Ľ����ǹ��������ĸ��ڵ�
        return nodes.get(0);
    }
}



class Node1 implements Comparable<Node1>{
    Byte data;//������ݱ�������'a' => 97
    int weight;//Ȩֵ����ʾ�ַ����ֵĴ���
    Node1 left;
    Node1 right;

    public Node1(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Node1(int weight) {
        this.weight = weight;
    }

    public int compareTo(Node1 o) {
        //��С��������
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
