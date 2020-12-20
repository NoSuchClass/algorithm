package com.bitongchong.review;

import java.util.*;

/**
 * @author liuyuehe
 * @date 2020/6/21 10:44
 */
public class Week {
    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (start + 2 * i) ^ res;
        }
        return res;
    }

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String curName = names[i];
            if (!map.containsKey(curName)) {
                map.put(curName, 0);
            } else {
                int curTimes = map.get(curName) + 1;
                map.put(curName, curTimes);
                String newName = curName + "(" + curTimes + ")";
                while(map.containsKey(newName)) {
                    newName = curName +  "(" + ++curTimes + ")";
                }
                map.put(newName, 0);
                curName = newName;
            }
            res[i] = curName;
        }
        return res;
    }

    public int[] avoidFlood(int[] rains) {
        int curZero = 0;
        List<Integer> zeroIndexMemo = new LinkedList<>();
        Map<Integer, Integer> element = new HashMap<>();
        int[] res = new int[rains.length];
        int zeroIndex = -1;
        for (int i = 1; i < rains.length; i++) {
            if (rains[i] == rains[i - 1] && rains[i] != 0) {
                return new int[0];
            }
        }
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                res[i] = -1;
                if (element.containsKey(rains[i])) {
                    if (curZero == 0) {
                        return new int[0];
                    } else {
                        if (zeroIndex == -1) {
                            zeroIndex = zeroIndexMemo.get(curZero - 1);
                        }
                        for (Integer integer : zeroIndexMemo) {
                            if (integer > element.get(rains[i])) {
                                zeroIndex = integer;
                                break;
                            }
                        }
                        if (zeroIndex < element.get(rains[i])) {
                            return new int[0];
                        }
                        res[zeroIndex] = rains[i];
                        zeroIndexMemo.remove(Integer.valueOf(zeroIndex));
                        curZero--;
                        zeroIndex = zeroIndexMemo.size() == 0 ? -1 : zeroIndexMemo.get(curZero - 1);
                        element.remove(rains[i]);
                    }
                } else {
                    element.put(rains[i], i);
                }
            } else {
                curZero++;
                zeroIndexMemo.add(i);
            }
        }
        if (zeroIndexMemo.size() > 0) {
            for (Integer integer : zeroIndexMemo) {
                res[integer] = 1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        Week week = new Week();
        System.out.println(Arrays.toString(week.avoidFlood(new int[]{2,3,0,0,3,1,0,1,0,2,2})));
    }
}


























