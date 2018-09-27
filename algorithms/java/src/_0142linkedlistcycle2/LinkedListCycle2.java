/**
 * Source: https://leetcode.com/problems/linked-list-cycle-ii/
 * Source(zh): https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * Author: Jacob Yin
 * Date: 2018-09-27
 * <p>
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */

package _0142linkedlistcycle2;

import java.util.HashMap;

public class LinkedListCycle2 {

    public ListNode detectCycle1(ListNode head) {
        // 使用哈希表来辅助判断是否存在循环链表，一旦遍历到的元素存在于表中，则该节点即为循环起始点。
        // 时间复杂度O(n)，空间复杂度O(n)
        if (head == null) {
            return null;
        }
        HashMap<ListNode, Integer> cache = new HashMap<>();
        while (head != null && !cache.containsKey(head)) {
            cache.put(head, 0);
            head = head.next;
        }
        return head;
    }

}
