package DSA;

import java.util.Random;
import java.util.stream.IntStream;

public class RuntimeComparison {
    public static void main(String[] args){
        Random r=new Random();
        int m=100;
        All[] all = new All[100];
        for(int j=1;j<=m ;j++)
        {
            int[] a=new int[j];
            int[] b=new int[j];
            int[] c=new int[j];
            int[] d=new int[j];
            for(int i=0;i<j;i++) {
                a[i]=r.nextInt(100);
                //a[i]=i+1;
                //a[i] = (int)(Math.random()*100 + 1);
                b[i] = a[i];
                c[i] = a[i];
                d[i] = a[i];
            }
            Heapsort hh = new Heapsort();
            long time1 = System.nanoTime();
            hh.sort(a);
            long time2 = System.nanoTime();
            hh.time = time2-time1;


            InsertionSort ii = new InsertionSort();
            long time11 = System.nanoTime();
            ii.sort(b);
            long time22 = System.nanoTime();
            ii.time = time22-time11;


            MergeSort mm=new MergeSort();
            long time111 = System.nanoTime();
            mm.sort(c,0,c.length-1);
            long time222 = System.nanoTime();
            mm.time = time222-time111;

            Quicksort qq=new Quicksort();
            long time1111 = System.nanoTime();
            qq.sort(d,0,d.length-1);
            long time2222 = System.nanoTime();
            qq.time = time2222-time1111;

            all[j-1] = new All(hh,ii,mm,qq);
            //all[j-1]=new All(new Heapsort(a),new InsertionSort(b),new MergeSort(c),new Quicksort(d));
            System.out.println("heap : "+ hh.time +" arr "+hh.size + " Insertionsort : " + ii.time + " ii : "+ ii.size);
        }
        // araye darim ke x o y dare
        Chart chartt = new Chart(all);
    }
}
