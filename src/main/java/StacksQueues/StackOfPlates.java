package StacksQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOfPlates {
    // Keeps track of all the stacks we need to fill, etc.
    static List<Stack<String>> stackTracker = new ArrayList<>();
    static int currentStack = 0;
    static int thresh = 16; // Max 5 elements per stack before we topple

    public static void main(String[] args) {
        stackTracker.add(new Stack<>());
        for (int i = 0; i < 37; i++) {
            push("Item No. " + i);
        }
        System.out.println("Done!");
    }

    public static void push(String item){
        if (stackTracker.get(currentStack).size() < thresh) {
            stackTracker.get(currentStack).push(item);
        } else {
            currentStack+=1;
            stackTracker.add(new Stack<>());
            stackTracker.get(currentStack).add(item);
        }
    }
}
