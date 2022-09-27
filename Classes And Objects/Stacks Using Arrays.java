import java.util.*;
class Stack{
    private int n=100;
    private int arr[]= new int[n];
    private int top;
    Stack(){
        top=-1;
    }
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(top==n-1){
            return true;
        }
        return false;
    }
    public void push(int data){
        if(isFull()){
            System.out.println("Stack is Full");
            return;
        }
    
         top=top+1;
         arr[top]=data;
         
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top--];
    }
    public void display(){
        System.out.println("---Display Stack---");
        System.out.println(top);
        for(int i=top;i>-1;i--){
            
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
}
public class Main
{
	public static void main(String[] args) {
		int choice;
		System.out.println("1 Push element into stack");
		System.out.println("2 Pop element from stack");
		System.out.println("3 Check whether stack is empty or not");
		System.out.println("4 Check whether stack is full or not");
		System.out.println("5 Display the stack");
	    Stack st=new Stack();
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
		              st.push(data);
		              break;
		              }
		       case 2:
		                System.out.println("Popped element:"+st.pop());
		                break;
		       case 3:
		              {
		               if(st.isEmpty())
		                    System.out.println("Stack is empty");
		               else
		                    System.out.println("Stack is not empty");
		               break;
		               }
		       case 4:
		              {
		               if(st.isFull())
		                    System.out.println("Stack is full");
		               else
		                    System.out.println("Stack is not full");
		               break;
		              }
		      case 5:
		              st.display();
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

