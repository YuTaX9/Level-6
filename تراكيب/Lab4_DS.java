
package lab4_ds;

import java.util.LinkedList;
import java.util.Stack;


class Node {
    int data;
    Node next;
}

class StackLinkedList {
    
    static Node head =null;

    public boolean isEmpty(){
        return (head==null);
    }

    public void push(int num){
        Node newNode = new Node();
        newNode.data= num;
        newNode.next= head;
        head = newNode;
    }
    public void pop(){
        if(isEmpty())
            System.out.println("\nthe List is empty..!");
        else {
            System.out.println("pop number : "+head.data);
            head = head.next;
        }

    }
    public void Top(){
        if(isEmpty())
            System.out.println("\nthe list is empty..!");
        else {
            System.out.println("the top item: "+head.data);
        }
    }
    public void showall(){
        Node show = head;
        while (show!=null){
            System.out.print(show.data+">>");
            show=show.next;
        }
        System.out.println("\ndone");
    }
    
}

public class Lab4_DS {
    
    private LinkedList <Integer> list = new LinkedList<>();
    
    public int getHeadValue(){
        return list.peek();
    }
    
    public void push(int value){
        list.push(value);
    }
    
    public int pop(){
        return list.pop();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public static class BalanceChecker{
        
        public static boolean checkBalance(String exp){
            Stack <Character> stack = new Stack<>();
            for(int i = 0; i < exp.length(); i++){
                char curr = exp.charAt(i);
                if(curr == '(' || curr == '{' || curr == '['){
                    stack.push(curr);
                }
                if(curr == ')' || curr == '}' || curr == ']'){
                    if(stack.isEmpty()){
                        return false;
                    }
                    char last = stack.peek();
                    if(curr == ')' && last == '(' || curr == '}' && last == '{' || curr == ']' && last == '['){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
   
    public static void main(String[] args) {
        
        System.out.println("Hello world!");
        StackLinkedList Sl = new StackLinkedList();
        Sl.push(10);
        Sl.push(20);
        Sl.push(30);
        Sl.push(40);
        Sl.push(50);
        Sl.showall();
        Sl.Top();
        Sl.pop();
        Sl.showall();
        Sl.pop();
        Sl.showall();
        
        String exp = "()";
        
        System.out.println(BalanceChecker.checkBalance(exp));
        
    }
    
}

