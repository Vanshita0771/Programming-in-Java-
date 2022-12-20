//Find Itinerary From Tickets
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
	   HashMap<String,String> h1=new HashMap<>();
	   for(int i=0;i<n;i++)
	    h1.put(sc.next(),sc.next());
	    String start="";
	    HashSet<String> set=new HashSet<>();
	    for(String key:h1.keySet()){
	        set.add(h1.get(key));
	    }
	     for(String key:h1.keySet()){
	        if(!set.contains(key)){
	            start=key;
	            System.out.print(start+"->");
	            break;
	        }
	    }
	    while(true){
	        if(h1.containsKey(start)==false){
	            break;
	        }
	        System.out.print(h1.get(start)+"->");
	        start=h1.get(start);
	    }
	}
}
