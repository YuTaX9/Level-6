
package lab3_ds;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    Node head;
    public LinkedList(){
        head = null;
    }
    
    public void addFront(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void addEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = newNode;
    }
    
    public void addMid(int data, int position){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node curr = head;
        for(int i = 1; i < position - 1; i++){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }
    
    public void printList(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.print("\n");
    }
    
    public boolean isEmpty(){
        if(head == null){
            System.out.println("List is empty");
            return head == null;
        }
        else{
            System.out.println("List is not empty");
            return head != null;
        }
    }
    
    public void removeEnd() {
        Node newNode = head;
        if (head != null){
            while(newNode.next.next != null){
                newNode = newNode.next;
            }
            newNode.next = null;
        }
        else
            System.out.println("list already empty");
    }
    
    public void removeFront() {
        if(head==null){
            return;
        }
        head = head.next;
    }
    
    public void remove(int x) {
        Node newNode = head;
        Node timp = newNode;
        if(head != null){
            while(newNode.data != x){
                timp = newNode;
                newNode = newNode.next;
            }
            timp.next = newNode.next;
        }
    }
    
    public void removeAll() {
        head = null;

    }
    
    public boolean search( int x){
        Node newNode = head;
        while(newNode != null){
            if(newNode.data == x){
                System.out.println("element exist");
                return true;
            }
            newNode = newNode.next;
        }
        System.out.println("element not exist");
        return false;
    }
    
    
}
public class Lab3_DS {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.isEmpty();
        
        list.addFront(1);
        list.addEnd(3);
        list.printList();
        
    }
    
}
