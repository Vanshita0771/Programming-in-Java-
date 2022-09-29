import java.util.*;
class Queue{
    private int n=5;
    private int arr[]=new int[15];
    private int front=-1;
    private int rear=-1;
    boolean isFull(){
        if(rear==n-1){
            return true;
        }
        return false;
    }
    boolean isEmpty(){
        if(front==-1){
            return true;
        }
        return false;
    }
    void enqueue(int data){
        if(isFull()){
            System.out.println("Element can't be inserted.Queue is full");
        }
        if(isEmpty()){
            front=rear=0;
            arr[rear]=data;
        }
        else{
            arr[++rear]=data;
        }
    }
    int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int temp=arr[front];
        if(front==rear){
            front=rear=-1;
        }
        else{
            front++;
        }
        return temp;
    }
    void display(){
        System.out.println("Displaying elements");
        for(int i=front;i<=rear;i++){
            System.out.println(arr[i]+" ");
        }
        
    }
}
public class Main
{
	public static void main(String[] args) {
		int choice;
		System.out.println("1 Push element into queue");
		System.out.println("2 Pop element from queue");
		System.out.println("3 Check whether queue is empty or not");
		System.out.println("4 Check whether queue is full or not");
		System.out.println("5 Display the queue");
	    Queue q=new Queue();
		do{
		    
		    System.out.print("Enter your choice:");
		    Scanner s=new Scanner(System.in);
		    choice=s.nextInt();
		    switch(choice){
		        case 1:
		             {
		              int data;
		              System.out.print("Enter the data:");
		              data=s.nextInt();
		              q.enqueue(data);
		              break;
		              }
		       case 2:
		                System.out.println("Popped element:"+q.dequeue());
		                break;
		       case 3:
		              {
		               if(q.isEmpty())
		                    System.out.println("Queue is empty");
		               else
		                    System.out.println("Queue is not empty");
		               break;
		               }
		       case 4:
		              {
		               if(q.isFull())
		                    System.out.println("Queue is full");
		               else
		                    System.out.println("Queue is not full");
		               break;
		              }
		      case 5:
		              q.display();
		              break;
		      default:
		             System.out.println("Invalid option");
		             break;
		    }
		    String ch;
		    System.out.print("Do you want to continue?yes/no:");
		    ch=s.next();
		    if(!ch.equals("yes")){
		        break;
		    }
		}
		while(true);
	}
	
}
