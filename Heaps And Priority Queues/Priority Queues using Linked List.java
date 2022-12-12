import java.util.*;
class PriorityQueue{
    class node{
        int data;
        int key;
        node next;
        node(int data,int key){
            this.data=data;
            this.key=key;
        }
    }
    node head;
    PriorityQueue(){
        head=null;
    }
    void peek(){
         System.out.println(head.key+"\t"+head.data);
    }
    void insert(int key,int data){
        node n=new node(data,key);
        if(head==null){
          head=n;
        }
        else if(head.key>n.key)
        {
           n.next=head;
           head=n;
        }
        else{
            node ptr=head;
            while(ptr.next!=null){
                if(ptr.next.key>n.key){
                    n.next=ptr.next;
                    ptr.next=n;
                    return;
                }
                ptr=ptr.next;
            }
            ptr.next=n;
        }
    }
    void display(){
        node ptr=head;
         System.out.println("Keys\tValues");
        while(ptr!=null){
            System.out.println(ptr.key+"\t"+ptr.data);
            ptr=ptr.next;
        }
    }
    int delete(int key){
        if(head==null){
            System.out.println("Priority Queue is empty");
            return -1;
        }
        int temp;
        if(head.key==key){
            temp=head.data;
            head=head.next;
            return temp;
        }
        else{
            node ptr=head;
            while(ptr.next!=null){
                if(ptr.next.key==key){
                    temp=ptr.next.data;
                    ptr.next=ptr.next.next;
                    return temp;
                }
                ptr=ptr.next;
            }
            return -1;
        }
        
    }
}
public class Main
{
   
	public static void main(String[] args) {
	  PriorityQueue p=new PriorityQueue();
	  p.insert(8,12);
	  p.insert(7,10);
	  p.insert(9,19);
	  p.insert(1,13);
	  p.insert(5,14);
	  p.insert(4,11);
	  p.insert(10,78);
	  p.display();
	  System.out.println(p.delete(-10));
	  p.display();
	}
}
