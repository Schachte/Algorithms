package StacksQueues;

import java.util.Stack;

/**
 * The goal is to create a queue using 2 stacks
 */
public class QueueUsing2Stacks {
    static Stack<String> stk1 = new Stack<>();
    static Stack<String> stk2 = new Stack<>();

    public static void main(String[] args) {
        add("sup");
        add("sup1");
        add("sup2");
        add("sup3");
        add("sup4");
        System.out.println(stk2.pop());
        System.out.println(stk2.pop());
        System.out.println(stk2.pop());
        System.out.println(stk2.pop());
        System.out.println(stk2.pop());
    }

    /** Adds an item onto the stack  */
    public static void add(String item) {
        if (stk2.size() == 0) {
            stk2.push(item);
        } else {

            // Need to do a swap with the auxillary stack
            while (stk2.size() != 0) {
                stk1.push(stk2.pop());
            }

            stk2.push(item);

            while (stk1.size() != 0) {
                stk2.push(stk1.pop());
            }
        }
    }
}
