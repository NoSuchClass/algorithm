package com.bitongchong.leetcode;

/**
 * @author liuyuehe
 * @date 2020/5/27 9:01
 */
public class Code_974_SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        // 对于java的 % 操作的一些实例
        System.out.println(-1 % -5);
        System.out.println(-11 % -5);
        System.out.println(-7 % 3);
        System.out.println(4 % 5 == (-11 % 5 + 5) % 5);
        System.out.println(new Code_974_SubarraySumsDivisibleByK().subarraysDivByK2(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }

    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum % K == 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraysDivByK2(int[] A, int K) {
        // 优化一：这道题也可以使用hash表来存储，但是实际上所有的余数都不可能超过K的大小，因此直接创建一个数组来存储即可
        int[] memo = new int[K];
        int preSum = 0;
        int ans = 0;
        // 重点三：由于整体是按照同余定理来判断是否被整除的，但是有个特殊情况就是当前缀和本身就能够被整除时，就算一次结果，
        // 而不能被整除时还需要判断数组中是否存在对应的值，如果存在就有满足同余定理的，同时因为可以和前面的进行组合，因此
        // 令最后的ans加上对应的值
        memo[0] = 1;
        for (int i = 0; i < A.length; i++) {
            // 重点一：前缀和
            preSum += A[i];
            // 重点二：java的取模操作是按照被除数的符号确定的，而数学上满足同余定理的取余是按照除数符号确定的，因此需要做特殊处理
            int mod = (preSum % K + K) % K;
            ans += memo[mod];
            memo[mod] = memo[mod] + 1;
        }
        return ans;
    }
}
