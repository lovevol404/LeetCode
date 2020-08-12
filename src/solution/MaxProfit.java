package solution; /**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tianming
 */
public class MaxProfit {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int p = prices[i + 1] - prices[i];
            if (p > 0) {
                max += p;
            }
        }
        return max;
    }

    public boolean containsDuplicate(int[] nums) {
        List<Integer> collect = Arrays.stream(nums)
                .parallel()
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        Integer pre = null;
        for (Integer integer : collect) {
            if (pre != null) {
                if (pre.equals(integer)) {
                    return true;
                }
            }
            pre = integer;
        }
        return false;
    }
}
