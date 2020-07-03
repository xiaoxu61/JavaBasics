package cn.learn.Data.Basic.CommonAlgorithm;
/*
��³˹�����㷨
    1���������Ȩ��ͨͼ����С���������㷨
    2������˼�룺����Ȩֵ��С�����˳��ѡ��n-1���ߣ�����֤n-1���߲����ɻ�·
    3���������������ȹ���һ��ֻ��n�������ɭ�֣�Ȼ����Ȩֵ��С������ͨ����ѡ����뵽ɭ���У���ʹɭ��
       ��������·��ֱ��ɭ�ֱ��һ����Ϊֹ
       ����ıߵ��������㲻��ָ��ͬһ���յ㣬���򽫹��ɻ�·
    Ӧ�ó���-����վ����
        B----10----C
      /   \      / | \
    12      7   6  |  3
    /        \ /   |   \
   A---16---- F    5    D
    \        / \   |   /
      14    9   2  |  4
        \  /     \ | /
          G---8----E
    1��ĳ��������7��վ��(A,B,C,D,E,F,G) ����Ҫ��·��7��վ����ͨ
    2������վ��ľ����ñ��߱�ʾ��Ȩ��������A-B����12����
    3���������·��֤����վ�㶼����ͨ�������ܵ��޽���·������

*/

import java.util.Arrays;

public class KruskalAlgorithm {
    private int edgeNum;//�ߵĸ���
    private char[] vertexs;//��������
    private int[][] matrix;//�ڽӾ���
    private static final int INF = Integer.MAX_VALUE;//INF��ʾ�������㲻����ͨ

    public static void main(String[] args) {
        char[] vertexs = {'A','B','C','D','E','F','G'};
        int[][] matrix = {
                {0,12,INF,INF,INF,16,14},
                {12,0,10,INF,INF,7,INF},
                {INF,10,0,3,5,6,INF},
                {INF,INF,3,0,4,INF,INF},
                {INF,INF,5,4,0,2,8},
                {16,7,6,INF,2,0,9},
                {14,INF,INF,INF,8,9,0}
        };
        //������³˹��������ʵ��
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(vertexs, matrix);
        kruskalAlgorithm.print();
        EData[] edges = kruskalAlgorithm.getEdges();
        System.out.println("����ǰ==>" + Arrays.toString(edges));
        kruskalAlgorithm.sortEdges(edges);
        System.out.println("�����==>" + Arrays.toString(edges));
        kruskalAlgorithm.kruskal();






    }

    //������
    public KruskalAlgorithm(char[] vertexs, int[][] matrix) {
        //��ʼ���������ͱߵĸ���
        int vlen = vertexs.length;

        //��ʼ������
        this.vertexs = new char[vlen];
        System.arraycopy(vertexs, 0, this.vertexs, 0, vertexs.length);

        //��ʼ���ߣ�ʹ�õ��Ǹ���copy�ķ�ʽ
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, vlen);
        }

        //ͳ�Ʊ�
        for (int i = 0; i < vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    //��ӡ�ڽӾ���
    public void print() {
        System.out.println("�ڽӾ���Ϊ");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%10d\t",anInt);
            }
            System.out.println();
        }
    }

    public void kruskal() {
        int index = 0;//��ʾ��������������
        int[] ends = new int[edgeNum];//���ڱ���"������С������"��ÿ����������С�������е��յ�
        //����������飬����������С������
        EData[] res = new EData[edgeNum];

        //��ȡͼ�����еıߵļ��ϣ�һ����12����
        EData[] edges = getEdges();
        //���ձߵ�Ȩֵ��С��������
        sortEdges(edges);

        //����edges���飬������ӵ���С������ʱ���ж�׼������ı��Ƿ񹹳ɻ�·�����û�оͼ���
        for (int i = 0; i < edgeNum; i++) {
            //��ȡ����i���ߵĵ�һ������
            int p1 = getPosition(edges[i].start);
            //��ȡ����i���ߵĵ�2������
            int p2 = getPosition(edges[i].end);

            //��ȡp1������������е���С�������е��յ�
            int m = getEnd(ends,p1);
            int n = getEnd(ends,p2);
            //�Ƿ񹹳ɻ�·
            if (m != n) {//û�й��ɻ�·
                ends[m] = n;//����m�ڡ�������С���������е��յ�
                res[index++] = edges[i];//��һ���߼��뵽res����
            }
        }
        //ͳ�Ʋ���ӡ��С������
        System.out.println("��С������Ϊ");
        for (int i = 0; i < index; i++) {
            System.out.print(res[i] + " ");
        }
    }
    //�Ա߽�������
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }

    //���붥���ֵ�����ظö����Ӧ���±꣬����Ҳ������򷵻�-1
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    //��ȡͼ�еıߣ�����EData[]�����У�������Ҫ����������
    //ͨ��matrix�ڽӾ�������ȡ EData[] --> ��ʽ[['A','B',12],['B','F',7]...]
    private EData[] getEdges() {
        int index = 0;
        EData[] edges= new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i+1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }

    //��ȡ�±�Ϊi�Ķ�����յ㣬�����ж�����������յ��Ƿ���ͬ
    //i��ʾ����Ķ����Ӧ���±�
    //���صľ����±�Ϊi����������Ӧ���յ���±�
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

//����һ����EData�����Ķ���ʵ�����Ǳ�ʾһ����
class EData{
    char start;//�ߵ�һ����
    char end;//�ߵ�����һ����
    int weight;//�ߵ�Ȩֵ

    //������
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    //��дtoString����

    @Override
    public String toString() {
        return "EData{" +
                start +
                "-->" + end +
                " = " + weight +
                '}';
    }
}