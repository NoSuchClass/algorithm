package com.bitongchong.test;

import java.util.ArrayList;

public class BlockingQueueLitle<T> {
	Object empty = new Object();
	Object full = new Object();
	ArrayList<Object> queue;
	int count = 0;
	int queueSize;

	public BlockingQueueLitle(int initSize) {
		queue = new ArrayList<Object>(initSize);
		queueSize = initSize;
	}

	public void add(T obj) {
		synchronized (full) {
			while (count == queueSize) {
				try {
					full.wait();
				} catch (InterruptedException e) {
					break;
				}
			}
		}
		synchronized(empty) {
			queue.add(obj);
			empty.notify();
			count++;
		}
	}

	public T get() {
		synchronized (empty) {
			while(count == 0) {
				try {
					empty.wait();
				} catch (InterruptedException e) {
					break;
				}
			}
			full.notify();
			return (T) queue.get(count--);
		}
	}

	public static void main(String[] args) {
		BlockingQueueLitle<String> queueLitle = new BlockingQueueLitle<>(1);
		queueLitle.add("2345");
		queueLitle.add("345");
		System.out.println(queueLitle.get());
	}
}