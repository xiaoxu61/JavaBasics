package cn.learn.Data.Basic;
/*
    赫夫曼编码是一种程序算法，是哈夫曼树在电讯通信中的经典应用之一，广泛地用于数据文件压缩
    是可变字长编码的一种
    变长编码：
        按照各个字符出现的次数进行编码，原则是出现次数越多的，则编码越小
        例如：i like like like java do you like a java  共40个字符，包括空格
        d:1; y:1; u:1; j:2; v:2; o:2; l:4; k:4; e:4; i:5; a:5; 空格:9
        0=空格; 1=a; 10=i; 11=e; 100=k; 101=l; 110=o; 111=v; 1000=j; 1001=u; 1010=y; 1011=d
       按照上述字符规定的编码，则我传输 i like like like java do you like a java数据时，编码就是
       10 0 101 10 100...
       字符编码都不能是其他字符编码的前缀，符合要求的编码叫做前缀编码，即不能匹配到重复的编码
    赫夫曼编码：
         例如：
              1、"i like like like java do you like a java"  共40个字符，包括空格
              2、d:1; y:1; u:1; j:2; v:2; o:2; l:4; k:4; e:4; i:5; a:5; 空格:9 //统计各个字符的个数
              3、按照上述字符出现的次数，构建一棵赫夫曼树，次数作为权值
              4、根据赫夫曼树，给各个字符，规定编码(前缀编码)，向左路径为零，向右路径为1
                 编码如下：
                    o:1000; u:10010; d:100110; y:100111; i:101
                    a:110; k:1110; e:1111; j:0000; v:0001; l:001 空格:01
              5、按照上述编码，字符串所对应的编码应该为（这里我们使用无损压缩）
                101 01 00110111101111 01 00110111101111 01 00110111101111 01 00001100001110 01 1001101000
                01 100111100010010 01 00110111101111 01 110 01 00001100001110(空格是为了区分）长度为133
             说明：
                1、原长度359，压缩了(359-133)/359 = 62.9%
                2、此编码满足前缀编码，不会造成匹配的多义性
                3、赫夫曼编码是无损处理方案

             功能：根据赫夫曼编码压缩数据的原理，需要创建"i like like like java do you like a java"对应赫夫曼树
                思路：
                    1、Node{ data(存放数据), weight(权值), left和right }
                    2、得到"i like like like java do you like a java"对应的byte[] 数组
                    3、编写一个方法，将准备构建的赫夫曼树的Node结点放到List，
                        形式[Node[data=97,weight=5],Node[data=32,weight=9],...],
                        用改数组体现d:1; y:1; u:1; j:2; v:2; o:2; l:4; k:4; e:4; i:5; a:5; 空格:9
                    4、可以通过List创建对应的赫夫曼树

*/

import java.io.*;
import java.util.*;

public class Demo14HuffmanCoding {

    public static void main(String[] args) {

        /*String content = "i like like like java do you like a java love";
        byte[] contentByte = content.getBytes();

        //分步过程
        *//*System.out.println(contentByte.length);//40
        List<Node1> node = getNode(contentByte);
        System.out.println(node);

        System.out.println("赫夫曼树");
        Node1 huffmanTree = createHuffmanTree(node);
        preOrder(huffmanTree);

        //测试是否生成了对应的赫夫曼编码
        Map<Byte, String> codes = getCodes(huffmanTree);
        System.out.println(codes);

        byte[] huffmanCodeBytes = zip(contentByte, codes);
        System.out.println("huffmanCodeBytes = " + Arrays.toString(huffmanCodeBytes));*//*
        //压缩（编码）

        byte[] huffmanZip = huffmanZip(contentByte);
        System.out.println("哈夫曼编码表：" + huffmanCodes);
        System.out.println("压缩后的结果：" + Arrays.toString(huffmanZip));

        //解压（解码）
        //System.out.println(byteToBitString(true,(byte)-128));
        byte[] bytes = deCode(huffmanCodes, huffmanZip);
        System.out.println(new String(bytes));*/

        zipFile("F:\\图片\\a.txt", "F:\\图片\\image.zip");
        unZipFile("F:\\图片\\image.zip","F:\\图片\\b.txt");

    }

