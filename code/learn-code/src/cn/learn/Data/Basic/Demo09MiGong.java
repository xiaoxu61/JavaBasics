package cn.learn.Data.Basic;

public class Demo09MiGong {
    public static void main(String[] args) {
        //�ȴ���һ����ά���飬ģ���Թ�
        int[][] map = new int[8][7];
        //ʹ��1��ʾǽ
        //����ȫ����Ϊ1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //����ȫ����Ϊ1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //���õ���
        map[3][1] = 1;
        map[3][2] = 1;
        //�����ͼ
        System.out.println("********��ͼ�����********");
        showMap(map);

        //ʹ�õݹ���ݣ���С����·
        System.out.println("С���߹�����ʶ����ͼ�����");
        setWay(map, 1, 1);
        showMap(map);

    }

    //ʹ�õݹ��������С����·
    /*
        map ��ʾ��ͼ
        i j ��ʾ���ĸ�λ�ÿ�ʼ����[1][1]
        ���С���ܵ���map[6][5]λ�ã���˵��ͨ·�ҵ�
        ��map[i][j]Ϊ0����ʾ·û���߹���Ϊ1��ʾǽ��2��ʾͨ·�����ߣ�3��ʾ�õ��Ѿ��߹��������߲�ͨ
        �����Թ��ǣ���Ҫȷ��һ�����ԣ���--����--����--��������õ��߲�ͨ�ٻ���
           ��ʾ
        return ����ҵ�ͨ·���ͷ���true�����򷵻�false
    */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0) {//��ǰ����㻹û���߹�
                //���ղ�����--����--����--������
                map[i][j] = 2;//�ٶ��õ������ͨ
                if (setWay(map, i+1, j)) {//������
                    return true;
                }else if (setWay(map, i, j+1)){//������
                    return true;
                }else if (setWay(map, i-1, j)) {//������
                    return true;
                }else if (setWay(map, i, j-1)) {//������
                    return true;
                }else {
                    //˵���õ��߲�ͨ����·
                    map[i][j] = 3;
                    return false;
                }

            }else {
                //���map[i][j] != 0��������1 2 3
                return false;
            }
        }
    }

    public static void showMap(int[][] map) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
