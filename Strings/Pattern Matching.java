import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String text=sc.next();
		String patt=sc.next();
		int n=text.length();
		int m=patt.length();
		for(int i=0;i<=n-m;i++){
		    String a=text.substring(i,i+m);
		    if(a.equals(patt))
		     System.out.println(i+" ");
		}
	}
}
