package BasicDataStructures;

//ketab farz karde tule araye ba tule saf yekie
public class Queue {
    int maxSize;
    int[] q;
    int head;
    int tail;
    int sizeoOfElements;
    public Queue(int maxSize){
        this.maxSize=maxSize;
        head=-1;
        tail=0;
        q=new int[maxSize];
        sizeoOfElements=0;

    }
    public void enqueue(int newMember) {
        //khodam ezafe kardam
        if (sizeoOfElements==maxSize-1)
            System.out.println("overflow");
        else {
            q[tail] = newMember;
            if (tail == maxSize - 1)
                //tebghe ketab dayereE amal mikone
                tail = 0;
            else
                tail++;
            //khodam: saf age bara avalin bar dare por mishe:
            if (head == -1)
                head++;
            sizeoOfElements++;
        }
        return;
    }

    public int dequeue(){
        //khodam sharte payino ezafe kardam chon age list khali bashe chizi baraye hazf nadarim
        if(sizeoOfElements==0) {
            System.out.println("underflow");
            return -1;
        }
        else {
            int x = q[head];
            if (head == maxSize - 1)
                head = 0;
            else
                head++;
            sizeoOfElements--;
            return x;
        }
    }
    public void printElements(){
        System.out.println("the elemenst of queue are");
        if(tail>head){
           for (int i = head; i < tail; i++)
                System.out.println(q[i]);
        }
         else{
             for(int i=head; i<maxSize; i++)
                 System.out.println(q[i]);
             for(int i=0;i<tail;i++)
                 System.out.println(q[i]);

        }

    }

    public static void main(String[] args){
        Queue x=new Queue(10);
        x.enqueue(1);
        x.enqueue(2);
        x.enqueue(3);
        x.enqueue(4);
        x.enqueue(5);
        x.enqueue(6);
        x.dequeue();
        x.dequeue();
        x.dequeue();
        x.enqueue(7);
        x.printElements();
        return;
    }
}


