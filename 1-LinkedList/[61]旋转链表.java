//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 664 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode hair = new ListNode(-1, head);
        ListNode pointer = head;
        int length = 0;
        while (pointer != null) {
            length++;
            pointer = pointer.next;
        }
        if (length < 2) return head;
        k = length - (k % length);
        while (k-- > 0) {
            pointer = hair.next;
            hair.next = pointer.next;
            pointer.next = null;
            ListNode tmp = hair.next;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = pointer;
        }
        return hair.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
