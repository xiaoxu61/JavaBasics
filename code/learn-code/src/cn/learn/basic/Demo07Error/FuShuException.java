package cn.learn.basic.Demo07Error;
/*
    �Զ����쳣
        �̳�Exception����RuntimeException
        ���췽���У�super���쳣��Ϣ�����ݸ�����
*/

public class FuShuException extends RuntimeException {
    public FuShuException(String s){
        super(s);
    }
}
