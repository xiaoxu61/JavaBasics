package cn.learn.basic.Demo31InterFace;
/*
�ӿھ��Ƕ����Ĺ����淶
�ӿ���һֱ�����������ͣ�����Ҫ�����ݾ������еģ����󷽷�

��ζ���һ���ӿڵĸ�ʽ��
public interface �ӿ�����{
    //�ӿ�����
}
��ע�������˹ؼ���interface֮�󣬱������ɵ��ֽ����ļ���Ȼ�ǣ�.java --> .class

�����Java 7����ô�ӿ��п��԰����������У�
1������
2�����󷽷�

�����Java 8�������Զ�������У�
3��Ĭ�Ϸ���
4����̬����

�����Java9�������԰����У�
5��˽�з���

�ӿ�ʹ�ò��裺
1���ӿڲ���ֱ��ʹ�ã�������һ��ʵ��������ʵ�ָýӿ�
��ʽ��public class ʵ�������� implements �ӿ����� {
            //......
      }
2���ӿ�ʵ������븲����д��ʵ�֣��ӿ������еĳ��󷽷�
ʵ�֣�ȥ��abstract�ؼ��֣����Ϸ����������
3������ʵ����Ķ��󣬽���ʹ��

ע�����
���ʵ���ಢû�и��ǽӿ������еĳ��󷽷�����ô���ʵ�����Լ��ͱ���ʱ������
*/

public class InterFace {

    public static void main(String[] args) {
//        MyInterfaceAbstract inter = new MyInterfaceAbstract();//����д��������ֱ��new�ӿڶ���

        //����ʵ�����ʹ��
        MyInterFaceAbstractimpl impl = new MyInterFaceAbstractimpl();
        impl.methodAbs1();
        impl.methodAbs2();

    }

}
