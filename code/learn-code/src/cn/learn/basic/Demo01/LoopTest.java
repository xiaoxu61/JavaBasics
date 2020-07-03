package cn.learn.basic.Demo01;

/*
   利用循环，输出字母包含大写小写，52个
   输出A~Z a~z
   利用编码表实现字母和数字的对应关系
   A~Z 65~90
   a~z 97~122

   实现步骤：
      1、定义变量，保存小写a，大写A
      2、循环26次，输出定义好的变量
         每次循环变量++
 */
public class LoopTest {
    public static void main(String[] args){
        //定义变量，保存两个字母
        char xiaoxie = 'a';
        char daxie = 'A';
        //定义循环，次数26次
        for(int i = 0; i < 26; i++){
            System.out.print(xiaoxie+""+daxie);
            daxie++;
            xiaoxie++;
        }
    }
}
