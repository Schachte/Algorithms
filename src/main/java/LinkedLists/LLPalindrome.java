package LinkedLists;

import java.util.Stack;

public class LLPalindrome {
  public static void main(String[] args) {
    Node n0 = new Node("r");
    Node n1 = new Node("a");
    Node n2 = new Node("c");
    Node n3 = new Node("e");
    Node n4 = new Node("c");
    Node n5 = new Node("a");
    Node n6 = new Node("r");

    n0.nextNode = n1;
    n1.nextNode = n2;
    n2.nextNode = n3;
    n3.nextNode = n4;
    n4.nextNode = n5;
    n5.nextNode = n6;

    Node fast = n0;
    Node slow = n0;

    Stack<String> palindromeStack = new Stack<>();

    while (fast != null && fast.nextNode != null) {
      palindromeStack.push(slow.nodeType);
      slow = slow.nextNode;
      fast = fast.nextNode.nextNode;
    }

    if (fast != null) {
      slow = slow.nextNode;
    }

    boolean notPalindrome = false;
    while (slow != null) {
      String val = palindromeStack.pop();

      if (!val.equals(slow.nodeType)) {
        notPalindrome = !notPalindrome;
        System.out.println("NOT A PALINDROME!");
        break;
      }

      slow = slow.nextNode;
    }

    if (!notPalindrome)
      System.out.println("PALNDROME!");
  }
}
