import java.util.*;
class node{
    int data;
    node next;
    node(int data){
       this.data=data;
       next=null;
    }
}

class hashIndexList{
    node head=null;
    node tail=null;
}
class hashIndexListOperation{
    hashIndexList[] arr;
    hashIndexListOperation(int size){
        arr=new hashIndexList[size];
        for(int i=0;i<size;i++){
            arr[i]=new hashIndexList();
        }
    }
    void insert(int data,int key){
        node n=new node(data);
         
        if(arr[key].head == null){
            arr[key].head=n;
            arr[key].tail=n;
        }
        else{
            arr[key].tail.next=n;
            arr[key].tail=n;
        }
    }
    int search(int data){
        int k=data%arr.length;
        node ptr=arr[k].head;
        if(arr[k].head==null)
         return 0;
        while(ptr!=null){
            if(ptr.data==data)
             return 1;
            ptr=ptr.next;
        }
        return 0;
    }
    void display(){
        int size=arr.length;
        for(int i=0;i<size;i++){
            if(arr[i].head!=null){
                System.out.print("Key: "+i);
            System.out.print(" Values:");
            node ptr=arr[i].head;
            while(ptr!=null){
                 System.out.print(ptr.data+" ");
                 ptr=ptr.next;
            }
             System.out.println();
            }
        }
    }
}
public class Main
{
	public static void main(String[] args) {
	
      Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the size of hash table");
	  int size=sc.nextInt();
	  hashIndexListOperation h1=new hashIndexListOperation(size);
	  System.out.println("Enter the data");
	  for(int i=0;i<size;i++){
	       int data=sc.nextInt();
	       h1.insert(data,data%size);
	  }
	  
	  System.out.println("Enter the value to search");
	  int value=sc.nextInt();
	  if(h1.search(value)==1){
	      System.out.println("Element found");
	  }
	  else{
	       System.out.println("Element not found");
	  }
	  
	  h1.display();
	}
}
