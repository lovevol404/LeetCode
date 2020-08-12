package solution.list;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianming
 */
public class ListSolution {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode listNode = head;

        while (head !=null){
            listNodes.add(head);
            head = head.next;
        }
        int size = listNodes.size();

        ListNode remove = listNodes.get((size - n));

        if (size == n){
            return remove.next;
        }
        listNodes.get((size - n) -1).next = remove.next;
        return listNode;
    }

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle/
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        return null;
    }


}
