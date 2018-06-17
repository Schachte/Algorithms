package StacksQueues;

import java.util.Stack;

/**
 * The goal is to have an automatic stack sorter which contains the smallest elements on the top
 */
public class StackSorter {
    static Stack<Integer> items = new Stack<>();
    static Stack<Integer> auxillary = new Stack<>();
    static int[] stackData;

    public static void main(String[] args) {
        createFillPrint(new int[]{7,9,2,3,0,1});
        createFillPrint(new int[]{5,1,2,4,3,0,3});
    }

    public static void createFillPrint(int[] datArr) {
        fillStack(datArr);
        printStack();
    }

    public static void printStack() {
        while (items.size() > 0) {
            System.out.print(items.pop() + ", ");
        }
        System.out.println("");
        System.out.println("---------------------");
    }

    public static void fillStack(int[] datArr) {
        for (int item : datArr) {
            add(item);
        }
    }

    public static void add(int item) {
        if (items.size() == 0) items.push(item);
        else if (item > items.peek()) {
            quickSwap(item);
        } else {
            items.push(item);
        }
    }

    public static void quickSwap(int item) {
        while (items.size() > 0 && item > items.peek()) {
            auxillary.push(items.pop());
        }
        items.push(item);
        while (auxillary.size() > 0) {
            items.push(auxillary.pop());
        }
    }
}
