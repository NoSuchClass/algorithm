package com.bitongchong.classicalproblem;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，正数k 参数4，正数costs[i]表示i号项目的花费
 *  profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多做k个项目 m表示你初始的资金说明：
 *  你每做完一个项目，马上获得的收益，可以支持你去做下一个 项目。输出： 你最后获得的最大钱
 */
public class Code_8_2_MoreMoney {
	public static class Project {
		public int cost;
		public int profit;

		public Project(int cost, int profit) {
			this.cost = cost;
			this.profit = profit;
		}
	}

	public static int findMoreMoney(int[] cost, int[] profit, int w, int k) {
		PriorityQueue<Project> costQueue = new PriorityQueue<>(new Comparator<Project>() {
			@Override
			public int compare(Project o1, Project o2) {
				return o1.cost - o2.cost;
			}
		});
		PriorityQueue<Project> profitQueue = new PriorityQueue<>(new Comparator<Project>() {
			@Override
			public int compare(Project o1, Project o2) {
				return o2.profit - o1.profit;
			}
		});
		Project curProjest;
		for (int i = 0; i < profit.length; i++) {
			curProjest = new Project(cost[i], profit[i]);
			costQueue.offer(curProjest);
		}
		while (k != 0) {
			while (!costQueue.isEmpty() && costQueue.peek().cost <= w) {
				profitQueue.offer(costQueue.poll());
			}
			if (!profitQueue.isEmpty()) {
				w += profitQueue.poll().profit;
				k--;
			}else {
				return w;
			}
		}
		return w;
	}
	
	public static void main(String[] args) {
		int[] cost = new int[] {5, 10, 6, 20};
		int[] profit = new int[] {3, 2 ,4 ,9};
		int w = 7;
		int k = 4;
		System.out.println(findMoreMoney(cost, profit, w, k));
	}
}
