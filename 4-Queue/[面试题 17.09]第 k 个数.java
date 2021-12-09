//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例
// 如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 61 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        // 速度稍慢，占用空间稍小
//        List<Integer> arr = new ArrayList<>();
//        int num3 = 0, num5 = 0, num7 = 0;
//        arr.add(1);
//        int ans = 1;
//        while (--k > 0) {
//            ans = Math.min(arr.get(num3) * 3, Math.min(arr.get(num5) * 5, arr.get(num7) * 7));
//            arr.add(ans);
//            if (ans == arr.get(num3) * 3) num3++;
//            if (ans == arr.get(num5) * 5) num5++;
//            if (ans == arr.get(num7) * 7) num7++;
//        }
//        return ans;

        // 速度更快，占用空间稍大
        ListNode head = new ListNode(1), p = head;
        ListNode num3 = head, num5 = head, num7 = head;
        int ans = 1;
        while (--k > 0) {
            ans = Math.min(num3.val * 3, Math.min(num5.val * 5, num7.val * 7));
            p.next = new ListNode(ans);
            p = p.next;
            if (ans == num3.val * 3) num3 = num3.next;
            if (ans == num5.val * 5) num5 = num5.next;
            if (ans == num7.val * 7) num7 = num7.next;
        }
        return p.val;

    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
