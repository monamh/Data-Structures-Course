package BasicDataStructures;

public class Stack {
    private static int maxSize;
    private int top;
    private int[] s;

    public Stack(int maxSize){
        this.maxSize=maxSize;
        s=new int[maxSize];
        top=-1;
    }
    public boolean stackEmpty(){
        if (top==-1)
            return true;
        else return false;
    }
    public void push(int newMember){
        if (top==maxSize-1) {
            System.out.println("overflow");
            return;
        }
        s[++top]=newMember;
        return;
    }
    public int pop(){
        if(stackEmpty())
            System.out.println("underflow");
        return s[top--];
    }
//    public void check(){
//        if(top>-1) {
//            System.out.println("top index is " + top);
//            System.out.println("top element is " + s[top]);
//        }
//        return;
//    }

    public void print(){
        for(int i=top; i>=0; i--)
            System.out.println(s[i]);
    }


    public static void main(String[] args) {
        Stack x=new Stack(6);
        x.push(9);
        x.pop();
        x.pop();
        System.out.println("element removed is: "+x.pop());
        x.print();

    }
}
