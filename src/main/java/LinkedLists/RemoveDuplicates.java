package LinkedLists;

import java.util.HashMap;
import java.util.Map;

/**
 * The goal is to remove duplicates from an unsorted linkedlist
 * _Using a singly linkedlist only_
 */
public class RemoveDuplicates {
  public static void main(String[] args) {
    Node n0 = new Node(4);
    Node n1 = new Node(4);
    Node n2 = new Node(5);
    Node n3 = new Node(4);
    Node n4 = new Node(4);
    Node n5 = new Node(4);

    n0.nextNode = n1;
    n1.nextNode = n2;
    n2.nextNode = n3;
    n3.nextNode = n4;
    n4.nextNode = n5;

    listEval(n0);
    n0 = removeDupes(n0);
    listEval(n0);
  }

  public static Node removeDupes(Node node) {
    Map<Integer, Integer> occurrenceMap = new HashMap<>();
    Node headNode = node;

    occurrenceMap.put(node.nodeVal, 1);

    while (node != null && node.nextNode != null) {
      if (occurrenceMap.containsKey(node.nextNode.nodeVal) && occurrenceMap.get(node.nextNode.nodeVal) == 1) {
        node.nextNode = node.nextNode.nextNode;
      } else {
        occurrenceMap.put(node.nextNode.nodeVal, 1);
        node = node.nextNode;
      }
    }
    return headNode;
  }

  public static void listEval(Node node) {
    System.out.print(node.nodeVal + "->");
    node = node.nextNode;
    while (node != null) {
      if (node.nextNode != null)
        System.out.print(node.nodeVal + "->");
      else
        System.out.print(node.nodeVal);
      node = node.nextNode;
    }
    System.out.println("");
  }
}
