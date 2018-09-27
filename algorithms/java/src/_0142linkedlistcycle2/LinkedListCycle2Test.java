package _0142linkedlistcycle2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListCycle2Test {

    private ListNode[] inputs;
    private ListNode[] outputs;

    @BeforeEach
    void prepare() {
        inputs = new ListNode[2];
        outputs = new ListNode[2];
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 0; i < 10; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }
        inputs[0] = head;
        outputs[0] = null;

        head = new ListNode(-1);
        p = head;
        ListNode cycle = null;
        for (int i = 0; i < 10; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
            if (i == 5) {
                cycle = node;
            }
        }
        p.next = cycle;
        inputs[1] = head;
        outputs[1] = cycle;
    }

    @Test
    void detectCycle1Test() {
        LinkedListCycle2 target = new LinkedListCycle2();
        for (int i = 0; i < inputs.length; i++) {
            assertEquals(outputs[i], target.detectCycle1(inputs[i]));
        }
    }

}