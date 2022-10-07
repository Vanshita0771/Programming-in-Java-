import java.util.*;
public class Main
{
    
	public static void main(String[] args) {
	    Scanner s=new Scanner(System.in);
	    System.out.println("Enter the start day");
	    int start=s.nextInt();
	    System.out.println("Enter the number of days");
	    int days=s.nextInt();
		System.out.println("Sun\t Mon\t Tue\t Wed\t Thru\t Fri\t Sat");
		for(int i=1;i<start;i++){
		    System.out.print("\t");
		}
		int count=1;
		for(int i=0;i<=7-start;i++){
		  System.out.print(count+"\t");
		  count++;
		}
		System.out.println();
		while(count<days){
		for(int i=0;i<7;i++){
		    System.out.print(count+"\t");
		    if(count==days)
		     break;
		    count++;
		}
		System.out.println();
		}
		
	}
}
