package EPI.Arrays;

public class QuickSort {
    public void swap(int[] input, int idx1, int idx2) {
        int temp = input[idx1];
        input[idx1] = input[idx2];
        input[idx2] = temp;
    }

    public int pivot(int[] input, int low, int high) {
        int pivot = input[high];
        int iteration = low - 1;

        for (int current = low; current < high; current++) {
            if (input[current] <= pivot) {
                iteration++;
                swap(input, iteration, current);
            }
        }

        swap(input, iteration+1, high);
        return iteration+1;
    }

    public void sort(int[] input, int low, int high) {
        if (low < high) {
            int pivot = pivot(input, low, high);
            sort(input, low, pivot - 1);
            sort(input, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] datArr = new int[]{50, 10, 12, 0, 1, 100, 4, 7};
        qs.sort(datArr, 0, datArr.length-1);
    }
}
