package cn.learn.Data.Basic.CommonAlgorithm;
/*
   �Ͻ�˹�����㷨
        �ǵ������·���㷨�����ڼ���һ���ڵ㵽�����ڵ�����·����������Ҫ�ص�������ʼ��Ϊ����������
   ��չ�������������˼�룩��ֱ����չ���յ�Ϊֹ
        ���ó�������Ϊv�����㼯��V(v1,v2,v3....)��v��V�и�����ľ��빹�ɾ��뼯��Dis��Dis(d1,d2,d3....)
   Dis���ϼ�¼��v��ͼ�и�������ľ��루��������Կ���0��v��vi�ľ����ӦΪdi��
        ��Dis��ѡ��ֵ��С��di���Ƴ�Dis���ϣ�ͬʱ�Ƴ�V�����ж�Ӧ�Ķ���vi����ʱ��v��vi��Ϊ���·��
        ����Dis���ϣ����¹���Ϊ���Ƚ�v��V�����ж���ľ���ֵ����vͨ��vi��V�����ж���ľ���ֵ������ֵ��С
   ��һ����ͬʱҲӦ�ø��¶����ǰ���ڵ�Ϊvi��������ͨ��vi����ģ�
        �ظ�ִ�������裬ֱ�����·��ΪĿ�궥�㼴�ɽ���
        Ӧ�ó���-���·������
        A-------5--------B
       /  \             / \
      7     2         3     9
     /        \     /        \
    C            G            D
     \         /    \        /
      8      4        6     4
        \  /            \  /
          E------5--------F
     1��ս��ʱ�ڣ�ʤ������7����ׯA��B��C��D��E��F��G ���������ʲ��Ҫ�ֱ���ʼ��ֱ��͵���������ׯ
     2���ʣ���μ����G��ׯ��������ׯ����̾���
     3���������������������������̾������Ƕ��٣�
*/

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = {'A','B','C','D','E','F','G'};
        //�ڽӾ���
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{N,5,7,N,N,N,2};
        matrix[1] = new int[]{5,N,N,9,N,N,3};
        matrix[2] = new int[]{7,N,N,N,8,N,N};
        matrix[3] = new int[]{N,9,N,N,N,4,N};
        matrix[4] = new int[]{N,N,8,N,N,5,4};
        matrix[5] = new int[]{N,N,N,4,5,N,6};
        matrix[6] = new int[]{2,3,N,N,4,6,N};
        //����Graph
        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();
        //����
        graph.dsj(6);
    }
}

class Graph{
    private  char[] vertex;//��������
    private int[][] matrix;//�ڽӾ���
    private VisitedVertex vv;//�Ѿ����ʶ���ļ���

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    //��ʾͼ
    public void showGraph() {
        for (int[] link : matrix) {
            for (int i : link) {
                System.out.printf("%5d\t",i);
            }
            System.out.println();
        }
    }

    //�Ͻ�˹�����㷨

    /**
     *
     * @param index ��ʾ���������Ӧ���±�
     */
    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length,index);
        update(index);//����index���㵽��Χ����ľ����ǰ������

        for (int i = 1; i < vertex.length; i++) {
            index = vv.updateArr();//ѡ�񲢷����µķ��ʶ���
            update(index);//����index���㵽��Χ����ľ����ǰ������
        }
    }


    //����index�±궥�㵽��Χ����ľ������Χ�����ǰ������
    private void update(int index) {
        int len = 0;
        //���ݱ������ǵ��ڽӾ���matrix[index]��
        for (int i = 0; i < matrix[index].length; i++) {
            //len�����ǣ��������㵽index����ľ���+��index���㵽i����ľ���ĺ�
            len = vv.getDis(index) + matrix[index][i];
            //���i����û�б����ʹ�������lenС�ڳ������㵽i����ľ��룬����Ҫ����
            if (!vv.in(i) && len < vv.getDis(i)) {
                vv.updataPre(i,index);//����i�����ǰ��Ϊindex����
                vv.updateDis(i,len);//���³������㵽i����ľ���
            }
        }
    }
}

class VisitedVertex{
    //��¼���������Ƿ���ʹ���1��ʾ���ʹ���0δ���ʣ��ᶯ̬����
    public int[] already_arr;
    //ÿ���±��Ӧ��ֵΪǰһ�������±꣬����¶�̬
    public int[] pre_visited;
    //��¼�������㵽�������ж���ľ��룬����GΪ�������㣬�ͻ��¼G����������ľ��룬�ᶯ̬����
    //�����̾���ͻ��ŵ�dis
    public int[] dis;

    /**
     *
     * @param length ��ʾ����ĸ���
     * @param index ���������Ӧ���±꣬����G���㣬�±����6
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        //��ʼ��dis����
        Arrays.fill(dis,65535);
        this.already_arr[index] = 1;//���ó������㱻���ʹ�
        this.dis[index] = 0;//���ó�������ķ��ʾ���Ϊ0
    }

    /**
     * �ж�index�����Ƿ񱻷��ʹ�
     * @param index
     * @return ������ʹ����ͷ���true������ͷ���false
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * ���³������㵽index����ľ���
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * ����pre��������ǰ������Ϊindex����
     * @param pre
     * @param index
     */
    public void updataPre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * ���س������㵽index����ľ���
     * @param index
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * ����ѡ�񲢷����µķ��ʽڵ㣬���������G��󣬾���A��Ϊ�µķ��ʶ��㣨ע�ⲻ�ǳ������㣩
     * @return
     */
    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        //����index���㱻���ʹ�
        already_arr[index] = 1;
        return index;
    }

    public void show() {
        System.out.println("=================");
    }
}