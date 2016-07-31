/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return head;
        }
        
        // HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        
        // RandomListNode cur = head;
        
        // // new node
        // while (cur != null) {
        //     map.put(cur, new RandomListNode(cur.label));
        //     cur = cur.next;
        // }
        
        // // connnect
        // cur = head;
        // while(cur != null) {
        //     map.get(cur).next = map.get(cur.next);
        //     map.get(cur).random = map.get(cur.random);
        //     cur = cur.next;
        // }
        
        // return map.get(head);
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
    
    public void copyNext(RandomListNode head) {
        while(head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            newNode.random = head.random;
            head.next = newNode;
            head = head.next.next;
        }
    }
    
    public void copyRandom(RandomListNode head) {
        while(head != null) {
            RandomListNode newNode = head.next;
            if (newNode.random != null) {
                newNode.random = head.random.next;
            }
            head = newNode.next;
        }
    }
    
    public RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next;
        
        while(head != null) {
            RandomListNode newNode = head.next;
            head.next = head.next.next;
            if(newNode.next != null) {
                newNode.next = newNode.next.next;
            } 
            head = head.next;
        }
        
        return newHead;
    }
}