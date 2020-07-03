package cn.learn.basic.Demo12;

import java.util.concurrent.Callable;

public class GetSunmCallable implements Callable<Integer> {

    private int a;
    public GetSunmCallable(int a) {
        this.a = a;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i <= a; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
