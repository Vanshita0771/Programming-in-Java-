import java.util.*;
 class Student implements Comparable<Student>{
     String name;
     int rank;
     Student(String name,int rank){
         this.name=name;
         this.rank=rank;
     }
    // @Override
    public int compareTo(Student s2){
         return this.rank-s2.rank;
     }
} 
public class Main
{
  
	public static void main(String[] args) {
	    //Priority Queue on basis of smallest integer with highest priority
	  PriorityQueue<Student> p=new PriorityQueue<>();
	  p.add(new Student("A",56)); //O(log(n))
	  p.add(new Student("B",7));
	  p.add(new Student("C",5));
	  p.add(new Student("D",1));
	  while(!p.isEmpty()){
	      System.out.println(p.peek().name+" "+p.peek().rank);//O(1)
	      p.remove();//O(n)
	  }
	  System.out.println();
	 
	}
}
