
package lab3_ds_double;
import java.util.NoSuchElementException;

class DoublyLinkedList{
    private Node head;
    private Node tail;
    private int size;
    
    private class Node{
        int data;
        Node next;
        Node prev;
        
        public Node(int data){
            this.data = data;
        }
    }
    
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public int size(){
        return size;
    }
    public boolean isEmptyList(){
        if(head == null){
            System.out.println("List is empty");
            return head == null;
        }
        else{
            System.out.println("List is not empty");
            return head != null;
        }
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void addFront(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
        head = newNode;
        tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addEnd(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
        head = newNode;
        tail = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public void addMid(int data, int position){
        if(position < 0 || position > size){
            throw new IllegalArgumentException("Invalid position");
        }
        if(position == 0){
            addFront(data);
            return;
        }
        if(position == size){
            addEnd(data);
            return;
        }
        Node curr = head;
        for(int i = 0; i < position; i++){
            curr = curr.next;
        }
        Node newNode = new Node(data);
        newNode.prev = curr.prev;
        newNode.next = curr;
        curr.prev.next = newNode;
        curr.prev = newNode;
        size++;
    }
    
    public void printList(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    
    public void removeFront(){
        if(isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        head = head.next;
        head.prev = null;
        size--;
    }
    
    public void removeEnd(){
        if(isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }
    
    public void removeMid(){
         if(isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        if(head == tail){
            head = tail = null;
            size = 0;
            return;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        if(slow.next != null){
            slow.next.prev = prev;
        }
        size--;
    }
    
    public void removeAll() {
        head = null;
        tail = null;
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

public class Lab3_DS_Double {


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.isEmptyList();
        list.addFront(1);
        list.addEnd(5);
        list.addMid(3, 1);
        
        list.addFront(2);
        list.addEnd(7);
        list.addMid(4, 4);
        list.isEmptyList();
        list.printList();
        
        list.removeFront();
        list.printList();
        
        list.removeEnd();
        list.printList();
        
        list.removeMid();
        list.printList();
        
        list.search(3);
        
        list.removeAll();
        list.search(5);
        list.isEmptyList();
        
        
    }
    
}
