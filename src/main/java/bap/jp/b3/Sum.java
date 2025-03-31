package bap.jp.b3;

import java.util.concurrent.Callable;

public class Sum  implements Callable<Integer> {
    private final int[] array;
    private final int start;
    private final int end;

    public Sum(int[] array, int start, int end) {
	this.array = array;
	this.start = start;
	this.end = end;
    }

    @Override
    public Integer call() {
	int sum = 0;
	for (int i = start; i < end; i++) {
	    sum += array[i];
	}
	System.out.println("Thread xử lý từ " + start + " đến " + (end - 1) + ", tổng: " + sum);
	return sum;
    }
}
