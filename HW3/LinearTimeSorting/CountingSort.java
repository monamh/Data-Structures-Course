package LinearTimeSorting;

public class CountingSort {
    //public CountingSort(){}
    public static final long sort(int[] a,int[] b,int k){
        long time1 = System.nanoTime();
        int[] c=new int[k+1];
        for(int i=0; i<k+1; i++)
            c[i]=0;
        for(int j=0; j<a.length; j++)
            c[a[j]]++;
        //debug
        //for (int i=0; i<k+1 ; i++ )
            //System.out.println(c[i]);
        for(int i=1; i<k+1; i++)
            c[i]+=c[i-1];
        for(int j=a.length-1; j>=0; j--){
            b[c[a[j]]-1]=a[j];
            c[a[j]]--;
        }
        long time2 = System.nanoTime();
        return time2-time1;
    }

//
//public static void main(String[] args) {
//        int[] unsorted={35,4,340,12,54,3,28,260,72,3,34};
//        int b[] = new int[11];
//        CountingSort.sort(unsorted,b,340);
//        for(int i=0; i<b.length ; i++)
//            System.out.println(b[i]);
//}
}

