import java.util.*;
public class Main
{
	public static void main(String[] args) {
	   int n;
	   Scanner s=new Scanner(System.in);
	   System.out.print("Enter the number to find its factors:");
	   n=s.nextInt();
	   System.out.print("Factors are:");
	   for(int i=1;i<=n;i++){
	       if(n%i==0){
	           System.out.print(i+" ");
	       }
	   }
	}
	
}
