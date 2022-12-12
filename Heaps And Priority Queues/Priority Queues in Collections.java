import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    //Priority Queue on basis of smallest integer with highest priority
	  PriorityQueue<Integer> p=new PriorityQueue<>();
	  p.add(2); //O(log(n))
	  p.add(9);
	  p.add(7);
	  p.add(1);
	  while(!p.isEmpty()){
	      System.out.print(p.peek()+" ");//O(1)
	      p.remove();//O(n)
	  }
	  System.out.println();
	  //Priority Queue on basis of largest integer with higher priority
	   PriorityQueue<Integer> p2=new PriorityQueue<>(Comparator.reverseOrder());
	  p2.add(2); //O(log(n))
	  p2.add(9);
	  p2.add(7);
	  p2.add(1);
	  while(!p2.isEmpty()){
	      System.out.print(p2.peek()+" ");//O(1)
	      p2.remove();//O(n)
	  }
	}
}
