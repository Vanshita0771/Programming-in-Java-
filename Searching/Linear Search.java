import java.util.*;
public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int arr[]=new int[10];
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter the elements");
           for(int i=0;i<10;i++) {
        	   arr[i]=sc.nextInt();
           }
           System.out.println("Enter the key to be searched");
           int a=sc.nextInt();
           boolean flag=false;
            int i;
          for( i=0;i<10;i++) {
             if(arr[i]==a)
             {
            	 flag=true;
            	 break;
             }
        	}
          if(flag)
        	  System.out.println("Element found at index "+i);
          else
        	  System.out.println("Element not found");
	}

}
