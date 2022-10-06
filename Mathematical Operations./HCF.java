import java.util.*;
public class Main
{
	public static void main(String[] args) {
	  Scanner s=new Scanner(System.in);
	  int a,b;
	  System.out.println("Enter two numbers:");
	  a=s.nextInt();
	  b=s.nextInt();
	  int min=Math.min(a,b);
	  int hcf=0;
	  for(int i=1;i<=min;i++){
	      if((a%i==0)&&(b%i==0)){
	         hcf=i;
	      }
	  }
	  System.out.println("HCF:"+hcf);
	}
}
