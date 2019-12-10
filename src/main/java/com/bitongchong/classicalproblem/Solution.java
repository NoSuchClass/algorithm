package com.bitongchong.classicalproblem;

import java.util.concurrent.ExecutionException;

public class Solution {
	static class Func extends Thread {
		@Override
		public void run() {

			try {
				int i = 0;
				while(true && !this.isInterrupted()) {
					System.out.println(i++);
				}
				throw new InterruptedException();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*
		 * ExecutorService executorService = Executors.newFixedThreadPool(8);
		 * Future<Integer> future = executorService.submit(new Callable<Integer>() {
		 * 
		 * @Override public Integer call() throws InterruptedException {
		 * Thread.sleep(1000); return 2; } }); System.out.println(future.get());
		 * executorService.shutdown(); FutureTask<Integer> task = new FutureTask<>(new
		 * Callable<Integer>() {
		 * 
		 * @Override public Integer call() { return 1; } }); Thread thread = new
		 * Thread(task); thread.start(); System.out.println(task.get());
		 */
		Func func = new Func();
		func.start();
		Thread.sleep(10000);
		func.interrupt();
	}
}