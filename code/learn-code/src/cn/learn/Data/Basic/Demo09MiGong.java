package cn.learn.Data.Basic;

public class Demo09MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //输出地图
        System.out.println("********地图的情况********");
        showMap(map);

        //使用递归回溯，给小球找路
        System.out.println("小球走过并标识过地图的情况");
        setWay(map, 1, 1);
        showMap(map);

    }

    //使用递归回溯来给小球找路
    /*
        map 表示地图
        i j 表示从哪个位置开始出发[1][1]
        如果小球能到达map[6][5]位置，则说明通路找到
        当map[i][j]为0，表示路没有走过；为1表示墙；2表示通路可以走；3表示该点已经走过，但是走不通
        在走迷宫是，需要确定一个策略，下--》右--》上--》左，如果该点走不通再回溯
           表示
        return 如果找到通路，就返回true，否则返回false
    */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0) {//当前这个点还没有走过
                //按照策略下--》右--》上--》左走
                map[i][j] = 2;//假定该点可以走通
                if (setWay(map, i+1, j)) {//向下走
                    return true;
                }else if (setWay(map, i, j+1)){//向右走
                    return true;
                }else if (setWay(map, i-1, j)) {//向上走
                    return true;
                }else if (setWay(map, i, j-1)) {//向左走
                    return true;
                }else {
                    //说明该点走不通是死路
                    map[i][j] = 3;
                    return false;
                }

            }else {
                //如果map[i][j] != 0，可能是1 2 3
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
