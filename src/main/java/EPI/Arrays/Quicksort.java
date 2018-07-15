package EPI.Arrays;

public class Quicksort {

    public int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = low - 1;
        for (int current = low; current < high; current ++) {
            if (A[current] <= pivot) {
                i++;

                int temp = A[current];
                A[current] = A[i];
                A[i] = temp;
            }
        }

        int tmp = A[i+1];
        A[i+1] = A[high];
        A[high] = tmp;

        return i+1;
    }

    public void sort(int[] A, int low, int high) {
        if (low < high) {
            int partition = partition(A, 0, high);
            sort(A, low, partition - 1);
            sort(A, partition + 1, high);
        }
    }

    public static void main(String[] args) {

        int[] datArr = new int[]{10, 80, 30, 90, 40, 50, 70};

        Quicksort sort = new Quicksort();
        sort.sort(datArr, 0, datArr.length - 1);
        for (int i : datArr) {
            System.out.print(i + ", ");
        }

    }
}
