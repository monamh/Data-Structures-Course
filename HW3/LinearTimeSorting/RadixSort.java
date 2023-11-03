package LinearTimeSorting;

public class RadixSort {
    public static long sort(int[] a,int d){
        long time1 = System.nanoTime();
        int k=9;
        int power=1;
        int[] b=new int[a.length];
        for(int digit=d; digit>=1 ; digit--) {
            int[] c = new int[k + 1];
            for (int i = 0; i < k + 1; i++)
                c[i] = 0;
            for (int j = 0; j < a.length; j++)
                c[(a[j]/power)%10]++;
            for (int i = 1; i < k + 1; i++)
                c[i] += c[i - 1];
            for (int j = a.length - 1; j >= 0; j--) {
                b[c[(a[j]/power)%10] - 1] = a[j];
                c[(a[j]/power)%10]--;
            }
            //bayad copy she k arraye asli bar hasbe raghame i sort she bad berim raghame i+1
            for(int i=0; i<a.length; i++)
                a[i]=b[i];
            power*=10;
        }
//        for(int i=0; i<a.length ; i++)
//            System.out.println(a[i]);
        long time2 = System.nanoTime();
        //System.out.println("radixsort");
        return time2-time1;
    }
//    public int findMax(int[] x){
//            int max=x[0];
//            for(int i=1;i<x.length;i++){
//                if(x[i]>max)
//                    max=x[i];
//            }
//            return max;
//        }

//public static void main(String[] args) {
//    int[] unsorted={307,45,3,1421,56,7,23,22,66,66,208};
//    RadixSort.sort(unsorted,4);
//    for(int i=0; i<unsorted.length ; i++)
//        System.out.println(unsorted[i]);
//}

}