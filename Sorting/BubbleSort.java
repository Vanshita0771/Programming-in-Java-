import java.util.*;

public class BubbleSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int arr[]=new int[10];
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter the elements");
           for(int i=0;i<10;i++) {
        	   arr[i]=sc.nextInt();
           }
           for(int i=0;i<10;i++) {
        	   for(int j=0;j<9-i;j++) {
        		  if(arr[j]>arr[j+1]) {
        			 int temp=arr[j];
        			 arr[j]=arr[j+1];
        			 arr[j+1]=temp;
        			  
        		  }
        	   }
           }
        	   for(int i=0;i<10;i++) {
        		   System.out.print(arr[i]+" ");
        	   }
	}
}
