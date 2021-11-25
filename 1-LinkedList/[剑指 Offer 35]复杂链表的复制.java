//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/ 
//
// 
// Related Topics 哈希表 链表 
// 👍 350 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 1. 复制每个节点，并挂在原节点next上
        Node pointer = head;
        while (pointer != null) {
            Node node = new Node(pointer.val);
            node.random = pointer.random;
            node.next = pointer.next;
            pointer.next = node;
            pointer = pointer.next.next;
        }
        // 2. 修改新节点的random指针
        pointer = head;
        while (pointer != null) {
            if (pointer.random != null) pointer.next.random = pointer.random.next;
            pointer = pointer.next.next;
        }
        // 3. 拆开新老链表
        Node newHead = head.next;
        pointer = head;
        Node newPointer = newHead;
        while (newPointer.next != null) {
            pointer.next = pointer.next.next;
            pointer = pointer.next;

            newPointer.next = newPointer.next.next;
            newPointer = newPointer.next;
        }
        pointer.next = null;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
