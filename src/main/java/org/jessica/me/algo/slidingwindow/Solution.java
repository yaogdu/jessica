package org.jessica.me.algo.slidingwindow;

import com.alibaba.fastjson.JSON;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 类Solution的实现描述：    239.
 *
 * @author duyaoguang 2020/8/16 7:26 下午
 */
public class Solution {

    public static void main(String[] args) {
        int[] num = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(JSON.toJSONString(find(num, k)));
    }

    public static int[] find(int[] nums, int k) {
        Deque<Integer> max = new ArrayDeque<>();
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int result[] = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                if (max.peekFirst() == nums[i - k]) {
                    max.removeFirst();
                }
            }
            while (!max.isEmpty() && nums[i] > max.peekLast()) {
                max.removeLast();
            }

            max.addLast(nums[i]);
            if (i >= k - 1) {
                result[index++] = max.peekFirst();
            }
        }
        return result;
    }
 

}
