package DSA;

public class MergeSort {
    long time;
    int size;
    MergeSort() {
        //long time1=System.nanoTime();
        //sort(arr,0, arr.length-1);
        //long time2=System.nanoTime();
        //this.time=time2-time1;

    }

    public void merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        for (int i = 0; i < n1; i++)
            left[i] = arr[p + i];
        for (int i = 0; i < n2; i++)
            right[i] = arr[q + 1 + i];
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
        }

    }

    public void sort(int[] arr, int p, int r) {
        this.size = arr.length;
        //agar in if payini nabashe az yeja be bad q hamvare sefr mishe vase sort(arr,p,q)
        if(p<r) {
            int q = (p + r) / 2;
            sort(arr, p, q);
            sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }

    }

}
