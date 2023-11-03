package DSA;

import java.util.Random;

public class Quicksort {

    long time;
    int size;

    public Quicksort(){
        //long time1 = System.nanoTime();
        //sort(arr,0,arr.length-1);
        //long time2 = System.nanoTime();
        //this.time = time2 - time1;

    }

    public int randomizedPartition(int []arr, int p, int r){
        Random random=new Random();
        //int i=random.nextInt(r);
        int i=(int)Math.random();
        int tmp=arr[r];
        arr[r]=arr[i];
        arr[i]=tmp;
        return partition(arr,p,r);

    }

    public int partition(int []arr, int p, int r) {
        int pivot = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
         int tmp=arr[r];
         arr[r]=arr[i+1];
         arr[i+1]=tmp;
         return i+1;
    }

    public void sort(int[] arr,int p, int r){
        this.size = arr.length;
        if(p<r) {



            int q = partition(arr, p, r);
            sort(arr,p,q-1);
            sort(arr,q+1,r);
        }
    }


}