    //编写一个解压文件的方法
    //                            带解压文件路径，  解压后文件存放路径
    public static void unZipFile(String zipFile, String detFile) {
        //定义文件输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和is关联的输入对象流
            ois = new ObjectInputStream(is);
            //读取byte数组，huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取赫夫曼编码表
            Map<Byte,String> huffmanCodes = (Map<Byte,String>) ois.readObject();

            //解码
            byte[] bytes = deCode(huffmanCodes, huffmanBytes);
            //将bytes写入到目标文件
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


    //编写方法，将一个文件进行压缩
    //                       待压缩源文件路径  压缩后存放目的文件路径
    public static void zipFile(String srcFile, String dsFile) {
        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //创建文件的输入流
        FileInputStream is = null;
        try {
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte数组
            byte[] b = new byte[is.available()];

            //读取文件
            is.read(b);
            //System.out.println(new String(b));
            //获取文件对应的赫夫曼编码表,直接对源文件压缩
            byte[] huffmanZip = huffmanZip(b);

            //创建文件输出流，存放压缩文件
            os = new FileOutputStream(dsFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //这里以对象流的方式写入赫夫曼编码，为了以后解压时使用
            oos.writeObject(huffmanZip);
            //把赫夫曼编码后的字节数组写入压缩文件

            //注意一定把赫夫曼编码，写入压缩文件
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

    //完成数据的解压
    /*
        1、将压缩后的结果：[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
            恢复为字符串"101010011011110111101001101111011110100110..."
        2、赫夫曼编码对应的二进制字符串"101010011011110111101001101111011110100110..." => 对照赫夫曼编码
            => "i like like like java do you like a java"
    */

    /**
     *
     * @param huffmanCodes 赫夫曼编码表map
     * @param huffmanBytes 赫夫曼编码得到的字节数组
     * @return 就是原来的字符串对应的数组
    */
    private static byte[] deCode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //先得到huffmanBytes 对应的二进制字符串，形式"1010100010111111110010001..."
        StringBuilder stringBuilder = new StringBuilder();
        //将byte数组转成二进制的字符串
        for (byte huffmanByte : huffmanBytes) {
            stringBuilder.append(byteToBitString(huffmanByte));
        }
        //System.out.println("赫夫曼字节数组对应 = " + stringBuilder.toString());

        //把字符串安装指定的赫夫曼编码进行解码
        //把赫夫曼编码进行调换，因为反向查询a->100, 100->a
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //System.out.println(map);

        //创建集合存放byte
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length();i++) {
            int count = 1;//小的计数器
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //递增的取出 取出一个 1 或0
                if (i+count > stringBuilder.length()) {
                    break;
                }
                String key = stringBuilder.substring(i, i+count); //i 不动，让count移动，指定匹配到一个字符
                b = map.get(key);
                if (b == null) {//未匹配到
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
        //当for循环结束后，所有的单个字符已经存进去了
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将byte转成一个二进制的字符串
     * @param b 传入的byte
     *
     * @return  是该b 对应的二进制的字符串，（注意是按补码返回）
    */
    private static String byteToBitString(byte b) {
        int temp = b;

        //如果是整数，我们还存在补高位
        temp |= 256;//按位或256 1 0000 0000 | 0000 0001 => 1 0000 0001



        String string = Integer.toBinaryString(temp);//返回的是二进制的补码
        return string.substring(string.length() - 8);//返回数据的后八位
    }


    //封装压缩过程，便于调用
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node1> node = getNode(bytes);
        Node1 huffmanTreeRoot = createHuffmanTree(node);

        Map<Byte, String> codes = getCodes(huffmanTreeRoot);
        //System.out.println(new String(bytes));
        byte[] zip = zip(bytes, codes);

        return zip;
    }

    //编写一个方法，将字符串对应的byte数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]
    /**
     *
     * @param bytes 这是原始的字符串对应的byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的byte[]
     * 举例： String content = "i like like like java do you like a java";
     *        ==> byte[] contentByte = content.getBytes();
     *        ==>返回的是 字符串"1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100"
     *        ==> 对应的byte[] huffmanCodeBytes  即8位对应一个byte，放入到huffmanCodeBytes
     *            huffmanCodeBytes[0] = 10101000(补码） => byte[推导 10101000 => 10101000 -1 => 10100111(反码)
     *            => 11011000 = -88]
     *            huffmanCodeBytes[1] = -88
    */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {

        //1、利用huffmanCodes 将byte 转成 赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历byte数组
        for (byte b : bytes) {
            //System.out.print(b + " ");
            stringBuilder.append(huffmanCodes.get(b));
        }
        //System.out.println();
        //System.out.println(new String(bytes));
        //System.out.println("测试stringBuilder = " + stringBuilder.toString());
        //System.out.println(huffmanCodes);

        //将1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
        //转为byte[]
        //统计返回 byte[] huffmanCodeBytes 长度
        int len;
        if (stringBuilder.length() %8 == 0) {
            len = stringBuilder.length()/8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //另一种写法 int len = (stringBuilder.length() + 7)/8;
        //创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//记录第几个byte
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

            //将strByte 转成一个byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }

        return huffmanCodeBytes;
    }

    /*生成赫夫曼树对应的赫夫曼编码
    思路：
        1、将赫夫曼编码表存放在Map<Byte,String> 形式
            32 -> 01  97 -> 100 100 -> 11000 等等形式
        2、在生成赫夫曼编码表示，需要去拼接路径，定义一个StringBuilder 存储某个叶子结点的路径
     */
    static Map<Byte,String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    //为了调用方便，我重载getCodes
    private static Map<Byte, String> getCodes(Node1 root) {
        if (root == null) {
            return null;
        }
        //处理左子树
        getCodes(root.left, "0", stringBuilder);
        //右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }
    /**
     * 功能：将传入的node结点的所有叶子结点的赫夫曼编码得到，并放入到huffmanCode集合
     * @param node 传入结点
     * @param code 路径：左子结点是0，右子结点是1
     * @param stringBuilder 用于拼接路径
    */
    private static void getCodes(Node1 node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder((stringBuilder));
        //将code加入到stringBuilder
        stringBuilder1.append(code);
        if (node != null) {//如果node==null不处理
            //判断当前node是叶子结点还是非叶子结点
            if (node.data == null) {
                //递归处理
                //向左
                getCodes(node.left, "0", stringBuilder1);
                //向右递归
                getCodes(node.right, "1", stringBuilder1);
            } else {
                //就表示找到某个叶子结点的最后
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }
    }


    //前序遍历的方法
    private static void preOrder(Node1 root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树为空");
        }
    }

    /**
     *
     * @param bytes 接收字节数组
     * @return 返回的就是List形式[Node[data=97,weight=5],Node[data=32,weight=9],...]
    */
    private static List<Node1> getNode(byte[] bytes) {
        //创建一个ArrayList
        ArrayList<Node1> nodes = new ArrayList<>();

        //遍历bytes，统计每个byte出现的次数 -> map[key,value]
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b,1);
            } else {
                counts.put(b,count+1);
            }
        }

        //把每个键值对转成一个Node对象，并加入到nodes集合
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()) {
            nodes.add(new Node1(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    //通过List 创建对应的赫夫曼树
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
        //最后的结点就是哈夫曼树的根节点
        return nodes.get(0);
    }
}



class Node1 implements Comparable<Node1>{
    Byte data;//存放数据本身，比如'a' => 97
    int weight;//权值，表示字符出现的次数
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
        //从小到达排序
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
