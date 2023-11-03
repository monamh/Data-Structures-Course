package DSA;

public class Heapsort {
    int heapSize;
    long time;
    int size;
    public Heapsort(){
        //heapSize=arr.length; //motmaen nistam vali yeja ghable max hepify o buildmaxheap bayad set she heapsize
        //long time1=System.nanoTime();
        //sort(arr);
        //long time2=System.nanoTime();
        //this.time=time2-time1;

    }

    public int leftChild(int i){
            return 2*i+1; //chon index az o shur mishe na 1
    }
    public int rightChild(int i){
            return 2*i+2;
    }
    public int parent(int i,int[] a){
        return (i-1)/2;
    }
    public void maxHeapify(int[] arr,int i) {
            int l = leftChild(i);
            int r = rightChild(i);
                int largest;
                if (l < heapSize && arr[l] > arr[i])
                    largest = l;
                else
                    largest = i;
                if (r < heapSize && arr[r] > arr[largest])
                    largest = r;
                if (largest != i) {
                    int tmp = arr[i];
                    arr[i] = arr[largest];
                    arr[largest] = tmp;
                    maxHeapify(arr, largest);
                }

    }
        public void buildMaxHeap(int[] arr){
            heapSize=arr.length;
            /*(int)Math.floor((double)*/
            for(int i=arr.length/2-1; i>=0; i--) {
                //arr.length/2 -1 chon index az 0 shuru mishe
                maxHeapify(arr, i);
            }
        }


        public void sort(int[] arr) {
            this.size = arr.length;
            buildMaxHeap(arr);
            for (int i = arr.length - 1; i > 0; i--) {
                int tmp = arr[0];
                arr[0] = arr[i];
                arr[i] = tmp;
                heapSize=heapSize-1;
                maxHeapify(arr, 0);
            }
        }



}