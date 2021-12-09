//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2519 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
//        1. 先统计，在计算
//        Deque<Integer> stack = new LinkedList<>();
//        int[] l = new int[height.length];
//        int[] r = new int[height.length];
//        for (int i = 0; i < height.length; i++) {
//            l[i] = -1;
//        }
//        for (int i = 0; i < height.length; i++) {
//            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
//                r[stack.pop()] = i;
//            }
//            if (!stack.isEmpty()) l[i] = stack.peek();
//            stack.push(i);
//        }
//        int ans = 0;
//        for (int i = 1; i < height.length - 1; i++) {
//            if (l[i] != -1 && r[i] != 0) {
//                ans += (r[i] - l[i] - 1) * Math.min(height[l[i]] - height[i], height[r[i]] - height[i]);
//            }
//        }
//        return ans;

//        2. 统计中 直接计算
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int curr = stack.pop();
                if (stack.isEmpty()) continue;
                ans += (i - stack.peek() - 1) * Math.min(height[i] - height[curr], height[stack.peek()] - height[curr]);
            }
            stack.push(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
