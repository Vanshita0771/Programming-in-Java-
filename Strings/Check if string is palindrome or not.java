import java.util.*;
public class Main
{
	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  String x=sc.next();
	  int i=0,j=x.length()-1;
	  boolean isPalindrome=true;
	  while(i<=j){
	      if(x.charAt(i)!=x.charAt(j))
	       {
	           isPalindrome=false;
	           break;
	       }
	       i++;
	       j--;
	  }
	  if(isPalindrome) System.out.println("Palindrome");
	  else System.out.println("Not A Palindrome");
	}
}
