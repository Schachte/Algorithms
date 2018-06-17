package StacksQueues;

import java.util.Stack;

/** The goal is to find the min value in a stack in constant time */
public class StackMin {
   static int stackMin = Integer.MAX_VALUE;
   static Stack<Integer> stack = new Stack();

   public static void main(String[] args) {
      pushStack(5);
      pushStack(2);
      pushStack(0);
      pushStack(10);
      pushStack(-10);
      pushStack(100);
      stackMin();
   }

   public static void pushStack(int item) {
      if (item < stackMin) stackMin = item;
      stack.push(item);
   }

   public static void stackMin() {
      System.out.println("The minimum value in the stack is " + stackMin);
   }
}
