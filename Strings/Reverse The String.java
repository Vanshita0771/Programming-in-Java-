import java.util.*;
public class Main
{
	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  String x=sc.next();
	  x=x.concat("\0");
	  char[] y=x.toCharArray();
	  int i=0;
	  int count=0;
	  while(y[i]!='\0')
	  {
	      i++;
	      count++;
	  }
	  char[] a=new char[count];
	  i=0;
	  while(i!=count){
	   a[count-i-1]=y[i];
	   i++;
	  }
	  System.out.println(a);
	}
}