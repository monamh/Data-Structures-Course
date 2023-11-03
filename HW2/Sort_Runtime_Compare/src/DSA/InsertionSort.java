package DSA;

public class InsertionSort {
    long time;
    int size;
    public InsertionSort(){

//        long time1=System.nanoTime();
//        sort(arr);
//        long time2=System.nanoTime();
//        this.time=time2-time1;

    }
    public void sort(int[] arr){
        this.size = arr.length;
        for(int j=1; j<arr.length; j++){
            int key=arr[j];
            int i=j-1;
            while(i>=0 && key<arr[i]) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i+1]=key;
        }
    }

}
