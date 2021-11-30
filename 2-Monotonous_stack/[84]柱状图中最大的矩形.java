//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 单调栈 
// 👍 1641 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int[] l = new int[heights.length];
        int[] r = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            l[i] = -1;
            r[i] = heights.length;
        }
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                r[stack.pop()] = i;
            }
            if (!stack.isEmpty()) l[i] = stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            ans = Math.max(ans, heights[i] * (r[i] - l[i] - 1));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
