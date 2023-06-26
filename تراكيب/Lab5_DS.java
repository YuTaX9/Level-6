
package lab5_ds;

class Queues {
    private static int size=6;
    private static int []arr = new int[size];
    private static int front , rear , length ;

    public Queues (){
        front= 0;
        rear= size-1 ;
        length=0;
    }

    public boolean isFull(){
       return (length==size);
    }

    public boolean isEmpty(){
        return (length == 0);

    }

    public void enQueue(int num){
        if(isFull())
            System.out.println("Queue is full\n");
        else {
            rear = (rear+1)%size;
            arr[rear]= num;
            System.out.println("\n Inserted : "+ arr[rear] );
            length++;

        }
    }

    public int deQueue(){
        int item;
        if (isEmpty()){
            System.out.println("\nQueue is empty");
            return (-1);

        }else {
            item=arr[front];
            front = (front+1) % size ;
            length--;

            System.out.println("deQueue is : "+ item);
            return (item);
        }
    }
    public void showall() {
        System.out.print("\n"+"the queue is :");

        for (int i = front; i < size; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println("\n");
    }

}

public class Lab5_DS {
    
    public static void main(String[] args) {
        
        Queues q = new Queues();
        q.enQueue(13);
        q.enQueue(4);
        q.enQueue(6);
        q.showall();
        q.deQueue();
        q.showall();
       
        
    }
    
}
