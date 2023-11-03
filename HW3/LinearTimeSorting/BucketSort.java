package LinearTimeSorting;

import java.util.LinkedList;

public class BucketSort {
    public static long sort(float[] a) {
        long time1 = System.nanoTime();
        int n = a.length;
        LinkedList[] buckets = new LinkedList[a.length];
        for (int i = 0; i < a.length; i++) {
            buckets[i] = new LinkedList<Float>();
        }
        for (int i = 0; i < a.length; i++) {
            buckets[(int) (n * a[i])].add(a[i]); //wow k a[i] o be onvane obj gereft
        }
        for (int i = 0; i < a.length; i++) {
            insertionSort_forList(buckets[i]);
//            System.out.println("bucket " + i);
//            for (int q=0;q<buckets[i].size();q++) {
//                System.out.println(buckets[i].get(q));
//            }
        }

        //concat
        int counter=0;
        for(int i = 0; i < a.length; i++){
            for(int j=0; j<buckets[i].size();j++) {
                a[counter] = (float) buckets[i].get(j);
                counter++;
            }

        }
        long time2 = System.nanoTime();
        System.out.println(time2-time1);
        return time2-time1;

    }

    public static void insertionSort_forList(LinkedList a) {
        for (int j = 1; j < a.size(); j++) {
            float key = (float) a.get(j);
            int i = j - 1;
            while (i >= 0 && key < (float) a.get(i)) {
                a.set(i + 1, a.get(i));
                i--;
            }
            a.set(i + 1, key);
        }
        return;
    }

//    public static void main(String[] args){
//        float arr[]={(float)0.71,(float)0.529,(float)0.3,(float)0.52,(float)0.92,(float)0.3,(float)0.64,(float)0.978,(float)0.543,(float)0.75,(float)0.83,(float)0.1};
//        BucketSort.sort(arr);
//        for(int i=0; i<arr.length;i++)
//            System.out.println(arr[i]);
//    }
}
