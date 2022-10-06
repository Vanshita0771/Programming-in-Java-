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
	  System.out.print("Factors of a:");
	  for(int i=1;i<=a;i++){
	      if(a%i==0){
	       count1++;
	       System.out.print(i+" ");
	      }
	  }
	  System.out.print("\nFactors of b:");
	  int count2=0;
	  for(int i=1;i<=b;i++){
	      if(b%i==0){
	       count2++;
	       System.out.print(i+" ");
	      }
	  }
	  int arr1[]=new int[count1];
	  int arr2[]=new int[count2];
	  int k=0;
	 for(int i=1;i<=a;i++){
	      if(a%i==0){
	       arr1[k++]=i;
	      }
	  }
	  k=0;
	 for(int i=1;i<=b;i++){
	      if(b%i==0){
	       arr2[k++]=i;
	      }
	  }
	  System.out.print("\nHCF:"); 
	  for(int i=count1-1;i>-1;i--){
	      int j;
	      for(j=count2-1;j>-1;j--){
	          if(arr1[i]==arr2[j]){
	              System.out.print(arr1[i]);
	              break;
	          }
	      }
	      if(j!=-1)
	           break;
	  }
	  
	}
}
