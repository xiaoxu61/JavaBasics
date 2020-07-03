package cn.learn.Data.Basic.CommonAlgorithm;
/*
    ̰���㷨��
        ̰���㷨��ָ�ڶ�����������ʱ����ÿһ��ѡ���ж���ȡ��û������ţ�����������ѡ�񣬴�ϣ���ܹ�����
    �������û������ŵ��㷨
        ̰���㷨���õ��Ľ����һ�������ŵĽ������ʱ��������Ž⣩�����Ƕ�����Խ��ƣ��ӽ������Ž�Ľ��
    ���ϸ�������-̰���㷨��˼·������
        ʹ��̰���㷨��Ч�ʸ�
        Ŀǰ��û���㷨���Կ��ټ���õ�׼����ֵ��ʹ��̰���㷨������Եõ��ǳ��ӽ��Ľ⣬����Ч�ʸߡ�ѡ�����
    �ϣ���Ϊ��Ҫ����ȫ����������С�ϼ�
        1���������еĹ㲥��̨���ҵ�һ�����������δ���ǵĵ����ĵ�̨���ε�̨���ܰ���һЩ���ǵĵ�������û�й�ϵ��
        2���������̨���뵽һ�������У�����ArrayList����취�Ѹõ�̨���ǵĵ������´αȽ�ʱȥ��
        3���ظ���һ��ֱ��������ȫ������
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        //�����㲥��̨�����뵽Map
        HashMap<String, HashSet<String>> broadCasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("����");
        hashSet1.add("�Ϻ�");
        hashSet1.add("���");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("����");
        hashSet2.add("����");
        hashSet2.add("����");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("�ɶ�");
        hashSet3.add("�Ϻ�");
        hashSet3.add("����");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("���");
        hashSet4.add("�Ϻ�");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("����");
        hashSet5.add("����");

        //���뵽map
        broadCasts.put("k1",hashSet1);
        broadCasts.put("k2",hashSet2);
        broadCasts.put("k3",hashSet3);
        broadCasts.put("k4",hashSet4);
        broadCasts.put("k5",hashSet5);

        //������еĵ���
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("����");
        allAreas.add("�Ϻ�");
        allAreas.add("���");
        allAreas.add("����");
        allAreas.add("�ɶ�");
        allAreas.add("����");
        allAreas.add("����");
        allAreas.add("����");

        //����ArrayList�����ѡ��ĵ�̨����
        ArrayList<String> selects = new ArrayList<>();

        //����һ����ʱ���ϣ��ڱ��������У���ű��������еĵ�̨���ǵĵ����͵�ǰ��û�и��ǵ����Ľ���
        HashSet<String> tempSet = new HashSet<>();

        //�����maxKey��������һ�α��������У��ܹ��������δ���ǵĵ�����Ӧ�ĵ�̨��key
        //���maxKey����Ϊnull�������뵽selects
        String maxKey = null;
        while (allAreas.size() != 0) {//���allAreas��Ϊ0�����ʾ��û�и��ǵ����еĵ���
            //û����һ��while����Ҫ
            maxKey = null;

            //����broadcast��ȡ����Ӧ��key
            for (String key : broadCasts.keySet()) {
                //û����һ��for
                tempSet.clear();

                //��ǰ���key�ܹ����ǵĵ���
                HashSet<String> areas = broadCasts.get(key);
                tempSet.addAll(areas);
                //���tempSet �� allAreas ���ϵĽ����������ḳ��tempSet
                tempSet.retainAll(allAreas);//�������еĲ��ֵļ��ϣ�����tempSet
                //�����ǰ���ϰ�����δ���ǵ�������������maxKeyָ��ļ��ϵ�������
                //����Ҫ����maxKey
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadCasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            //maxKey != null, ��Ӧ�ý�maxKey���뵽selects
            if (maxKey != null) {
                selects.add(maxKey);
                //��maxKeyָ��Ĺ㲥��̨���ǵĵ�����allAreasȥ��
                allAreas.removeAll(broadCasts.get(maxKey));
            }
        }

        System.out.println("�õ��Ľ��" + selects);

    }
}
