package StacksQueues;

/**
 * The overall premise is to create 3 stacks out of a single array
 */
public class StackOf3 {
    static String[] stackArr = createArr(9); // 3 stacks will have a max of 5 elements each
    static int noStacks = 3;
    static int[] sizeTracker = new int[stackArr.length/noStacks];

    public static void main(String[] args) {

        // Pushing an item to stack 2
        push(2, "hello1");
        push(2, "hello2");
        push(2, "hello3");
        push(1, "hello5");

        System.out.println(pop(2));
        System.out.println(pop(2));
        System.out.println(pop(2));
        System.out.println(pop(1));

        push(2, "hello2");
        System.out.println(pop(2));
    }

    public static String[] createArr(int size) {
        return new String[size];
    }

    /** Pushes a value to a specified stack */
    public static void push(int stack, String value) {
        // We will always pre-decrement the stack index for easier computation
        stack-=1;
        if (stack < 0 || stack >= stackArr.length/noStacks) {
            throw new IndexOutOfBoundsException("The specified stack is invalid");
        }

        if (sizeTracker[stack] >= stackArr.length/noStacks) {
            throw new IndexOutOfBoundsException("The stack " + stack + " is full!");
        }

        // Insert into the correct index
        stackArr[(stack*stackArr.length)/noStacks + sizeTracker[stack]++] = value;
    }

    // Pop the top of the specified stack
    public static String pop(int stack) {

        if (sizeTracker[stack-1] == 0) {
            throw new IndexOutOfBoundsException("The stack is empty for stack " + stack);
        }

        // Calculate the starting index of the specified stack
        int startingIndex = ((stack - 1)*stackArr.length)/noStacks;
        int shiftIndex = sizeTracker[stack-1]-1;
        String poppedVal = stackArr[startingIndex+shiftIndex];

        // Decrement based on popping
        stackArr[startingIndex+shiftIndex] = null;
        sizeTracker[stack-1]--;

        return poppedVal;
    }

    public static boolean isEmpty(int stack) {
        return sizeTracker[stack-1] == 0;
    }

}
