import java.util.*;
public class Main
{
	public static void main(String[] args) {
	  Scanner s=new Scanner(System.in);
	  int a,b;
	  System.out.println("Enter two numbers:");
	  a=s.nextInt();
	  b=s.nextInt();
	  int count1=0;
	  System.out.print("Prime factors of a:");
	  int temp=a;
	  int k=2;
	  while(temp>1){
	      if(temp%k==0){
	       count1++;
	       System.out.print(k+" ");
	       temp=temp/k;
	      }
	      else 
	       k++;
	  }
	  System.out.print("\nPrime factors of b:");
	  int count2=0;
	  temp=b;
	  k=2;
	 while(temp>1){
	      if(temp%k==0){
	       count2++;
	       System.out.print(k+" ");
	       temp/=k;
	      }
	      else 
	       k++;
	  }
	  int arr1[]=new int[count1];
	  int arr2[]=new int[count2];
	  
	  temp=a;
	  k=2;
	  int n=0;
	  while(temp>1){
	      if(temp%k==0){
	       arr1[n++]=k;
	       temp/=k;
	      }
	      else 
	       k++;
	  }
	  temp=b;
	  k=2;
	  n=0;
	  while(temp>1){
	      if(temp%k==0){
	       arr2[n++]=k;
	       temp/=k;
	      }
	      else 
	       k++;
	  }
	  System.out.print("\nHCF:"); 
	  int i=0;
	  int j=0;
	  int hcf=1;
	  while(i<count1&&j<count2){
	      if(arr1[i]==arr2[j]){
	          hcf*=arr1[i];
	          i++;
	          j++;
	      }
	      else if(arr1[i]>arr2[j]){
	         j++;
	      }
	      else 
	       i++;
	  }
	  System.out.print(hcf);
	}
}
