public class qs {

    public static void swap(int[] dat, int x, int y) {
        int temp = dat[x];
        dat[x] = dat[y];
        dat[y] = temp;
    }

    public static int partition(int[] a, int l, int r) {
        int piv = a[r-1];
        int i = l - 1;
        for (int current = l; current < r; current++) {
            if (a[current] <= piv) {
                i++;
                swap(a, current, i);
            }
        }

        swap(a, i+1, r-1);
        return i+1;
    }

    public static void sort(int[] a, int l, int r) {
        if (l < r) {
            int p = partition(a, l, r);
            sort(a, l, p-1);
            sort(a, p+1, r);
        }
    }

    public static void main(String[] args) {
        int [] dat = new int[]{5,3,2,0,2,4,10,9};
        sort(dat, 0, dat.length-1);
        for (int i : dat) {
            System.out.print(i + ", ");
        }
    }
}

