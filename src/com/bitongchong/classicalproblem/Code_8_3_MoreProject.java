package com.bitongchong.classicalproblem;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 现在有一个会议室，有很多需要在里面开会的项目
 * 现在给出每个项目开会需要的时间段（开始时间与结束时间）
 * 求出这个会议室一天之中最多能够让几个项目开会
 */
public class Code_8_3_MoreProject {
	public static class Project {
		public int start;
		public int end;

		public Project(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static int findMoreProject(int[] startTime, int[] endTime) {
		PriorityQueue<Project> queue = new PriorityQueue<>(new Comparator<Project>() {
			@Override
			public int compare(Project o1, Project o2) {
				return o1.end - o2.end;
			}
		});
		for (int i = 0; i < endTime.length; i++) {
			queue.offer(new Project(startTime[i], endTime[i]));
		}
		int endNowTime = queue.poll().end;
		int count = 1;
		while (!queue.isEmpty()) {
			if (queue.peek().start < endNowTime) {
				queue.poll();
			} else {
				endNowTime = queue.poll().end;
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] startTime = new int[] {1,4,6,9};
		int[] endTime = new int[] {5,6,10,10};
		System.out.println(findMoreProject(startTime, endTime));
	}
}
