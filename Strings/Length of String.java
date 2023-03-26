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
	  System.out.print("Length of string: "+count);
	}
}
