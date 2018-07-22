public class RightRotateRecursive {
    public static void rotate(int[] a, int numRotations) {
        for (int i = 0; i < numRotations; i++) {
            rotate(a);
        }
    }

    public static void rotate(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int tmp = a[i+1];
            a[i+1] = a[0];
            a[0] = tmp;
        }
        print(a);
    }

    public static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println("\n");
    }

    public static void main (String[] args) {
        int[] dat = new int[]{2,1,3,6,8};
        rotate(dat, 4);
    }
}
