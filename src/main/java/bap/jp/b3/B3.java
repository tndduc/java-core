package bap.jp.b3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class B3 {
    public static void main(String[] args) {
	int[] array = new int[100];
	for (int i = 0; i < array.length; i++) {
	    array[i] = i + 1;
	}

	int numThreads = 4;
	ExecutorService executor = Executors.newFixedThreadPool(numThreads);
	List<Future<Integer>> futures = new ArrayList<>();

	int chunkSize = array.length / numThreads;
	for (int i = 0; i < numThreads; i++) {
	    int start = i * chunkSize;
	    int end = (i == numThreads - 1) ? array.length : start + chunkSize;
	    futures.add(executor.submit(new Sum(array, start, end)));
	}

	int totalSum = 0;
	for (Future<Integer> future : futures) {
	    try {
		totalSum += future.get();
	    } catch (InterruptedException | ExecutionException e) {
		e.printStackTrace();
	    }
	}

	executor.shutdown();
	System.out.println("Tổng của mảng: " + totalSum);
    }
}
